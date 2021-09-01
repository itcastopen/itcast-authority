package com.itheima.authority.config;

import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.itheima.authority.biz.core.ApplicationContext;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.NullValue;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PreTenantHandler implements TenantHandler {

    private static final String SYSTEM_APPLICATION_ID = "application_id";

    public PreTenantHandler() {
        log.info("PreTenantHandler init");
    }

    /**
     * 不需要需要过滤的表
     */
    private static final List<String> TENANT_TABLES = new ArrayList() {{
        add("itcast_auth_menu");
        add("itcast_auth_resource");
        add("itcast_auth_role");
        add("itcast_auth_user_role");
    }};

    @Override
    public Expression getTenantId(boolean where) {
        Long applicationId = ApplicationContext.get();
        log.info("当前应用id为{}", applicationId);
        if (applicationId == null) {
            return new NullValue();
        }
        return new LongValue(applicationId);
    }

    @Override
    public String getTenantIdColumn() {
        return SYSTEM_APPLICATION_ID;
    }

    @Override
    public boolean doTableFilter(String tableName) {
        boolean flag = !TENANT_TABLES.stream().anyMatch((e) -> e.equalsIgnoreCase(tableName));
        log.debug("数据表：{} 过滤标志：{}", tableName, flag);
        return flag;
    }
}
