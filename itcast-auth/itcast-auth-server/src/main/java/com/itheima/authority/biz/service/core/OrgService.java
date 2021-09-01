package com.itheima.authority.biz.service.core;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.authority.dto.core.OrgTreeDTO;
import com.itheima.authority.entity.core.Org;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业务接口
 * 组织
 * </p>
 */
public interface OrgService extends IService<Org> {


    List<Org> findChildren(Long id);

    List<Org> findChildrenWithoutSelf(Long id);

    List<Org> remove(List<Long> ids);

    Org findById(Long id);

    boolean saveOrg(Org org);

    boolean updateOrg(Org org);

    Org getByName(String orgName);

    void updateStatus(Org org);

    List<OrgTreeDTO> buildTree(List<OrgTreeDTO> treeList);
}
