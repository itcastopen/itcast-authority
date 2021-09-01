package com.itheima.authority.biz.strategy.impl;

import com.itheima.authority.biz.service.core.OrgService;
import com.itheima.authority.biz.strategy.AbstractDataScopeHandler;
import com.itheima.authority.entity.core.Org;
import com.itheima.tools.exception.BizException;
import com.itheima.tools.exception.code.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义数据权限
 */
@Component("CUSTOMIZE")
public class CustomizeDataScope implements AbstractDataScopeHandler {

    @Autowired
    private OrgService orgService;

    @Override
    public List<Long> getOrgIds(List<Long> orgList, Long userId) {
        if (orgList == null || orgList.isEmpty()) {
            throw new BizException(ExceptionCode.BASE_VALID_PARAM.getCode(), "自定义数据权限类型时，组织不能为空");
        }
        for (Long org : orgList) {
            List<Org> children = orgService.findChildren(org);
            if (!CollectionUtils.isEmpty(children)) {
                orgList.addAll(children.stream().map(Org::getId).collect(Collectors.toList()));
            }
        }
        return orgList;
    }
}
