package com.itheima.authority.biz.dao.auth;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.authority.config.MybatisPlusCache;
import com.itheima.authority.entity.auth.UserRole;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * 角色分配
 * 账号角色绑定
 * </p>
 */
@Repository
@CacheNamespace(implementation = MybatisPlusCache.class, eviction = MybatisPlusCache.class)
public interface UserRoleMapper extends BaseMapper<UserRole> {

    @SqlParser(filter = true)
    List<Long> selectAllRoleIdByUserId( @Param("userId") Long userId);
}
