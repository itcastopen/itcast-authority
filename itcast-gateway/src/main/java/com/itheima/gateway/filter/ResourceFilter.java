package com.itheima.gateway.filter;

import com.itheima.gateway.props.IgnoreResourceProperties;
import com.itheima.gateway.service.RoleAuthService;
import com.itheima.authority.api.v1.dto.ResourceDTO;
import com.itheima.authority.api.v1.dto.RoleResourceDTO;
import com.itheima.tools.base.R;
import com.itheima.tools.context.BaseContextConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 资源过滤器
 */
@Component
@Slf4j
public class ResourceFilter extends BaseFilter {

    @Autowired
    private IgnoreResourceProperties ignoreResourceProperties;

    @Autowired
    RoleAuthService roleAuthService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        Route route = (Route) exchange.getAttributes().get(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        String path = request.getURI().getPath();
        log.info("ResourceFilter path:{}", path);
        path = formatPath(route, path);
        log.info("ResourceFilter format path:{}", path);
        //跳过不需要验证的路径
        if (isIgnoreResourceUrl(path)) {
            return chain.filter(exchange);
        }
        if (isIgnoreResourceRoute(route)) {
            return chain.filter(exchange);
        }

        String userId = getHeaderFromRequest(request, BaseContextConstants.JWT_KEY_USER_ID);
        // userId为空说明 TokenFilter 已经放开，此处也直接放开
        if (StringUtils.isEmpty(userId)) {
            log.info("ResourceFilter not execute by ignore token {}", userId);
            return chain.filter(exchange);
        }
        // id小于10 都不校验权限
        if (Long.valueOf(userId) < 10) {
            log.info("ResourceFilter not execute by userId:{}", userId);
            return chain.filter(exchange);
        }
        // 当前登录用户id
        List<Long> roles = roleAuthService.findRoleByUserId(Long.parseLong(userId));
        log.info("当前登录用户:{}  角色: {}", userId, roles);
        List<RoleResourceDTO> allRoles = roleAuthService.findAllRoles();

        Set<ResourceDTO> resources = allRoles.stream().filter(item -> roles.contains(item.getId())).map(item -> item.getResources())
                .collect(() -> new HashSet<>(), (list, list1) -> list.addAll(list1), (list1, list2) -> list1.addAll(list2));

        List<String> resourceStr = resources.stream().filter(item -> item != null && item.getMethod() != null && item.getUrl() != null).map(item -> item.getMethod() + item.getUrl()).collect(Collectors.toList());
        String requestResource = request.getMethod().toString().toUpperCase() + path;
        log.info("当前路径：{}", requestResource);

        if (check(resourceStr, requestResource)) {
            log.info("权限校验通过：{}", requestResource);
            return chain.filter(exchange);
        }

        log.info("权限校验不通过：{} , {}{}", resourceStr, request.getMethod(), path);
        return unAuth(response, R.FAIL_CODE, "权限不足 " + request.getMethod() + " " + path, HttpStatus.OK);
    }

    @Override
    public int getOrder() {
        return -99;
    }

    private boolean isIgnoreResourceUrl(String path) {
        return anyMatch(ignoreResourceProperties.getUrl(), path);
    }

    private boolean isIgnoreResourceRoute(Route route) {
        return anyMatch(ignoreResourceProperties.getRoute(), route.getId());
    }

    private boolean check(List<String> resources, String requestResource) {
        return anyMatch(resources, requestResource);
    }
}
