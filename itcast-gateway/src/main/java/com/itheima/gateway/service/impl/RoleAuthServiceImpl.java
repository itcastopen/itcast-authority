package com.itheima.gateway.service.impl;

import com.itheima.authority.api.v1.RoleApi;
import com.itheima.authority.api.v1.dto.RoleResourceDTO;
import com.itheima.authority.common.R;
import com.itheima.gateway.service.RoleAuthService;
import lombok.extern.slf4j.Slf4j;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class RoleAuthServiceImpl implements RoleAuthService {

    @Autowired
    RoleApi roleApi;

    @Override
    @Cacheable(value = "RoleAuthServiceImpl", key = "'findAllRoles'")
    public List<RoleResourceDTO> findAllRoles() {
        List<RoleResourceDTO> list;
        R<List<RoleResourceDTO>> allRoles = roleApi.findAllRoles();
        log.info("allRoles:{}", allRoles);
        list = allRoles.getData();
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        return list;
    }

    @Override
    @Cacheable(value = "RoleAuthServiceImpl", key = "'findRoleByUserId_'+#id")
    public List<Long> findRoleByUserId(Long id) {
        List<Long> list;
        R<List<Long>> roles = roleApi.findRoleByUserId(id);
        log.info("role:{}", roles);
        list = roles.getData();
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        return list;
    }
}
