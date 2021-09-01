package com.itheima.authority.api.v1.hystrix;

import com.itheima.authority.api.v1.LoginApi;
import com.itheima.authority.api.v1.dto.LoginExternalDTO;
import com.itheima.authority.common.R;
import org.springframework.stereotype.Component;

@Component
public class LoginFailback implements LoginApi {
    @Override
    public R<LoginExternalDTO> externalLogin(String account, String password, String applicationId) {
        return R.timeout();
    }
}
