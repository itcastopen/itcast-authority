package com.itheima.gateway.controller;

import com.itheima.tools.base.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DefaultHystrixController {

    @RequestMapping(value = "/fallback", method = RequestMethod.GET)
    public R fallback() {
        log.info("服务异常，已熔断！");
        R r = R.fail(R.FAIL_CODE, "服务异常，请稍后重试！");
        return r;
    }

}
