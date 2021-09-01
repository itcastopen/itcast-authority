package com.itheima.authority.biz.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.authority.dto.auth.RoleResourceDTO;
import com.itheima.authority.dto.auth.RoleSaveDTO;
import com.itheima.authority.dto.auth.RoleUpdateDTO;
import com.itheima.authority.entity.auth.Role;

import java.util.List;

/**
 * <p>
 * 业务接口
 * 角色
 * </p>
 */
public interface RoleService extends IService<Role> {

    List<Role> removeByIdWithUnUse(List<Long> ids);

    List<Role> findRoleByUserId(Long userId);

    void saveRole(RoleSaveDTO data, Long userId);

    void updateRole(RoleUpdateDTO role, Long userId);

    List<RoleResourceDTO> findAllRolesWithResource();

    List<Role> findAllRoleByUserId(Long id);
}
