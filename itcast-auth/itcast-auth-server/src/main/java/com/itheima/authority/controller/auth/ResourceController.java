package com.itheima.authority.controller.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.authority.biz.service.auth.ResourceService;
import com.itheima.authority.dto.auth.ResourceQueryDTO;
import com.itheima.authority.dto.auth.ResourceSaveDTO;
import com.itheima.authority.dto.auth.ResourceUpdateDTO;
import com.itheima.authority.entity.auth.Resource;
import com.itheima.tools.base.BaseController;
import com.itheima.tools.base.R;
import com.itheima.tools.base.entity.SuperEntity;
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
 * 资源
 * </p>
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/resource")
@Api(value = "Resource", tags = "资源")
public class ResourceController extends BaseController {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private DozerUtils dozer;

    @ApiOperation(value = "分页查询资源", notes = "分页查询资源")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @GetMapping("/page")
    @SysLog("分页查询资源")
    public R<IPage<Resource>> page(Resource data) {
        IPage<Resource> page = getPage();
        // 构建值不为null的查询条件
        if (data.getMenuId() == null || data.getMenuId() < 0) {
            return success(page);
        }
        LbqWrapper<Resource> query = Wraps.lbQ(data);
        resourceService.page(page, query);
        return success(page);
    }

    @ApiOperation(value = "查询资源", notes = "查询资源")
    @GetMapping("/{id}")
    @SysLog("查询资源")
    public R<Resource> get(@PathVariable Long id) {
        return success(resourceService.getById(id));
    }

    @ApiOperation(value = "新增资源", notes = "新增资源不为空的字段")
    @PostMapping
    @SysLog("新增资源")
    public R<Resource> save(@RequestBody @Validated ResourceSaveDTO data) {
        Resource resource = dozer.map(data, Resource.class);
        resourceService.save(resource);
        return success(resource);
    }

    @ApiOperation(value = "修改资源", notes = "修改资源不为空的字段")
    @PutMapping
    @SysLog("修改资源")
    public R<Resource> update(@RequestBody @Validated(SuperEntity.Update.class) ResourceUpdateDTO data) {
        Resource resource = dozer.map(data, Resource.class);
        resourceService.updateById(resource);
        return success(resource);
    }

    @ApiOperation(value = "删除资源", notes = "根据id物理删除资源")
    @DeleteMapping
    @SysLog("删除资源")
    public R<Boolean> delete(@RequestParam("ids[]") List<Long> ids) {
        return success(resourceService.removeByIds(ids));
    }
}
