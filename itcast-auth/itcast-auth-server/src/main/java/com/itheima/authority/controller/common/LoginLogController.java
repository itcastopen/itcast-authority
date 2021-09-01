package com.itheima.authority.controller.common;


import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.authority.biz.service.auth.UserService;
import com.itheima.authority.biz.service.common.LoginLogService;
import com.itheima.authority.entity.common.LoginLog;
import com.itheima.tools.base.BaseController;
import com.itheima.tools.base.R;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import com.itheima.tools.database.mybatis.conditions.query.LbqWrapper;
import com.itheima.tools.log.annotation.SysLog;
import com.itheima.tools.log.util.AddressUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 前端控制器
 * 登录日志
 * </p>
 *
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/loginLog")
@Api(value = "LoginLog", tags = "登录日志")
public class LoginLogController extends BaseController {

    @Autowired
    private LoginLogService loginLogService;
    @Autowired
    private UserService userService;

    @ApiOperation(value = "分页查询登录日志", notes = "分页查询登录日志")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @GetMapping("/page")
    public R<IPage<LoginLog>> page(LoginLog data) {
        IPage<LoginLog> page = this.getPage();
        // 构建值不为null的查询条件
        LbqWrapper<LoginLog> query = Wraps.<LoginLog>lbQ()
                .eq(LoginLog::getUserId, data.getUserId())
                .likeRight(LoginLog::getAccount, data.getAccount())
                .likeRight(LoginLog::getRequestIp, data.getRequestIp())
                .like(LoginLog::getLocation, data.getLocation())
                .leFooter(LoginLog::getCreateTime, this.getEndCreateTime())
                .geHeader(LoginLog::getCreateTime, this.getStartCreateTime())
                .orderByDesc(LoginLog::getId);
        this.loginLogService.page(page, query);
        return this.success(page);
    }

    @ApiOperation(value = "新增登录日志", notes = "新增登录日志不为空的字段")
    @GetMapping("/anno/login/{account}")
    public R<LoginLog> save(@NotBlank(message = "用户名不能为为空") @PathVariable String account, @RequestParam(required = false, defaultValue = "登陆成功") String description) {
        String ua = StrUtil.sub(this.request.getHeader("user-agent"), 0, 500);
        String ip = ServletUtil.getClientIP(this.request);
        String location = AddressUtil.getRegion(ip);
        // update last login time
        this.userService.updateLoginTime(account);
        LoginLog loginLog = this.loginLogService.save(account, ua, ip, location, description);
        return this.success(loginLog);
    }
}
