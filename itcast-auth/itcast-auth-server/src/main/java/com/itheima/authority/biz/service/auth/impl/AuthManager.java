package com.itheima.authority.biz.service.auth.impl;

import com.itheima.authority.biz.service.auth.ResourceService;
import com.itheima.authority.biz.service.auth.UserService;
import com.itheima.authority.biz.service.core.ApplicationService;
import com.itheima.authority.biz.utils.TimeUtils;
import com.itheima.authority.dto.auth.LoginDTO;
import com.itheima.authority.dto.auth.LoginExternalDTO;
import com.itheima.authority.dto.auth.ResourceQueryDTO;
import com.itheima.authority.dto.auth.UserDTO;
import com.itheima.authority.entity.auth.Resource;
import com.itheima.authority.entity.auth.User;
import com.itheima.authority.entity.core.Application;
import com.itheima.tools.auth.server.utils.JwtTokenServerUtils;
import com.itheima.tools.auth.utils.JwtUserInfo;
import com.itheima.tools.auth.utils.Token;
import com.itheima.tools.base.R;
import com.itheima.tools.context.BaseContextHandler;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import com.itheima.tools.database.mybatis.conditions.query.LbqWrapper;
import com.itheima.tools.dozer.DozerUtils;
import com.itheima.tools.exception.code.ExceptionCode;
import com.itheima.tools.utils.BizAssert;
import com.itheima.tools.utils.NumberHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 认证业务类
 */
@Service
@Slf4j
public class AuthManager {
    @Autowired
    private JwtTokenServerUtils jwtTokenServerUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private DozerUtils dozer;
    @Autowired
    private ApplicationService applicationService;


    /**
     * 登陆
     *
     * @param account
     * @param password
     * @return
     */
    private R<LoginDTO> simpleLogin(String account, String password) {
        // 2. 验证登录
        R<User> result = this.getUser(account, password);
        if (result.getIsError()) {
            return R.fail(result.getCode(), result.getMsg());
        }
        User user = result.getData();

        // 3, token
        Token token = this.getToken(user);

        // 缓存token 缓存时间要超过token 失效时间
        List<Resource> resourceList = this.resourceService.findVisibleResource(ResourceQueryDTO.builder().userId(user.getId()).build());
        log.info("resourceList {} {}", resourceList.size(), resourceList);
        List<String> permissionsList = resourceList.stream().filter(item -> item != null).map(Resource::getCode).collect(Collectors.toList());
        log.info("account={}", account);
        if (user.getId() < 10L) {
            log.info("超级管理员");
            permissionsList = resourceService.list().stream().filter(item -> item != null).map(Resource::getCode).collect(Collectors.toList());
        }
        return R.success(LoginDTO.builder().user(this.dozer.map(user, UserDTO.class)).permissionsList(permissionsList).token(token).build());
    }

    /**
     * 账号登录
     *
     * @param account
     * @param password
     * @return
     */
    public R<LoginDTO> login(String account, String password) {
        return this.simpleLogin(account, password);
    }

    /**
     * 生成token
     *
     * @param user
     * @return
     */
    private Token getToken(User user) {
        JwtUserInfo userInfo = new JwtUserInfo(user.getId(), user.getAccount(), user.getName(), user.getOrgId(), user.getStationId());

        Token token = this.jwtTokenServerUtils.generateUserToken(userInfo, null);
        log.info("token={}", token.getToken());
        return token;
    }

    /**
     * 校验用户名密码并返回用户
     *
     * @param account
     * @param password
     * @return
     */
    private R<User> getUser(String account, String password) {
        User user = this.userService.getByAccount(account);
        // 密码错误
        String passwordMd5 = DigestUtils.md5Hex(password);
        if (user == null) {
            return R.fail(ExceptionCode.JWT_USER_INVALID);
        }


        if (!user.getPassword().equalsIgnoreCase(passwordMd5)) {
            this.userService.updatePasswordErrorNumById(user.getId());
            return R.fail("用户名或密码错误!");
        }

        // 密码过期
        if (user.getPasswordExpireTime() != null) {
            BizAssert.gt(LocalDateTime.now(), user.getPasswordExpireTime(), "用户密码已过期，请修改密码或者联系管理员重置!");
        }

        // 用户禁用
        BizAssert.isTrue(user.getStatus(), "用户被禁用，请联系管理员！");

        // 用户锁定
        Integer maxPasswordErrorNum = NumberHelper.getOrDef(user.getPasswordErrorNum(), 0);
        Integer passwordErrorNum = NumberHelper.getOrDef(user.getPasswordErrorNum(), 0);
        if (maxPasswordErrorNum > 0 && passwordErrorNum > maxPasswordErrorNum) {
            log.info("当前错误次数{}, 最大次数:{}", passwordErrorNum, maxPasswordErrorNum);

            LocalDateTime passwordErrorLockTime = TimeUtils.getPasswordErrorLockTime("0");
            log.info("passwordErrorLockTime={}", passwordErrorLockTime);
            if (passwordErrorLockTime.isAfter(user.getPasswordErrorLastTime())) {
                return R.fail("密码连续输错次数已达到%s次,用户已被锁定~", maxPasswordErrorNum);
            }
        }

        // 错误次数清空
        this.userService.resetPassErrorNum(user.getId());
        return R.success(user);
    }

    public R<LoginExternalDTO> externalLogin(String account, String password, String applicationId) {

        R<User> result = this.getUser(account, password);
        if (result.getIsError()) {
            return R.fail(result.getCode(), result.getMsg());
        }
        User user = result.getData();

        BaseContextHandler.setUserId(user.getId());

        LbqWrapper<Application> query = Wraps.lbQ();
        query.eq(Application::getId, Long.valueOf(applicationId));
        query.orderByDesc(Application::getCreateTime);
        List<Application> applications = applicationService.currentList(query);
        if (CollectionUtils.isEmpty(applications)) {
            return R.fail(R.FAIL_CODE, "用户没有当前应用的权限");
        }

        // 缓存token 缓存时间要超过token 失效时间
        List<Resource> resourceList = this.resourceService.findVisibleResource(ResourceQueryDTO.builder().userId(user.getId()).build());
        log.info("resourceList {} {}", resourceList.size(), resourceList);
        List<String> permissionsList = resourceList.stream().filter(item -> item != null).map(Resource::getCode).collect(Collectors.toList());

        log.info("account={}", account);
        return R.success(LoginExternalDTO.builder().user(this.dozer.map(user, UserDTO.class)).permissionsList(permissionsList).build());
    }
}
