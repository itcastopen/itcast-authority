package com.itheima.authority.biz.dao.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.authority.config.MybatisPlusCache;
import com.itheima.authority.entity.auth.RoleAuthority;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * 角色的资源
 * </p>
 */
@Repository
@CacheNamespace(implementation = MybatisPlusCache.class, eviction = MybatisPlusCache.class)
public interface RoleAuthorityMapper extends BaseMapper<RoleAuthority> {

}
