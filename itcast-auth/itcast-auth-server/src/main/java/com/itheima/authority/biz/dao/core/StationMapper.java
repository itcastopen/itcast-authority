package com.itheima.authority.biz.dao.core;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.authority.config.MybatisPlusCache;
import com.itheima.authority.entity.core.Station;
import com.itheima.tools.database.mybatis.auth.DataScope;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * 岗位
 * </p>
 */
@Repository
@CacheNamespace(implementation = MybatisPlusCache.class, eviction = MybatisPlusCache.class)
public interface StationMapper extends BaseMapper<Station> {
    /**
     * 分页查询岗位信息（含角色）
     *
     * @param page
     * @param queryWrapper
     * @param dataScope
     * @return
     */
    IPage<Station> findStationPage(Page page, @Param(Constants.WRAPPER) Wrapper<Station> queryWrapper, DataScope dataScope);
}
