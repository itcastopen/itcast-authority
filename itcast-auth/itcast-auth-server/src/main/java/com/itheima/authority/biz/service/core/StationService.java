package com.itheima.authority.biz.service.core;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.authority.dto.core.StationPageDTO;
import com.itheima.authority.entity.core.Station;

import java.util.List;

/**
 * <p>
 * 业务接口
 * 岗位
 * </p>
 *
 */
public interface StationService extends IService<Station> {

    IPage<Station> findStationPage(Page page, StationPageDTO data);

    Station getByName(String stationName);

    List<Station> remove(List<Long> ids);
}
