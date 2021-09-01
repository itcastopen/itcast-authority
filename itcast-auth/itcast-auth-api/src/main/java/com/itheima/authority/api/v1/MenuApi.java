package com.itheima.authority.api.v1;

import com.itheima.authority.api.v1.dto.VueRouter;
import com.itheima.authority.api.v1.hystrix.MenuFailback;
import com.itheima.authority.common.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 菜单 API
 */
@FeignClient(name = "${itcast.feign.authority-server:itcast-auth-server}", url = "${itcast.feign.authority-server-url:}", fallback = MenuFailback.class, path = "/menu")
public interface MenuApi {

    @GetMapping("/router")
    public R<List<VueRouter>> myRouter(@RequestParam(value = "group", required = false) String group,
                                       @RequestParam(value = "userId", required = false) Long userId);

}
