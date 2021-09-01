package com.itheima.authority.biz.strategy.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.itheima.authority.biz.service.auth.UserService;
import com.itheima.authority.entity.auth.User;

import com.itheima.authority.biz.strategy.AbstractDataScopeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 本级数据权限
 */
@Component("THIS_LEVEL")
public class ThisLevelDataScope implements AbstractDataScopeHandler {
    @Autowired
    private UserService userService;

    @Override
    public List<Long> getOrgIds(List<Long> orgList, Long userId) {
        User user = userService.getById(userId);
        if (user == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(user.getOrgId());
    }
}
