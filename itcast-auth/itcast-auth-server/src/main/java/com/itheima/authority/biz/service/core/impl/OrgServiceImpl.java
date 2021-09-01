package com.itheima.authority.biz.service.core.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.dao.core.OrgMapper;
import com.itheima.authority.biz.service.auth.UserService;
import com.itheima.authority.biz.service.core.OrgService;
import com.itheima.authority.dto.core.OrgTreeDTO;
import com.itheima.authority.entity.auth.User;
import com.itheima.authority.entity.core.Org;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import com.itheima.tools.utils.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 业务实现类
 * 组织
 * </p>
 */
@Slf4j
@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements OrgService {
    @Autowired
    private UserService userService;

    /**
     * 查询指定id集合下的所有子集
     *
     * @param id
     * @return
     */
    @Override
    public List<Org> findChildren(Long id) {
        List<Org> orgs = new ArrayList<>();
        if (null == id) {
            return orgs;
        }

        Org org = this.getById(id);
        if (org == null) {
            return orgs;
        }
        orgs.add(org);

        findChildren(id, orgs);

        return orgs;
    }

    /**
     * 查询指定id集合下的所有子集 排除自己
     * @param id
     * @return
     */
    @Override
    public List<Org> findChildrenWithoutSelf(Long id) {
        List<Org> orgs = new ArrayList<>();
        if (null == id) {
            return orgs;
        }

        findChildren(id, orgs);
        return orgs;
    }

    /**
     * 查询组织的全部子节点
     * @param id
     * @param orgs
     */
    private void findChildren(Long id, List<Org> orgs) {
        List<Org> children = super.list(Wraps.<Org>lbQ().eq(Org::getParentId, id));
        if (!CollectionUtils.isEmpty(children)) {
            orgs.addAll(children);
            for (Org child : children) {
                findChildren(child.getId(), orgs);
            }
        }
    }

    /**
     * 批量删除以及删除其子节点
     *
     * @param ids
     * @return
     */
    @Override
    public List<Org> remove(List<Long> ids) {
        log.info("删除组织：{}", ids);
        List<Long> useIds = new ArrayList<>();
        List<Org> useOrg = new ArrayList<>();
        for (Long id : ids) {
            int count = 0;
            List<Org> children = this.findChildrenWithoutSelf(id);
            log.info("查找：{} 的下级组织:\n{}", id, children);
            children.add(Org.builder().id(id).build());
            if (!CollectionUtils.isEmpty(children)) {
                LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
                wrapper.in(User::getOrgId, children.stream().map(item -> item.getId()).collect(Collectors.toSet()));
                count = userService.count(wrapper);
                log.info("组织：{} 被用户使用 {}", id, count);
            }
            if (children.size() > 1 || count > 0) {
                useIds.add(id);
            }
        }
        if (useIds.size() > 0) {
            ids.removeAll(useIds);
            useOrg.addAll(this.listByIds(useIds));
        }

        if (ids.size() > 0) {
            log.info("真正删除:{}", ids);
            super.removeByIds(ids);
        }
        log.info("删除失败-被占用组织:{}", useOrg);
        return useOrg;
    }

    /**
     * 根据id查询组织详细信息
     * @param id
     * @return
     */
    @Override
    public Org findById(Long id) {
        Org org = this.getById(id);
        if (org != null) {
            if (org.getParentId() != null && org.getParentId() != 0) {
                Org parent = this.getById(org.getParentId());
                if (parent != null) {
                    org.setParentName(parent.getName());
                }
            }
            if (org.getManagerId() != null) {
                User manager = userService.getById(org.getManagerId());
                if (manager != null) {
                    org.setManager(manager.getName());
                }
            }
        }

        log.info("查询组织 id:{} result:{}", id, org);
        return org;
    }

    /**
     * 保存组织
     * @param org
     * @return
     */
    @Override
    public boolean saveOrg(Org org) {
        return this.save(org);
    }

    /**
     * 修改组织
     * @param org
     * @return
     */
    @Override
    public boolean updateOrg(Org org) {
        return this.updateById(org);
    }

    /**
     * 根据名字查询组织
     * @param orgName
     * @return
     */
    @Override
    public Org getByName(String orgName) {
        LambdaQueryWrapper<Org> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Org::getName, orgName);
        return getOne(wrapper);
    }

    /**
     * 批量修改当前组织 及下级的状态
     * @param org
     */
    @Override
    public void updateStatus(Org org) {
        List<Org> orgs = findChildren(org.getId());
        if (!CollectionUtils.isEmpty(orgs)) {
            this.update(Wraps.<Org>lbU().set(Org::getStatus, org.getStatus()).in(Org::getId, orgs.stream().map(Org::getId).collect(Collectors.toList())));
        }
    }

    /**
     * 构建组织树结构
     * @param treeList
     * @return
     */
    @Override
    public List<OrgTreeDTO> buildTree(List<OrgTreeDTO> treeList) {
        List<OrgTreeDTO> result = TreeUtil.build(treeList);
        buildParentStatus(result, null);
        return result;
    }

    /**
     * 批量设置组织树的状态
     * @param list
     * @param status
     */
    private void buildParentStatus(List<OrgTreeDTO> list, Boolean status) {
        for (OrgTreeDTO orgTreeDTO : list) {
            orgTreeDTO.setParentStatus(status);
            if (CollectionUtils.isEmpty(orgTreeDTO.getChildren())) {
                continue;
            } else {
                Boolean parentStatus = orgTreeDTO.getStatus();
                buildParentStatus(orgTreeDTO.getChildren(), parentStatus);
            }
        }
    }
}
