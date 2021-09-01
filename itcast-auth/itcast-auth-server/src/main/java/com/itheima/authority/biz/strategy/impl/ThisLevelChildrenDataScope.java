package com.itheima.authority.biz.strategy.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.itheima.authority.biz.service.auth.UserService;
import com.itheima.authority.biz.service.core.OrgService;
import com.itheima.authority.entity.auth.User;
import com.itheima.authority.entity.core.Org;

import com.itheima.authority.biz.strategy.AbstractDataScopeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 本级以及子级
 */
@Component("THIS_LEVEL_CHILDREN")
public class ThisLevelChildrenDataScope implements AbstractDataScopeHandler {
    @Autowired
    private UserService userService;
    @Autowired
    private OrgService orgService;

    @Override
    public List<Long> getOrgIds(List<Long> orgList, Long userId) {
        User user = userService.getById(userId);
        if (user == null) {
            return Collections.emptyList();
        }
        List<Org> children = orgService.findChildren(user.getOrgId());
        return children.stream().mapToLong(Org::getId).boxed().collect(Collectors.toList());
    }
}
