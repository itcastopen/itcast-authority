package com.itheima.authority.biz.dao.auth;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.authority.config.MybatisPlusCache;
import com.itheima.authority.entity.auth.Menu;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * 菜单
 * </p>
 */
@Repository
@CacheNamespace(implementation = MybatisPlusCache.class, eviction = MybatisPlusCache.class)
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询用户可用菜单
     *
     * @param group
     * @param userId
     * @return
     */
    @SqlParser(filter = true)
    List<Menu> findVisibleMenu(@Param("group") String group, @Param("userId") Long userId, @Param("applicationId") Long applicationId);

    /**
     * 查询超级管理员菜单
     *
     * @return
     */
    @SqlParser(filter = true)
    List<Menu> findAdminVisibleMenu();
}
