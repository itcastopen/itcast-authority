package com.itheima.authority.biz.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.dao.auth.ResourceMapper;
import com.itheima.authority.biz.service.auth.ResourceService;
import com.itheima.authority.dto.auth.ResourceQueryDTO;
import com.itheima.authority.entity.auth.Resource;
import com.itheima.tools.base.id.CodeGenerate;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import com.itheima.tools.exception.BizException;
import com.itheima.tools.utils.StrHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 业务实现类
 * 资源
 * </p>
 */
@Slf4j
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Autowired
    private CodeGenerate codeGenerate;

    /**
     * 查询用户的可用资源
     * 注意：什么地方需要清除 USER_MENU 缓存
     * 给用户重新分配角色时， 角色重新分配资源/菜单时
     *
     * @param resource
     * @return
     */
    @Override
    public List<Resource> findVisibleResource(ResourceQueryDTO resource) {
        List<Resource> resourceList = baseMapper.findVisibleResource(resource);

        if (resource.getMenuId() == null) {
            return resourceList;
        }

        // 根据查询条件过滤数据
        return resourceList.stream()
                .filter((re) -> Objects.equals(resource.getMenuId(), re.getMenuId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Resource> findAllResource() {
        List<Resource> resourceList = baseMapper.findAllResource();
        return resourceList;
    }


    /**
     * 批量删除菜单
     *
     * @param menuIds
     */
    @Override
    public void removeByMenuId(Collection<? extends Serializable> menuIds) {
        List<Resource> resources = super.list(Wraps.<Resource>lbQ().in(Resource::getMenuId, menuIds));
        if (resources.isEmpty()) {
            return;
        }
        List<Long> idList = resources.stream().mapToLong(Resource::getId).boxed().collect(Collectors.toList());
        super.removeByIds(idList);
    }

    /**
     * 保存菜单
     *
     * @param resource
     * @return
     */
    @Override
    public boolean save(Resource resource) {
        resource.setCode(StrHelper.getOrDef(resource.getCode(), codeGenerate.next()));
        if (super.count(Wraps.<Resource>lbQ().eq(Resource::getCode, resource.getCode())) > 0) {
            throw BizException.validFail("编码[%s]重复", resource.getCode());
        }

        return super.save(resource);
    }

//    /**
//     * 根据资源id查询菜单id集合
//     * @param resourceIdList
//     * @return
//     */
//    @Override
//    public List<Long> findMenuIdByResourceId(List<Long> resourceIdList) {
//        return baseMapper.findMenuIdByResourceId(resourceIdList);
//    }

    /**
     * 根据角色id查询资源
     *
     * @param id
     * @return
     */
    @Override
    public List<Resource> findResourceByRoleId(Long id) {
        return baseMapper.findResourceByRoleId(id);
    }
}
