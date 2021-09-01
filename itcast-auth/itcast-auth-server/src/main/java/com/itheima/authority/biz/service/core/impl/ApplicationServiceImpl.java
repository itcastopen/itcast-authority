package com.itheima.authority.biz.service.core.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.dao.auth.RoleApplicationMapper;
import com.itheima.authority.biz.dao.auth.UserRoleMapper;
import com.itheima.authority.biz.dao.core.ApplicationMapper;
import com.itheima.authority.biz.service.core.ApplicationService;
import com.itheima.authority.entity.auth.RoleApplication;
import com.itheima.authority.entity.core.Application;
import com.itheima.tools.context.BaseContextHandler;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import com.itheima.tools.database.mybatis.conditions.query.LbqWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 业务实现类
 * 应用
 * </p>
 */
@Slf4j
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleApplicationMapper roleApplicationMapper;

    /**
     * 查询当前用户可以操作的应用集合
     * @param query
     * @return
     */
    @Override
    public List<Application> currentList(LbqWrapper<Application> query) {
        query.eq(Application::getStatus, 1);
        Long userId = BaseContextHandler.getUserId();
        if (userId < 10) {
            return this.list(query);
        }
        List<Long> roleIds = userRoleMapper.selectAllRoleIdByUserId(userId);
        log.info("当前用户包含的角色ID:{}", roleIds);
        if (!CollectionUtils.isEmpty(roleIds)) {
            Set<Long> applicationIds = roleApplicationMapper.selectList(Wraps.<RoleApplication>lbQ().in(RoleApplication::getRoleId, roleIds)).stream().map(RoleApplication::getApplicationId).collect(Collectors.toSet());
            query.in(Application::getId, applicationIds);
            log.info("角色ID:{} 包含的应用:{}", roleIds, applicationIds);
            return this.list(query);
        }
        return Collections.emptyList();
    }
}
