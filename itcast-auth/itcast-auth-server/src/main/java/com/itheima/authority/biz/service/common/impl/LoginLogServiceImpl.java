package com.itheima.authority.biz.service.common.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.dao.common.LoginLogMapper;
import com.itheima.authority.biz.service.auth.UserService;
import com.itheima.authority.biz.service.common.LoginLogService;
import com.itheima.authority.entity.auth.User;
import com.itheima.authority.entity.common.LoginLog;
import com.itheima.tools.common.constant.CacheKey;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 * 业务实现类
 * 系统日志
 * </p>
 */
@Slf4j
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {
    @Autowired
    private UserService userService;
    @Autowired
    private CacheChannel cache;

    private final static String[] BROWSER = new String[]{
            "Chrome", "Firefox", "Microsoft Edge", "Safari", "Opera"
    };
    private final static String[] OPERATING_SYSTEM = new String[]{
            "Android", "Linux", "Mac OS X", "Ubuntu", "Windows 10", "Windows 8", "Windows 7", "Windows XP", "Windows Vista"
    };

    private static String simplifyOperatingSystem(String operatingSystem) {
        for (String b : OPERATING_SYSTEM) {
            if (StrUtil.containsIgnoreCase(operatingSystem, b)) {
                return b;
            }
        }
        return operatingSystem;
    }

    private static String simplifyBrowser(String browser) {
        for (String b : BROWSER) {
            if (StrUtil.containsIgnoreCase(browser, b)) {
                return b;
            }
        }
        return browser;
    }
    /**
     * 记录登录日志
     *
     * @param account     账号
     * @param ua          浏览器
     * @param ip          客户端IP
     * @param location    客户端地址
     * @param description 登陆描述消息
     * @return
     */
    @Override
    public LoginLog save(String account, String ua, String ip, String location, String description) {
        User user = this.userService.getByAccount(account);
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);
        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        LoginLog loginLog = LoginLog.builder()
                .account(account).location(location)
                .loginDate(LocalDate.now())
                .description(description)
                .requestIp(ip).ua(ua).userName(account)
                .browser(simplifyBrowser(browser.getName())).browserVersion(userAgent.getBrowserVersion().getVersion())
                .operatingSystem(simplifyOperatingSystem(operatingSystem.getName()))
                .build();
        if (user != null) {
            loginLog.setUserId(user.getId()).setUserName(user.getName());
        }

        super.save(loginLog);


        LocalDate now = LocalDate.now();
        LocalDate tenDays = now.plusDays(-9);
        this.cache.evict(CacheKey.LOGIN_LOG_TOTAL, CacheKey.buildKey());
        this.cache.evict(CacheKey.LOGIN_LOG_TODAY, CacheKey.buildKey(now));
        this.cache.evict(CacheKey.LOGIN_LOG_TODAY_IP, CacheKey.buildKey(now));
        this.cache.evict(CacheKey.LOGIN_LOG_TEN_DAY, CacheKey.buildKey(tenDays, null));
        this.cache.evict(CacheKey.LOGIN_LOG_TEN_DAY, CacheKey.buildKey(tenDays, account));
        this.cache.evict(CacheKey.LOGIN_LOG_BROWSER, CacheKey.buildKey());
        this.cache.evict(CacheKey.LOGIN_LOG_SYSTEM, CacheKey.buildKey());

        return loginLog;
    }
}
