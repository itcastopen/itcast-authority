package com.itheima.authority.biz.service.auth.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.dao.auth.UserGroupUserMapper;
import com.itheima.authority.biz.service.auth.RoleService;
import com.itheima.authority.biz.service.auth.UserGroupService;
import com.itheima.authority.biz.service.auth.UserGroupUserService;
import com.itheima.authority.entity.auth.Role;
import com.itheima.authority.entity.auth.UserGroup;
import com.itheima.authority.entity.auth.UserGroupUser;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户组 用户关联
 * </p>
 */
@Slf4j
@Service
public class UserGroupUserServiceImpl extends ServiceImpl<UserGroupUserMapper, UserGroupUser> implements UserGroupUserService {

    @Autowired
    private UserGroupService userGroupService;
    @Autowired
    private RoleService roleService;

    /**
     * 根据用户id获取角色id集合
     * @param userId
     * @return
     */
    @Override
    public List<Long> getRoleByUserId(Long userId) {
        LambdaQueryWrapper<UserGroupUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserGroupUser::getUserId, userId);
        List<UserGroupUser> userGroupUsers = this.list(wrapper);
        List<Long> groupIds = userGroupUsers.stream().map(item -> item.getGroupId()).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(groupIds)) {
            return null;
        }
        LambdaQueryWrapper<UserGroup> groupWrapper = new LambdaQueryWrapper<>();
        groupWrapper.in(UserGroup::getId, groupIds);
        List<UserGroup> userGroups = userGroupService.list(groupWrapper);
        List<Long> roleIds = userGroups.stream().map(UserGroup::getRoleId).collect(Collectors.toList());
        List<Role> roles = roleService.list(Wraps.<Role>lbQ().in(Role::getId, roleIds).eq(Role::getStatus, true));
        if (CollectionUtils.isEmpty(roleIds)) {
            return null;
        }
        return roles.stream().map(Role::getId).collect(Collectors.toList());
    }

    @Override
    public List<UserGroupUser> getUserByGroupId(Long id) {
        LambdaQueryWrapper<UserGroupUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserGroupUser::getGroupId, id);
        List<UserGroupUser> userGroupUsers = this.list(wrapper);
        return userGroupUsers;
    }

    @Override
    public List<UserGroupUser> getGroupByUserId(Long id) {
        LambdaQueryWrapper<UserGroupUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserGroupUser::getUserId, id);
        List<UserGroupUser> userGroupUsers = this.list(wrapper);
        return userGroupUsers;
    }
}
