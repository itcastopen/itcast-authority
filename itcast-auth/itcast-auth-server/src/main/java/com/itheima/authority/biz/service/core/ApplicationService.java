package com.itheima.authority.biz.service.core;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.authority.dto.core.OrgTreeDTO;
import com.itheima.authority.entity.core.Application;
import com.itheima.authority.entity.core.Org;
import com.itheima.tools.database.mybatis.conditions.query.LbqWrapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业务接口
 * 应用
 * </p>
 */
public interface ApplicationService extends IService<Application> {

    List<Application> currentList(LbqWrapper<Application> query);
}
