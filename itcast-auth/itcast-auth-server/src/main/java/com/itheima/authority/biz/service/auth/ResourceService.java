package com.itheima.authority.biz.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.authority.dto.auth.ResourceQueryDTO;
import com.itheima.authority.entity.auth.Resource;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 业务接口
 * 资源
 * </p>
 */
public interface ResourceService extends IService<Resource> {

    List<Resource> findVisibleResource(ResourceQueryDTO resource);

    List<Resource> findAllResource();

    void removeByMenuId(Collection<? extends Serializable> ids);

//    List<Long> findMenuIdByResourceId(List<Long> resourceIdList);

    List<Resource> findResourceByRoleId(Long id);

}
