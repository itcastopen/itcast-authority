package com.itheima.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.itheima.tools.base.R;
import com.itheima.tools.utils.StrPool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 基础 网关过滤器
 */
@Slf4j
public abstract class BaseFilter implements GlobalFilter, Ordered {

    protected static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();

    protected Mono<Void> unAuth(ServerHttpResponse response, int code, String msg, HttpStatus httpStatus) {
        response.setStatusCode(httpStatus != null ? httpStatus : HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        R tokenError = R.fail(code, msg);
        String result = JSON.toJSONString(tokenError);
        DataBuffer buffer = response.bufferFactory().wrap(result.getBytes(StandardCharsets.UTF_8));
        return response.writeWith(Flux.just(buffer));
    }

    protected void addHeaders(ServerWebExchange exchange, Map headers) {
        Consumer<HttpHeaders> httpHeaders = httpHeader -> {
            httpHeader.setAll(headers);
        };

        ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate().headers(httpHeaders).build();
        exchange.mutate().request(serverHttpRequest).build();
    }

    protected String getHeaderFromRequest(ServerHttpRequest request, String name) {
        String heander = request.getHeaders().getFirst(name);
        if (StringUtils.isBlank(heander)) {
            heander = request.getQueryParams().getFirst(name);
        }
        return heander;
    }

    protected boolean anyMatch(Collection<String> collection, String value) {
        return collection.stream().anyMatch((item) ->
                value.equals(item) || value.startsWith(item) || ANT_PATH_MATCHER.match(item, value));
    }

    protected String formatPath(Route route, String path) {
        for (GatewayFilter filter : route.getFilters()) {
            String delegate = ((OrderedGatewayFilter) filter).getDelegate().toString();
            if (delegate.contains("StripPrefix parts")) { //[StripPrefix parts = 1]
                Integer parts = Integer.parseInt(delegate.replaceAll("StripPrefix parts", "").replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("=", "").replaceAll("\\s", ""));
                return splicingPath(splitPath(path), parts);
            }
        }
        return path;
    }

    protected List<String> splitPath(String path) {
        String[] paths = org.apache.commons.lang3.StringUtils.split(path, StrPool.SLASH);
        List<String> list = Arrays.asList(paths).stream().filter(org.apache.commons.lang3.StringUtils::isNotBlank).collect(Collectors.toList());
        return list;
    }

    protected String splicingPath(List<String> paths, Integer stripPrefix) {
        if (stripPrefix != null) {
            for (int i = 0; i < stripPrefix; i++) {
                String removePath = paths.remove(0);// 删除第一个
                log.debug("删除前缀 index:{} value:{}", i, removePath);
            }
        }
        String path = StrPool.SLASH + org.apache.commons.lang3.StringUtils.join(paths, StrPool.SLASH);
        return path;
    }

}
