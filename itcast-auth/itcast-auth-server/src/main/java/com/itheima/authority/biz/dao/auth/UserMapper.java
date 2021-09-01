package com.itheima.authority.biz.dao.auth;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.itheima.authority.config.MybatisPlusCache;
import com.itheima.authority.entity.auth.User;
import com.itheima.tools.database.mybatis.auth.DataScope;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * 账号
 * </p>
 */
@Repository
@CacheNamespace(implementation = MybatisPlusCache.class, eviction = MybatisPlusCache.class)
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据角色id，查询已关联用户
     *
     * @param roleId
     * @param keyword
     * @return
     */
    List<User> findUserByRoleId(@Param("roleId") Long roleId, @Param("keyword") String keyword);

    /**
     * 递增 密码错误次数
     *
     * @param id
     * @return
     */
    int incrPasswordErrorNumById(@Param("id") Long id);

    /**
     * 带数据权限的分页查询
     *
     * @param page
     * @param wrapper
     * @param dataScope
     * @return
     */
    IPage<User> findPage(IPage<User> page, @Param(Constants.WRAPPER) Wrapper<User> wrapper, DataScope dataScope);

    /**
     * 带数据权限的分页查询
     *
     * @param page
     * @param params
     * @param dataScope
     * @return
     */
    IPage<User> findUserPage(IPage<User> page, @Param("params") Map<String, Object> params, DataScope dataScope);

    /**
     * 重置 密码错误次数
     *
     * @param id
     * @return
     */
    int resetPassErrorNum(@Param("id") Long id);

    /**
     * 修改用户最后登录时间
     *
     * @param account
     * @param now
     * @return
     */
    int updateLastLoginTime(@Param("account") String account, @Param("now") LocalDateTime now);

    /**
     * 根据账号查询用户
     *
     * @param account
     * @return
     */
    @SqlParser(filter = true)
    User getByAccount(@Param("account") String account);
}
