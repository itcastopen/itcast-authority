package com.itheima.gateway.service;

import com.itheima.authority.api.v1.dto.RoleResourceDTO;

import java.util.List;

public interface RoleAuthService {

    List<RoleResourceDTO> findAllRoles();

    List<Long> findRoleByUserId(Long id);
}
