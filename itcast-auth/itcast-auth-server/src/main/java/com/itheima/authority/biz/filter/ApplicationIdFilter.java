package com.itheima.authority.biz.filter;

import com.itheima.authority.biz.core.ApplicationContext;
import com.itheima.tools.context.BaseContextHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class ApplicationIdFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String applicationId = httpServletRequest.getHeader("APPLICATIONID");

        log.info("URL:{}  ApplicationIdFilter :{}", httpServletRequest.getRequestURI(), applicationId);
        if (StringUtils.isNotBlank(applicationId)) {
            ApplicationContext.put(Long.valueOf(applicationId));

        } else {
            if (BaseContextHandler.getUserId() < 10L) {
                // 超级管理员 直接给默认值
                ApplicationContext.put(1L);
            }
        }

        if (StringUtils.isNotEmpty(httpServletRequest.getHeader("APPLICATIONTYPE"))) {
            ApplicationContext.setSystem(false);
        } else {
            ApplicationContext.setSystem(true);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
