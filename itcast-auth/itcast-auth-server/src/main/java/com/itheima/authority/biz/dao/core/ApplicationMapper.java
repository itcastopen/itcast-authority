package com.itheima.authority.biz.dao.core;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.authority.config.MybatisPlusCache;
import com.itheima.authority.entity.core.Application;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * 组织
 * </p>
 */
@Repository
@CacheNamespace(implementation = MybatisPlusCache.class, eviction = MybatisPlusCache.class)
public interface ApplicationMapper extends BaseMapper<Application> {

}
