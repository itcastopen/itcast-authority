package com.itheima.authority.biz.service.auth.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.dao.auth.RoleApplicationMapper;
import com.itheima.authority.biz.dao.auth.RoleMapper;
import com.itheima.authority.biz.service.auth.ResourceService;
import com.itheima.authority.biz.service.auth.RoleOrgService;
import com.itheima.authority.biz.service.auth.RoleService;
import com.itheima.authority.biz.service.auth.UserRoleService;
import com.itheima.authority.biz.strategy.DataScopeContext;
import com.itheima.authority.dto.auth.RoleResourceDTO;
import com.itheima.authority.dto.auth.RoleSaveDTO;
import com.itheima.authority.dto.auth.RoleUpdateDTO;
import com.itheima.authority.entity.auth.*;
import com.itheima.tools.base.id.CodeGenerate;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import com.itheima.tools.dozer.DozerUtils;
import com.itheima.tools.utils.StrHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 业务实现类
 * 角色
 * </p>
 */
@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private DozerUtils dozer;
    @Autowired
    private RoleOrgService roleOrgService;
    @Autowired
    private DataScopeContext dataScopeContext;
    @Autowired
    private CodeGenerate codeGenerate;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleApplicationMapper roleApplicationMapper;


    /**
     * 批量删除未使用的角色
     * @param ids
     * @return
     */
    @Override
    public List<Role> removeByIdWithUnUse(List<Long> ids) {
        List<Role> useRole = new ArrayList<>();
        List<Long> useIds = new ArrayList<>();
        if (ids.isEmpty()) {
            return useRole;
        }
        for (Long id : ids) {
            LambdaQueryWrapper<UserRole> wrapper = new LambdaQueryWrapper();
            wrapper.eq(UserRole::getRoleId, id);
            int count = userRoleService.count(wrapper);
            if (count > 0) {
                useIds.add(id);
            }
        }

        if (useIds.size() > 0) {
            // 删除占用id
            ids.removeAll(useIds);
            useRole.addAll(this.listByIds(useIds));
        }
        if (ids.size() > 0) {
            super.removeByIds(ids);
            ids.forEach(item -> {
                roleApplicationMapper.delete(Wraps.<RoleApplication>lbQ().eq(RoleApplication::getRoleId, item));
            });
        }
        return useRole;
    }

    /**
     * 根据用户id查询角色集合
     * @param userId
     * @return
     */
    @Override
    public List<Role> findRoleByUserId(Long userId) {
        return baseMapper.findRoleByUserId(userId);
    }

    /**
     * 1，保存角色
     * 2，保存 与组织的关系
     *
     * @param data
     * @param userId 用户id
     */
    @Override
    public void saveRole(RoleSaveDTO data, Long userId) {
        Role role = dozer.map(data, Role.class);
        role.setCode(StrHelper.getOrDef(data.getCode(), codeGenerate.next()));
        role.setReadonly(false);
        super.save(role);

        saveRoleOrg(userId, role, data.getOrgList());

        saveRoleApplication(data.getApplicationIds(), role);

    }

    /**
     * 保存角色与应用的关系
     * @param applicationIds
     * @param role
     */
    private void saveRoleApplication(List<Long> applicationIds, Role role) {
        roleApplicationMapper.delete(Wraps.<RoleApplication>lbQ().eq(RoleApplication::getRoleId, role.getId()));
        if (!CollectionUtils.isEmpty(applicationIds)) {
            applicationIds.forEach(item -> {
                RoleApplication roleApplication = new RoleApplication();
                roleApplication.setApplicationId(item);
                roleApplication.setRoleId(role.getId());
                roleApplicationMapper.insert(roleApplication);
            });
        }
    }

    /**
     * 修改角色
     * @param data
     * @param userId
     */
    @Override
    public void updateRole(RoleUpdateDTO data, Long userId) {
        Role role = dozer.map(data, Role.class);
        super.updateById(role);

        roleOrgService.remove(Wraps.<RoleOrg>lbQ().eq(RoleOrg::getRoleId, data.getId()));
        saveRoleOrg(userId, role, data.getOrgList());
        saveRoleApplication(data.getApplicationIds(), role);
    }

    /**
     * 保存数据权限
     * @param userId
     * @param role
     * @param orgList
     */
    private void saveRoleOrg(Long userId, Role role, List<Long> orgList) {
        // 根据 数据范围类型 和 勾选的组织ID， 重新计算全量的组织ID
        List<Long> orgIds = dataScopeContext.getOrgIdsForDataScope(orgList, role.getDsType(), userId);
        if (orgIds != null && !orgIds.isEmpty()) {
            List<RoleOrg> list = orgIds.stream().map((orgId) ->
                    RoleOrg.builder()
                            .orgId(orgId).roleId(role.getId())
                            .build()
            ).collect(Collectors.toList());
            roleOrgService.saveBatch(list);
        }
    }

    @Override
    public List<RoleResourceDTO> findAllRolesWithResource() {
        List<RoleResourceDTO> roleResourceDTOS = new ArrayList<>();
        List<Role> roles = this.list();
        for (Role role : roles) {
            Long id = role.getId();
            List<Resource> resources = resourceService.findResourceByRoleId(id);
            roleResourceDTOS.add(new RoleResourceDTO(role, resources));
        }
        return roleResourceDTOS;
    }

    @Override
    public List<Role> findAllRoleByUserId(Long userId) {
        return baseMapper.findAllRoleByUserId(userId);
    }
}
