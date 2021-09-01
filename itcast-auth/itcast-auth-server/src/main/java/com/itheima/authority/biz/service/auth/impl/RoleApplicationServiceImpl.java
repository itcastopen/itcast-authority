package com.itheima.authority.biz.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.dao.auth.RoleApplicationMapper;
import com.itheima.authority.biz.service.auth.RoleApplicationService;
import com.itheima.authority.entity.auth.RoleApplication;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 业务实现类
 * 角色应用关系
 * </p>
 */
@Slf4j
@Service
public class RoleApplicationServiceImpl extends ServiceImpl<RoleApplicationMapper, RoleApplication> implements RoleApplicationService {

    /**
     * 根绝角色id查询拥有的应用集合
     * @param id
     * @return
     */
    @Override
    public List<Long> getApplicationIdsByRoleId(Long id) {
        List<RoleApplication> roleApplications = this.baseMapper.selectList(Wraps.<RoleApplication>lbQ().eq(RoleApplication::getRoleId, id));
        if (CollectionUtils.isEmpty(roleApplications)) {
            return Collections.emptyList();
        } else {
            return roleApplications.stream().map(RoleApplication::getApplicationId).collect(Collectors.toList());
        }
    }
}
