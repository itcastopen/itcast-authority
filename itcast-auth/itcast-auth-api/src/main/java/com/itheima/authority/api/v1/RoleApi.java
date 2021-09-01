package com.itheima.authority.api.v1;

import com.itheima.authority.api.v1.dto.RoleDTO;
import com.itheima.authority.api.v1.dto.RoleResourceDTO;
import com.itheima.authority.api.v1.hystrix.RoleFailback;
import com.itheima.authority.common.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色 API
 */
@FeignClient(name = "${itcast.feign.authority-server:itcast-auth-server}", url = "${itcast.feign.authority-server-url:}", fallback = RoleFailback.class, path = "/role")
public interface RoleApi {

    /**
     * 根据角色编码，查找用户id
     *
     * @param codes 角色编码
     * @return
     */
    @GetMapping("/codes")
    R<List<Long>> findUserIdByCode(@RequestParam(value = "codes") String[] codes);

    /**
     * 查询角色
     *
     * @return
     */
    @RequestMapping(value = "/findRoleByUserId/{id}", method = RequestMethod.GET)
    R<List<Long>> findRoleByUserId(@PathVariable("id") Long id);

    /**
     * 查询全部角色和资源
     *
     * @return
     */
    @RequestMapping(value = "/findAllRoles", method = RequestMethod.GET)
    R<List<RoleResourceDTO>> findAllRoles();

    /**
     * 根据条件查询角色列表
     *
     * @param userId 用户id
     * @return 角色列表
     */
    @GetMapping
    R<List<RoleDTO>> list(@RequestParam("userId") Long userId);
}
