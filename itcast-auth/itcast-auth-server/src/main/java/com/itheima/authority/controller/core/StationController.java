package com.itheima.authority.controller.core;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.authority.biz.service.core.OrgService;
import com.itheima.authority.biz.service.core.StationService;
import com.itheima.authority.dto.core.StationPageDTO;
import com.itheima.authority.dto.core.StationSaveDTO;
import com.itheima.authority.dto.core.StationUpdateDTO;
import com.itheima.authority.entity.core.Org;
import com.itheima.authority.entity.core.Station;
import com.itheima.tools.base.BaseController;
import com.itheima.tools.base.R;
import com.itheima.tools.base.entity.SuperEntity;
import com.itheima.tools.dozer.DozerUtils;
import com.itheima.tools.log.annotation.SysLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * 岗位
 * </p>
 */
@Slf4j
@RestController
@RequestMapping("/station")
@Api(value = "Station", tags = "岗位")
public class StationController extends BaseController {

    @Autowired
    private StationService stationService;
    @Autowired
    private OrgService orgService;
    @Autowired
    private DozerUtils dozer;

    @ApiOperation(value = "分页查询岗位", notes = "分页查询岗位")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @GetMapping("/page")
    @SysLog("分页查询岗位")
    public R<IPage<Station>> page(StationPageDTO data) {

        Page<Station> page = getPage();
        stationService.findStationPage(page, data);
        List<Station> list = page.getRecords().stream().map(item -> {
            Org org = orgService.getById(item.getOrgId());
            if (org != null) {
                item.setOrgName(org.getName());
            } else {
                item.setOrgName("");
            }
            return item;
        }).collect(Collectors.toList());
        log.info("岗位分页查询:{} {}", page.getRecords(), list);
        page.setRecords(list);
        return success(page);
    }

    @ApiOperation(value = "查询岗位", notes = "查询岗位")
    @GetMapping("/list")
    @SysLog("查询岗位")
    public R<List<Station>> list(StationPageDTO data) {
        LambdaQueryWrapper<Station> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(data.getStatus() != null, Station::getStatus, data.getStatus());
        wrapper.orderByAsc(Station::getCreateTime);
        List<Station> list = stationService.list(wrapper);
        log.info("岗位查询:{}", list);
        return success(list);
    }

    @ApiOperation(value = "查询岗位", notes = "查询岗位")
    @GetMapping("/{id}")
    @SysLog("查询岗位")
    public R<Station> get(@PathVariable Long id) {
        return success(stationService.getById(id));
    }

    @ApiOperation(value = "新增岗位", notes = "新增岗位不为空的字段")
    @PostMapping
    @SysLog("新增岗位")
    public R<Station> save(@RequestBody @Validated StationSaveDTO data) {
        Station station = dozer.map(data, Station.class);
        stationService.save(station);
        return success(station);
    }

    @ApiOperation(value = "修改岗位", notes = "修改岗位不为空的字段")
    @PutMapping
    @SysLog("修改岗位")
    public R<Station> update(@RequestBody @Validated(SuperEntity.Update.class) StationUpdateDTO data) {
        Station station = dozer.map(data, Station.class);
        if (station.getOrgId() == null) {
            station.setOrgId(0L);
        }
        stationService.updateById(station);
        return success(station);
    }

    @ApiOperation(value = "删除岗位", notes = "根据id物理删除岗位")
    @SysLog("删除岗位")
    @DeleteMapping
    public R<List<Station>> delete(@RequestParam("ids[]") List<Long> ids) {
        List<Station> stations = stationService.remove(ids);
        return success(stations);
    }

}
