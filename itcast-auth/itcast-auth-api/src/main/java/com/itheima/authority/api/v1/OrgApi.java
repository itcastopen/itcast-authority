package com.itheima.authority.api.v1;

import com.itheima.authority.api.v1.dto.OrgDTO;
import com.itheima.authority.api.v1.dto.OrgUserTreeDTO;
import com.itheima.authority.api.v1.hystrix.OrgFailback;
import com.itheima.authority.common.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 组织 API
 */
@FeignClient(name = "${itcast.feign.authority-server:itcast-auth-server}", url = "${itcast.feign.authority-server-url:}", fallback = OrgFailback.class, path = "/org")
public interface OrgApi {

    /**
     * 查询组织
     *
     * @param id 主键id
     * @return 查询结果
     */
    @GetMapping("/{id}")
    R<OrgDTO> get(@PathVariable("id") Long id);

    /**
     * 查询组织用户树
     *
     * @return
     */
    @GetMapping("/orgUserTree")
    R<List<OrgUserTreeDTO>> orgUserTree();
}
