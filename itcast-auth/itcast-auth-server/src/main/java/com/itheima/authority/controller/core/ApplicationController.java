package com.itheima.authority.controller.core;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.authority.biz.service.core.ApplicationService;
import com.itheima.authority.dto.core.ApplicationSaveDTO;
import com.itheima.authority.dto.core.ApplicationUpdateDTO;
import com.itheima.authority.entity.core.Application;
import com.itheima.tools.base.BaseController;
import com.itheima.tools.base.R;
import com.itheima.tools.base.entity.SuperEntity;
import com.itheima.tools.context.BaseContextHandler;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import com.itheima.tools.database.mybatis.conditions.query.LbqWrapper;
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


/**
 * <p>
 * 前端控制器
 * 应用
 * </p>
 */
@Slf4j
@RestController
@RequestMapping("/application")
@Api(value = "Application", tags = "应用")
public class ApplicationController extends BaseController {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private DozerUtils dozer;

    @ApiOperation(value = "分页查询应用", notes = "分页查询应用")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @GetMapping("/page")
    @SysLog("分页查询应用")
    public R<IPage<Application>> page(Application data) {
        IPage<Application> page = this.getPage();
        // 构建值不为null的查询条件
        LbqWrapper<Application> query = Wraps.lbQ(data);
        query.orderByDesc(Application::getCreateTime);
        this.applicationService.page(page, query);
        return this.success(page);
    }

    @ApiOperation(value = "查询应用集合", notes = "查询应用集合")
    @GetMapping("/list")
    @SysLog("查询应用集合")
    public R<List<Application>> list(Application data) {
        // 构建值不为null的查询条件
        LbqWrapper<Application> query = Wraps.lbQ(data);
        query.orderByDesc(Application::getCreateTime);
        List<Application> list = this.applicationService.list(query);
        return this.success(list);
    }

    @ApiOperation(value = "查询当前应用集合", notes = "查询当前应用集合")
    @GetMapping("/currentList")
    @SysLog("查询当前应用集合")
    public R<List<Application>> currentList(Application data) {
        // 构建值不为null的查询条件
        LbqWrapper<Application> query = Wraps.lbQ(data);
        query.orderByDesc(Application::getCreateTime);
        List<Application> list = this.applicationService.currentList(query);
        return this.success(list);
    }

    @ApiOperation(value = "查询应用", notes = "查询应用")
    @GetMapping("/{id}")
    @SysLog("查询应用")
    public R<Application> get(@PathVariable Long id) {
        return this.success(this.applicationService.getById(id));
    }

    @ApiOperation(value = "新增应用", notes = "新增应用不为空的字段")
    @PostMapping
    @SysLog("新增应用")
    public R<Application> save(@RequestBody @Validated ApplicationSaveDTO data) {
        if (data.getName().equals("权限管家")) {
            return this.fail("禁止使用权限管家作为应用名");
        }
        Application application = this.dozer.map(data, Application.class);
        this.applicationService.save(application);
        return this.success(application);
    }

    @ApiOperation(value = "修改应用", notes = "修改应用不为空的字段")
    @PutMapping
    @SysLog("修改应用")
    public R<Application> update(@RequestBody @Validated(SuperEntity.Update.class) ApplicationUpdateDTO data) {
        if (data.getName().equals("权限管家")) {
            return this.fail("禁止使用权限管家作为应用名");
        }
        Application application = this.dozer.map(data, Application.class);
        this.applicationService.updateById(application);
        return this.success(application);
    }

    @ApiOperation(value = "删除应用", notes = "根据id物理删除应用")
    @SysLog("删除应用")
    @DeleteMapping
    public R<Boolean> delete(@RequestParam("ids[]") List<Long> ids) {
        Boolean result = this.applicationService.removeByIds(ids);
        return this.success(result);
    }
}
