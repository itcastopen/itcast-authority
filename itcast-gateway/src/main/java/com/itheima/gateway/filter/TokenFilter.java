package com.itheima.gateway.filter;

import com.itheima.gateway.props.IgnoreTokenProperties;
import com.itheima.tools.auth.client.properties.AuthClientProperties;
import com.itheima.tools.auth.client.utils.JwtTokenClientUtils;
import com.itheima.tools.auth.utils.JwtUserInfo;
import com.itheima.tools.base.R;
import com.itheima.tools.context.BaseContextConstants;
import com.itheima.tools.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * token 过滤器
 */
@Component
@Slf4j
public class TokenFilter extends BaseFilter {

    @Autowired
    private IgnoreTokenProperties ignoreTokenProperties;
    @Autowired
    private AuthClientProperties authClientProperties;
    @Autowired
    private JwtTokenClientUtils jwtTokenClientUtils;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String path = request.getURI().getPath();
        log.info("TokenFilter path:{}", path);
        //跳过不需要验证的路径
        if (isIgnoreToken(path)) {
            return chain.filter(exchange);
        }

        //获取token
        String userToken = getHeaderFromRequest(request, authClientProperties.getUser().getHeaderName());

        //解析token
        JwtUserInfo userInfo;
        try {
            userInfo = jwtTokenClientUtils.getUserInfo(userToken);
        } catch (BizException e) {
            return unAuth(response, e.getCode(), e.getMessage(), HttpStatus.OK);
        } catch (Exception e) {
            return unAuth(response, R.FAIL_CODE, "验证token出错", HttpStatus.OK);
        }

        //3, 将信息放入header
        if (userInfo != null) {
            Map headers = new HashMap<>();
            headers.put(BaseContextConstants.JWT_KEY_ACCOUNT, userInfo.getAccount());
            headers.put(BaseContextConstants.JWT_KEY_USER_ID, userInfo.getUserId().toString());
            headers.put(BaseContextConstants.JWT_KEY_NAME, userInfo.getName());
            headers.put(BaseContextConstants.JWT_KEY_ORG_ID, userInfo.getOrgId().toString());
            headers.put(BaseContextConstants.JWT_KEY_STATION_ID, userInfo.getStationId().toString());
            addHeaders(exchange, headers);
        } else {
            return unAuth(response, R.FAIL_CODE, "请求未授权", HttpStatus.OK);
        }

        log.info("userInfo: {}", userInfo);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }

    private boolean isIgnoreToken(String path) {
        return anyMatch(ignoreTokenProperties.getUrl(), path);
    }

}
