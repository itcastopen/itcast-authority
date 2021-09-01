package com.itheima.authority.api.v1;

import com.itheima.authority.api.v1.dto.UserDTO;
import com.itheima.authority.api.v1.hystrix.UserFailback;
import com.itheima.authority.common.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 用户 API
 */
@FeignClient(name = "${itcast.feign.authority-server:itcast-auth-server}", url = "${itcast.feign.authority-server-url:}", fallback = UserFailback.class, path = "/user")
public interface UserApi {

    /**
     * 获取用户列表
     *
     * @param ids
     * @param stationId
     * @param name
     * @param orgId
     * @return
     */
    @GetMapping("")
    R<List<UserDTO>> list(@RequestParam(name = "ids", required = false) List<Long> ids,
                          @RequestParam(name = "stationId", required = false) Long stationId,
                          @RequestParam(name = "name", required = false) String name,
                          @RequestParam(name = "orgId", required = false) Long orgId,
                          @RequestParam(name = "account", required = false) String account);

    /**
     * 获取用户详情
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    R<UserDTO> get(@PathVariable("id") Long id);

    /**
     * 查询用户
     *
     * @param account
     * @return 查询结果
     */
    @GetMapping("/account/{account}")
    R<UserDTO> getByAccount(@PathVariable("account") String account);
}
