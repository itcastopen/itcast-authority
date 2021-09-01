package com.itheima.authority.controller;

import com.itheima.authority.biz.service.core.OrgService;
import com.itheima.authority.biz.service.core.StationService;
import com.itheima.authority.entity.core.Org;
import com.itheima.authority.entity.core.Station;
import com.itheima.authority.enumeration.auth.AuthorizeType;
import com.itheima.authority.enumeration.auth.Sex;
import com.itheima.authority.enumeration.common.LogType;
import com.itheima.tools.base.BaseEnum;
import com.itheima.tools.base.R;
import com.itheima.tools.common.enums.HttpMethod;
import com.itheima.tools.database.mybatis.auth.DataScopeType;
import com.itheima.tools.utils.MapHelper;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用 控制器
 *
 */
@Slf4j
@RestController
@Api(value = "Common", tags = "通用Controller")
public class AuthorityGeneralController {

    @Autowired
    private OrgService orgService;
    @Autowired
    private StationService stationService;


    @ApiOperation(value = "获取当前系统所有枚举", notes = "获取当前系统所有枚举")
    @GetMapping("/enums")
    public R<Map<String, Map<String, String>>> enums() {
        Map<String, Map<String, String>> map = new HashMap<>(7);
        map.put(HttpMethod.class.getSimpleName(), BaseEnum.getMap(HttpMethod.values()));
        map.put(DataScopeType.class.getSimpleName(), BaseEnum.getMap(DataScopeType.values()));
        map.put(LogType.class.getSimpleName(), BaseEnum.getMap(LogType.values()));
        map.put(AuthorizeType.class.getSimpleName(), BaseEnum.getMap(AuthorizeType.values()));
        map.put(Sex.class.getSimpleName(), BaseEnum.getMap(Sex.values()));
        return R.success(map);
    }


    /**
     * 查询所有组织
     *
     * @return 查询结果
     */
    @ApiOperation(value = "查询所有组织", notes = "查询所有组织")
    @GetMapping("/orgs")
    public R<Map<String, Map<Long, String>>> find() {
        Map<String, Map<Long, String>> map = new HashMap<>(2);
        List<Station> stationList = this.stationService.list();
        List<Org> orgList = this.orgService.list();
        ImmutableMap<Long, String> stationMap = MapHelper.uniqueIndex(stationList, Station::getId, Station::getName);
        ImmutableMap<Long, String> orgMap = MapHelper.uniqueIndex(orgList, Org::getId, Org::getName);
        map.put(Org.class.getSimpleName(), orgMap);
        map.put(Station.class.getSimpleName(), stationMap);
        return R.success(map);
    }


    @Value("${server.port}")
    private String port;

}
