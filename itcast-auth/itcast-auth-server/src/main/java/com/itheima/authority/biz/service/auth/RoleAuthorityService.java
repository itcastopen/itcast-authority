package com.itheima.authority.biz.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.authority.dto.auth.RoleAuthoritySaveDTO;
import com.itheima.authority.dto.auth.UserRoleSaveDTO;
import com.itheima.authority.entity.auth.RoleAuthority;
import com.itheima.authority.dto.auth.RoleAuthoritySaveDTO;
import com.itheima.authority.dto.auth.UserRoleSaveDTO;
import com.itheima.authority.entity.auth.RoleAuthority;

/**
 * <p>
 * 业务接口
 * 角色的资源
 * </p>
 *
 */
public interface RoleAuthorityService extends IService<RoleAuthority> {

    /**
     * 给用户分配角色
     *
     * @param userRole
     * @return
     */
    boolean saveUserRole(UserRoleSaveDTO userRole);

    /**
     * 给角色重新分配 权限（资源/菜单）
     *
     * @param roleAuthoritySaveDTO
     * @return
     */
    boolean saveRoleAuthority(RoleAuthoritySaveDTO roleAuthoritySaveDTO);
}
