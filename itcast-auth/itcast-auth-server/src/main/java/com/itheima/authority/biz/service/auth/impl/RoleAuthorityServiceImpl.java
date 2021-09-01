package com.itheima.authority.biz.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.dao.auth.RoleAuthorityMapper;
import com.itheima.authority.biz.service.auth.RoleAuthorityService;
import com.itheima.authority.biz.service.auth.UserRoleService;
import com.itheima.authority.dto.auth.RoleAuthoritySaveDTO;
import com.itheima.authority.dto.auth.UserRoleSaveDTO;
import com.itheima.authority.entity.auth.RoleAuthority;
import com.itheima.authority.entity.auth.UserRole;
import com.itheima.authority.enumeration.auth.AuthorizeType;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 业务实现类
 * 角色的资源
 * </p>
 */
@Slf4j
@Service
public class RoleAuthorityServiceImpl extends ServiceImpl<RoleAuthorityMapper, RoleAuthority> implements RoleAuthorityService {

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 给用户分配角色
     * @param userRole
     * @return
     */
    @Override
    public boolean saveUserRole(UserRoleSaveDTO userRole) {
        userRoleService.remove(Wraps.<UserRole>lbQ().eq(UserRole::getRoleId, userRole.getRoleId()));
        List<UserRole> list = userRole.getUserIdList()
                .stream()
                .map((userId) -> UserRole.builder()
                        .userId(userId)
                        .roleId(userRole.getRoleId())
                        .build())
                .collect(Collectors.toList());
        userRoleService.saveBatch(list);
        return true;
    }

    /**
     * 给角色重新分配 权限（资源/菜单）
     * @param dto
     * @return
     */
    @Override
    public boolean saveRoleAuthority(RoleAuthoritySaveDTO dto) {
        //删除角色和资源的关联
        super.remove(Wraps.<RoleAuthority>lbQ().eq(RoleAuthority::getRoleId, dto.getRoleId()));

        List<RoleAuthority> list = new ArrayList<>();
        if (dto.getResourceIdList() != null && !dto.getResourceIdList().isEmpty()) {
            //保存授予的资源
            List<RoleAuthority> resourceList = new HashSet<>(dto.getResourceIdList())
                    .stream()
                    .map((resourceId) -> RoleAuthority.builder()
                            .authorityType(AuthorizeType.RESOURCE)
                            .authorityId(resourceId)
                            .roleId(dto.getRoleId())
                            .build())
                    .collect(Collectors.toList());
            list.addAll(resourceList);
        }
        if (dto.getMenuIdList() != null && !dto.getMenuIdList().isEmpty()) {
            //保存授予的菜单
            List<RoleAuthority> menuList = new HashSet<>(dto.getMenuIdList())
                    .stream()
                    .map((menuId) -> RoleAuthority.builder()
                            .authorityType(AuthorizeType.MENU)
                            .authorityId(menuId)
                            .roleId(dto.getRoleId())
                            .build())
                    .collect(Collectors.toList());
            list.addAll(menuList);
        }
        return super.saveBatch(list);
    }
}
