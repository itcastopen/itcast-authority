package com.itheima.authority.biz.dao.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.authority.config.MybatisPlusCache;
import com.itheima.authority.entity.auth.UserGroup;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * 用户组
 * </p>
 */
@Repository
@CacheNamespace(implementation = MybatisPlusCache.class, eviction = MybatisPlusCache.class)
public interface UserGroupMapper extends BaseMapper<UserGroup> {

}
