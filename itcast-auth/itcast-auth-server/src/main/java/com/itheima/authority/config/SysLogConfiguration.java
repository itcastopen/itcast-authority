package com.itheima.authority.config;

import com.itheima.authority.biz.service.common.OptLogService;
import com.itheima.tools.log.event.SysLogListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 日志自动配置
 *
 */
@EnableAsync
@Configuration
public class SysLogConfiguration {

    @Value("${itcast.mysql.database:itcast_auth}")
    private String database;

    @Bean
    public SysLogListener sysLogListener(OptLogService optLogService) {
        return new SysLogListener(this.database, (log) -> optLogService.save(log));
    }
}
