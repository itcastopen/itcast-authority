package com.itheima.authority.api.v1.hystrix;

import com.itheima.authority.api.v1.UserApi;
import com.itheima.authority.api.v1.dto.UserDTO;
import com.itheima.authority.common.R;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFailback implements UserApi {
    @Override
    public R<List<UserDTO>> list(List<Long> ids, Long stationId, String name, Long orgId, String account) {
        return R.timeout();
    }

    @Override
    public R<UserDTO> get(Long id) {
        return R.timeout();
    }

    @Override
    public R<UserDTO> getByAccount(String account) {
        return R.timeout();
    }
}
