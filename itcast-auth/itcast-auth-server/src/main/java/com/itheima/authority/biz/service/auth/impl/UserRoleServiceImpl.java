package com.itheima.authority.biz.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.dao.auth.UserRoleMapper;
import com.itheima.authority.biz.service.auth.UserRoleService;
import com.itheima.authority.entity.auth.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 角色分配
 * 账号角色绑定
 * </p>
 */
@Slf4j
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
