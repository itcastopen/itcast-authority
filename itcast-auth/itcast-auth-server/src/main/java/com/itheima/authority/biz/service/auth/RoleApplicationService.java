package com.itheima.authority.biz.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.authority.entity.auth.RoleApplication;
import com.itheima.authority.entity.auth.RoleOrg;

import java.util.List;

/**
 * <p>
 * 业务接口
 * 角色应用关系
 * </p>
 *
 */
public interface RoleApplicationService extends IService<RoleApplication> {

    List<Long> getApplicationIdsByRoleId(Long id);
}
