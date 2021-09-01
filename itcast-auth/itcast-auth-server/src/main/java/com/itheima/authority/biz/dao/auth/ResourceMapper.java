package com.itheima.authority.biz.dao.auth;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.authority.config.MybatisPlusCache;
import com.itheima.authority.dto.auth.ResourceQueryDTO;
import com.itheima.authority.entity.auth.Resource;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * 资源
 * </p>
 */
@Repository
@CacheNamespace(implementation = MybatisPlusCache.class, eviction = MybatisPlusCache.class)
public interface ResourceMapper extends BaseMapper<Resource> {
    /**
     * 查询 拥有的资源
     *
     * @param resource
     * @return
     */
    @SqlParser(filter = true)
    List<Resource> findVisibleResource(ResourceQueryDTO resource);

    /**
     * 查询全部资源
     * @return
     */
    @SqlParser(filter = true)
    List<Resource> findAllResource();

    /**
     * 根据唯一索引 保存或修改资源
     *
     * @param resource
     * @return
     */
    int saveOrUpdateUnique(Resource resource);

    /**
     * 根据资源id查询角色id
     * @param resourceIdList
     * @return
     */
    List<Long> findMenuIdByResourceId(@Param("resourceIdList") List<Long> resourceIdList);

    /**
     * 根据角色id查询资源
     * @param id
     * @return
     */
    List<Resource> findResourceByRoleId(Long id);

}
