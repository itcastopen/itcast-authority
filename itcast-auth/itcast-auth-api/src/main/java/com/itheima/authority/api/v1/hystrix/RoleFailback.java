package com.itheima.authority.api.v1.hystrix;

import com.itheima.authority.api.v1.RoleApi;
import com.itheima.authority.api.v1.dto.RoleDTO;
import com.itheima.authority.api.v1.dto.RoleResourceDTO;
import com.itheima.authority.common.R;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleFailback implements RoleApi {
    @Override
    public R<List<Long>> findUserIdByCode(String[] codes) {
        return R.timeout();
    }

    @Override
    public R<List<Long>> findRoleByUserId(Long id) {
        return R.timeout();
    }

    @Override
    public R<List<RoleResourceDTO>> findAllRoles() {
        return R.timeout();
    }

    @Override
    public R<List<RoleDTO>> list(Long userId) {
        return R.timeout();
    }
}
