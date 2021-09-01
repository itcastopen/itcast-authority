package com.itheima.authority.biz.service.common;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.authority.entity.common.LoginLog;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业务接口
 * 系统日志
 * </p>
 *
 */
public interface LoginLogService extends IService<LoginLog> {

    LoginLog save(String account, String ua, String ip, String location, String description);

}
