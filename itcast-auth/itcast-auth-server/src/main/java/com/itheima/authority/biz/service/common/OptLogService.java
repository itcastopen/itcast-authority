package com.itheima.authority.biz.service.common;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.authority.entity.common.OptLog;
import com.itheima.tools.log.entity.OptLogDTO;

/**
 * <p>
 * 业务接口
 * 系统日志
 * </p>
 *
 */
public interface OptLogService extends IService<OptLog> {

    boolean save(OptLogDTO entity);
}
