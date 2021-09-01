package com.itheima.authority.config.datasource;


import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import com.itheima.authority.biz.service.auth.UserService;
import com.itheima.authority.config.PreTenantHandler;
import com.itheima.tools.database.datasource.BaseMybatisConfiguration;
import com.itheima.tools.database.mybatis.auth.DataScopeInterceptor;
import com.itheima.tools.database.properties.DatabaseProperties;
import com.itheima.tools.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置一些拦截器
 */
@Configuration
@Slf4j
public class AuthorityMybatisAutoConfiguration extends BaseMybatisConfiguration {


    public AuthorityMybatisAutoConfiguration(DatabaseProperties databaseProperties) {
        super(databaseProperties);

    }

    /**
     * 数据权限插件
     *
     * @return DataScopeInterceptor
     */
    @Bean
    @ConditionalOnProperty(name = "itcast.database.isDataScope", havingValue = "true", matchIfMissing = true)
    public DataScopeInterceptor dataScopeInterceptor() {
        return new DataScopeInterceptor((userId) -> SpringUtils.getBean(UserService.class).getDataScopeById(userId));
    }


    @Bean
    @Override
    public PaginationInterceptor paginationInterceptor() {
        log.info("初始化 PaginationInterceptor");
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        // SQL解析处理拦截：增加租户处理回调。

        List<ISqlParser> sqlParserList = new ArrayList<>();
        // 攻击 SQL 阻断解析器、加入解析链
        sqlParserList.add(new BlockAttackSqlParser());
        // 多租户拦截
        TenantSqlParser tenantSqlParser = new TenantSqlParser();
        tenantSqlParser.setTenantHandler(new PreTenantHandler());
        sqlParserList.add(tenantSqlParser);
        paginationInterceptor.setSqlParserList(sqlParserList);
        log.info("初始化完成 PaginationInterceptor {}", paginationInterceptor);
        return paginationInterceptor;
    }
}
