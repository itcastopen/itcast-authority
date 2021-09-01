package com.itheima.authority.controller.auth;


import com.itheima.authority.biz.service.auth.ValidateCodeService;
import com.itheima.authority.biz.service.auth.impl.AuthManager;
import com.itheima.authority.dto.auth.LoginDTO;
import com.itheima.authority.dto.auth.LoginExternalDTO;
import com.itheima.authority.dto.auth.LoginParamDTO;
import com.itheima.tools.base.BaseController;
import com.itheima.tools.base.R;
import com.itheima.tools.exception.BizException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 客户端获取token
 * jwt token管理
 */
@RestController
@RequestMapping("/anno")
@Api(value = "UserAuthController", tags = "登录")
@Slf4j
public class LoginController extends BaseController {

    @Autowired
    private AuthManager authManager;

    @Autowired
    private ValidateCodeService validateCodeService;


    /**
     * 租户登录
     *
     * @param login
     * @return
     * @throws BizException
     */
    @ApiOperation(value = "登录", notes = "登录")
    @PostMapping(value = "/login")
    public R<LoginDTO> loginTx(@Validated @RequestBody LoginParamDTO login) throws BizException {
        log.info("account={}", login.getAccount());
        if (this.validateCodeService.check(login.getKey(), login.getCode())) {
            return this.authManager.login(login.getAccount(), login.getPassword());
        }
        return this.success(null);
    }

    /**
     * 刷新token
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "仅供测试使用", notes = "仅供测试使用")
    @GetMapping(value = "/token")
    @Deprecated
    public R<LoginDTO> tokenTx(
            @RequestParam(value = "account") String account,
            @RequestParam(value = "password") String password) throws BizException {
        return this.authManager.login(account, password);
    }

    /**
     * 刷新token
     *
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "外部系统登录", notes = "外部系统登录")
    @PostMapping(value = "/externalLogin")
    public R<LoginExternalDTO> externalLogin(
            @RequestParam(value = "account") String account,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "applicationId") String applicationId) throws BizException {
        return this.authManager.externalLogin(account, password,applicationId);
    }

    /**
     * 获取验证码
     *
     * @param key
     * @param response
     * @throws IOException
     */
    @ApiOperation(value = "验证码", notes = "验证码")
    @GetMapping(value = "/captcha", produces = "image/png")
    public void captcha(@RequestParam(value = "key") String key, HttpServletResponse response) throws IOException {
        this.validateCodeService.create(key, response);
    }
}
