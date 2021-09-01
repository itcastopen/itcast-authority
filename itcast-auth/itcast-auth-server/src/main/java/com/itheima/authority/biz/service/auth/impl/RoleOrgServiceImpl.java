package com.itheima.authority.biz.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.dao.auth.RoleOrgMapper;
import com.itheima.authority.biz.service.auth.RoleOrgService;
import com.itheima.authority.entity.auth.RoleOrg;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 业务实现类
 * 角色组织关系
 * </p>
 */
@Slf4j
@Service
public class RoleOrgServiceImpl extends ServiceImpl<RoleOrgMapper, RoleOrg> implements RoleOrgService {

    /**
     * 根据角色id查询组织集合
     * @param id
     * @return
     */
    @Override
    public List<Long> listOrgByRoleId(Long id) {
        List<RoleOrg> list = super.list(Wraps.<RoleOrg>lbQ().eq(RoleOrg::getRoleId, id));
        List<Long> orgList = list.stream().mapToLong(RoleOrg::getOrgId).boxed().collect(Collectors.toList());
        return orgList;
    }
}
