package com.itheima.authority.api.v1.hystrix;

import com.itheima.authority.api.v1.MenuApi;
import com.itheima.authority.api.v1.dto.VueRouter;
import com.itheima.authority.common.R;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuFailback implements MenuApi {
    @Override
    public R<List<VueRouter>> myRouter(String group, Long userId) {
        return R.timeout();
    }
}
