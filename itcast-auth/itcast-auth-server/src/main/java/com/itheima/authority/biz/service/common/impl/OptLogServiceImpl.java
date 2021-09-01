package com.itheima.authority.biz.service.common.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.dao.common.OptLogMapper;
import com.itheima.authority.biz.service.common.OptLogService;
import com.itheima.authority.entity.common.OptLog;
import com.itheima.tools.dozer.DozerUtils;
import com.itheima.tools.log.entity.OptLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务实现类
 * 系统日志
 * </p>
 */
@Slf4j
@Service
public class OptLogServiceImpl extends ServiceImpl<OptLogMapper, OptLog> implements OptLogService {
    @Autowired
    DozerUtils dozer;

    /**
     * 保存日志
     *
     * @param entity
     * @return
     */
    @Override
    public boolean save(OptLogDTO entity) {
        return super.save(dozer.map(entity, OptLog.class));
    }
}
