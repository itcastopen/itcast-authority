package com.itheima.authority.biz.strategy.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.itheima.authority.biz.service.core.OrgService;
import com.itheima.authority.biz.strategy.AbstractDataScopeHandler;
import com.itheima.authority.entity.core.Org;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 数据权限：所有数据
 */
@Component("ALL")
public class AllDataScope implements AbstractDataScopeHandler {

    @Autowired
    private OrgService orgService;

    @Override
    public List<Long> getOrgIds(List<Long> orgList, Long userId) {
        List<Org> list = orgService.lambdaQuery().select(Org::getId).list();
        return list.stream().map(Org::getId).collect(Collectors.toList());
    }


}
