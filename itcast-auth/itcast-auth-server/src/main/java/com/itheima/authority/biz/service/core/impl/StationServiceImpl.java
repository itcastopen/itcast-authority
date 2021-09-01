package com.itheima.authority.biz.service.core.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.dao.core.StationMapper;
import com.itheima.authority.biz.service.auth.UserService;
import com.itheima.authority.biz.service.core.StationService;
import com.itheima.authority.dto.core.StationPageDTO;
import com.itheima.authority.entity.auth.User;
import com.itheima.authority.entity.core.Station;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import com.itheima.tools.database.mybatis.conditions.query.LbqWrapper;
import com.itheima.tools.dozer.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 业务实现类
 * 岗位
 * </p>
 */
@Slf4j
@Service
public class StationServiceImpl extends ServiceImpl<StationMapper, Station> implements StationService {

    @Autowired
    private DozerUtils dozer;
    @Autowired
    private UserService userService;

    /**
     * 按权限查询岗位的分页信息
     *
     * @param page
     * @param data
     * @return
     */
    @Override
    public IPage<Station> findStationPage(Page page, StationPageDTO data) {
        Station station = dozer.map(data, Station.class);
        //Wraps.lbQ(station); 这种写法值 不能和  ${ew.customSqlSegment} 一起使用
        LbqWrapper<Station> wrapper = Wraps.lbQ();

        // ${ew.customSqlSegment} 语法一定要手动eq like 等
        wrapper.like(Station::getName, station.getName())
                .like(Station::getDescribe, station.getDescribe())
                .eq(Station::getOrgId, station.getOrgId())
                .eq(Station::getStatus, station.getStatus())
                .geHeader(Station::getCreateTime, data.getStartCreateTime())
                .leFooter(Station::getCreateTime, data.getEndCreateTime())
        ;
        wrapper.orderByDesc(Station::getId);
        return baseMapper.selectPage(page, wrapper);
    }

    /**
     * 根据名称获取岗位
     * @param stationName
     * @return
     */
    @Override
    public Station getByName(String stationName) {
        LambdaQueryWrapper<Station> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Station::getName, stationName);
        return getOne(wrapper);
    }

    /**
     * 批量删除岗位
     * @param ids
     * @return
     */
    @Override
    public List<Station> remove(List<Long> ids) {
        List<Long> useIds = new ArrayList<>();
        List<Station> useStation = new ArrayList<>();
        for (Long id : ids) {
            int count = 0;
            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(User::getStationId, id);
            count = userService.count(wrapper);
            if (count > 0) {
                useIds.add(id);
            }
        }
        if (useIds.size() > 0) {
            ids.removeAll(useIds);
            useStation.addAll(this.listByIds(useIds));
        }

        if (ids.size() > 0) {
            super.removeByIds(ids);
        }
        return useStation;
    }
}
