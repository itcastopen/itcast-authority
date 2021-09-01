package com.itheima.authority.biz.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.authority.entity.auth.Role;
import com.itheima.authority.entity.auth.UserGroupUser;

import java.util.List;

/**
 * <p>
 * 用户组 用户关联
 * </p>
 */
public interface UserGroupUserService extends IService<UserGroupUser> {

    List<Long> getRoleByUserId(Long id);

    List<UserGroupUser> getUserByGroupId(Long id);

    List<UserGroupUser> getGroupByUserId(Long id);
}
