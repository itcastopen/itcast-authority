package com.itheima.authority.biz.dao.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.authority.entity.common.LoginLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * 系统日志
 * </p>
 */
@Repository
public interface LoginLogMapper extends BaseMapper<LoginLog> {
    /**
     * 获取系统总访问次数
     *
     * @return Long
     */
    Long findTotalVisitCount();

    /**
     * 获取系统今日访问次数
     *
     * @param today 今天
     * @return Long
     */
    Long findTodayVisitCount(@Param("today") LocalDate today);

    /**
     * 获取系统今日访问 IP数
     *
     * @param today 今天
     * @return Long
     */
    Long findTodayIp(@Param("today") LocalDate today);

    /**
     * 获取系统近十天来的访问记录
     *
     * @param tenDays 10天前
     * @param account 用户账号
     * @return 系统近十天来的访问记录
     */
    List<Map<String, Object>> findLastTenDaysVisitCount(@Param("tenDays") LocalDate tenDays, @Param("account") String account);

    /**
     * 按浏览器来统计数量
     *
     * @return
     */
    List<Map<String, Object>> findByBrowser();

    /**
     * 按造作系统内统计数量
     *
     * @return
     */
    List<Map<String, Object>> findByOperatingSystem();
}
