package com.itheima.authority.api.v1;

import com.itheima.authority.api.v1.dto.LoginExternalDTO;
import com.itheima.authority.api.v1.hystrix.LoginFailback;
import com.itheima.authority.common.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 登录 API
 */
@FeignClient(name = "${itcast.feign.authority-server:itcast-auth-server}", url = "${itcast.feign.authority-server-url:}", fallback = LoginFailback.class, path = "/anno")
public interface LoginApi {

    /**
     * 登录
     *
     * @param account  用户名 账号
     * @param password 密码
     * @return
     */
    @PostMapping(value = "/externalLogin")
    R<LoginExternalDTO> externalLogin(
            @RequestParam(value = "account") String account,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "applicationId") String applicationId);

}
