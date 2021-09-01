package com.itheima.gateway.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@RefreshScope
@Component
@ConfigurationProperties("itcast.document")
public class RouteProperties {

    private final List<RouteResource> resources = new ArrayList<>();

}
