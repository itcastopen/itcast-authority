package com.itheima.authority.biz.service.auth;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.authority.entity.auth.RoleOrg;
import com.itheima.authority.entity.auth.RoleOrg;

/**
 * <p>
 * 业务接口
 * 角色组织关系
 * </p>
 *
 */
public interface RoleOrgService extends IService<RoleOrg> {

    List<Long> listOrgByRoleId(Long id);
}
