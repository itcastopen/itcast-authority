package com.itheima.gateway.config;

import com.itheima.gateway.handler.SwaggerUiHandler;
import com.itheima.gateway.handler.SwaggerResourceHandler;
import com.itheima.gateway.handler.SwaggerSecurityHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * 路由配置信息
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class RouterFunctionConfig {

	private final SwaggerResourceHandler swaggerResourceHandler;
	private final SwaggerSecurityHandler swaggerSecurityHandler;
	private final SwaggerUiHandler swaggerUiHandler;

	@Bean
	public RouterFunction routerFunction() {
		return RouterFunctions.route(RequestPredicates.GET("/swagger-resources")
			.and(RequestPredicates.accept(MediaType.ALL)), swaggerResourceHandler)
			.andRoute(RequestPredicates.GET("/swagger-resources/configuration/ui")
				.and(RequestPredicates.accept(MediaType.ALL)), swaggerUiHandler)
			.andRoute(RequestPredicates.GET("/swagger-resources/configuration/security")
				.and(RequestPredicates.accept(MediaType.ALL)), swaggerSecurityHandler);
	}

}
