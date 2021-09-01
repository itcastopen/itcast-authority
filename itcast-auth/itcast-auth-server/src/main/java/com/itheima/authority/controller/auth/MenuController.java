package com.itheima.authority.controller.auth;

import com.itheima.authority.biz.service.auth.MenuService;
import com.itheima.authority.dto.auth.MenuSaveDTO;
import com.itheima.authority.dto.auth.MenuTreeDTO;
import com.itheima.authority.dto.auth.MenuUpdateDTO;
import com.itheima.authority.dto.auth.VueRouter;
import com.itheima.authority.entity.auth.Menu;
import com.itheima.tools.base.BaseController;
import com.itheima.tools.base.R;
import com.itheima.tools.base.entity.SuperEntity;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import com.itheima.tools.dozer.DozerUtils;
import com.itheima.tools.log.annotation.SysLog;
import com.itheima.tools.utils.TreeUtil;
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
 * 菜单
 * </p>
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/menu")
@Api(value = "Menu", tags = "菜单")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private DozerUtils dozer;

    @ApiOperation(value = "查询菜单", notes = "查询菜单")
    @GetMapping("/{id}")
    @SysLog("查询菜单")
    public R<Menu> get(@PathVariable Long id) {
        return success(menuService.getById(id));
    }

    @ApiOperation(value = "新增菜单", notes = "新增菜单不为空的字段")
    @PostMapping
    @SysLog("新增菜单")
    public R<Menu> save(@RequestBody @Validated MenuSaveDTO data) {
        Menu menu = dozer.map(data, Menu.class);

        menuService.save(menu);
        return success(menu);
    }


    @ApiOperation(value = "修改菜单", notes = "修改菜单不为空的字段")
    @PutMapping
    @SysLog("修改菜单")
    public R<Menu> update(@RequestBody @Validated(SuperEntity.Update.class) MenuUpdateDTO data) {
        Menu menu = dozer.map(data, Menu.class);

        menuService.updateById(menu);

        if (menu.getIsEnable() != null) {
            Menu menuItem = new Menu();
            menuItem.setId(data.getId());
            menuItem.setIsEnable(data.getIsEnable());
            menuService.updateChild(menuItem);
        }

        return success(menu);
    }

    @ApiOperation(value = "启用禁用", notes = "启用禁用菜单")
    @PutMapping("enable")
    @SysLog("启用禁用")
    public R<Menu> updateEnable(@RequestBody @Validated(SuperEntity.Update.class) MenuUpdateDTO data) {
        Menu menuItem = new Menu();
        menuItem.setId(data.getId());
        menuItem.setIsEnable(data.getIsEnable());

        menuService.updateChild(menuItem);
        return success(menuItem);
    }

    @ApiOperation(value = "拖动菜单", notes = "拖动菜单")
    @PutMapping("move")
    @SysLog("拖动菜单")
    public R<Menu> move(@RequestBody @Validated(SuperEntity.Update.class) MenuUpdateDTO data) {
        Menu menu = dozer.map(data, Menu.class);
        this.menuService.move(menu);
        return this.success(menu);
    }

    @ApiOperation(value = "删除菜单", notes = "根据id物理删除菜单")
    @DeleteMapping
    @SysLog("删除菜单")
    public R<Boolean> delete(@RequestParam("ids[]") List<Long> ids) {
        menuService.removeByIds(ids);
        return success(true);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "group", value = "菜单组", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "query"),
    })
    @ApiOperation(value = "查询用户可用的所有菜单路由树", notes = "查询用户可用的所有菜单路由树")
    @GetMapping("/router")
    public R<List<VueRouter>> myRouter(@RequestParam(value = "group", required = false) String group,
                                       @RequestParam(value = "userId", required = false) Long userId) {
        if (userId == null || userId <= 0) {
            userId = getUserId();
        }
        log.info("菜单路由 userId：{}", userId);
        List<Menu> list = menuService.findVisibleMenu(group, userId);
        List<VueRouter> treeList = dozer.mapList(list, VueRouter.class);

        log.info("菜单路由 结果：{}", treeList);
        return success(TreeUtil.build(treeList));
    }

    @ApiOperation(value = "查询系统所有的菜单", notes = "查询系统所有的菜单")
    @GetMapping("/tree")
    @SysLog("查询系统所有的菜单")
    public R<List<MenuTreeDTO>> allTree(Menu menu) {
        List<Menu> list = menuService.list(Wraps.lbQ(menu).orderByAsc(Menu::getSortValue));
        List<MenuTreeDTO> treeList = dozer.mapList(list, MenuTreeDTO.class);
        List<MenuTreeDTO> result = menuService.buildTree(treeList);
        return success(result);
    }

    @ApiOperation(value = "查询系统所有的菜单+资源树", notes = "查询系统所有的菜单+资源树")
    @GetMapping("/resource/tree")
    @SysLog("查询系统所有的菜单+资源树")
    public R<List<MenuTreeDTO>> resourceTree() {
        List<Menu> list = menuService.list(Wraps.<Menu>lbQ().orderByAsc(Menu::getSortValue));
        List<MenuTreeDTO> treeList = dozer.mapList(list, MenuTreeDTO.class);
        List<MenuTreeDTO> result = menuService.buildResourceTree(treeList);
        return success(result);
    }
}
