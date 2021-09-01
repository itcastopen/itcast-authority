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
@ConfigurationProperties("spring.cloud.gateway.ignore.token")
public class IgnoreTokenProperties {

    /**
     * 不过滤token url集合
     */
    private final List<String> url = new ArrayList<>();

}


