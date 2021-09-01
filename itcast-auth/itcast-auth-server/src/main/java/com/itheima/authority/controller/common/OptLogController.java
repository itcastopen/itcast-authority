package com.itheima.authority.controller.common;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.authority.biz.service.common.OptLogService;
import com.itheima.authority.entity.common.OptLog;
import com.itheima.tools.base.BaseController;
import com.itheima.tools.base.R;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import com.itheima.tools.database.mybatis.conditions.query.LbqWrapper;
import com.itheima.tools.log.annotation.SysLog;
import com.itheima.tools.log.entity.OptLogDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * 系统日志
 * </p>
 *
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/optLog")
@Api(value = "OptLog", tags = "系统日志")
public class OptLogController extends BaseController {

    @Autowired
    private OptLogService optLogService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @ApiOperation(value = "分页查询系统日志", notes = "分页查询系统日志")
    @GetMapping("/page")
    public R<IPage<OptLog>> page(OptLog data) {
        IPage<OptLog> page = getPage();
        // 构建值不为null的查询条件
        LbqWrapper<OptLog> query = Wraps.lbQ(data)
                .leFooter(OptLog::getCreateTime, getEndCreateTime())
                .geHeader(OptLog::getCreateTime, getStartCreateTime())
                .orderByDesc(OptLog::getId);
        optLogService.page(page, query);
        return success(page);
    }
}
