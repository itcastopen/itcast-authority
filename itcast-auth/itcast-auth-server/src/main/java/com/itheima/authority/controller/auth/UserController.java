package com.itheima.authority.controller.auth;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.authority.biz.service.auth.RoleService;
import com.itheima.authority.biz.service.auth.UserService;
import com.itheima.authority.biz.service.core.OrgService;
import com.itheima.authority.biz.service.core.StationService;
import com.itheima.authority.dto.auth.*;
import com.itheima.authority.entity.auth.Role;
import com.itheima.authority.entity.auth.User;
import com.itheima.authority.entity.core.Org;
import com.itheima.authority.entity.core.Station;
import com.itheima.authority.vo.ImportResultVO;
import com.itheima.tools.base.BaseController;
import com.itheima.tools.base.R;
import com.itheima.tools.base.entity.SuperEntity;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import com.itheima.tools.database.mybatis.conditions.query.LbqWrapper;
import com.itheima.tools.dozer.DozerUtils;
import com.itheima.tools.log.annotation.SysLog;
import com.itheima.tools.user.feign.UserQuery;
import com.itheima.tools.user.model.SysOrg;
import com.itheima.tools.user.model.SysRole;
import com.itheima.tools.user.model.SysStation;
import com.itheima.tools.user.model.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.itheima.tools.exception.code.ExceptionCode.BASE_VALID_PARAM;

/**
 * <p>
 * 前端控制器
 * 用户
 * </p>
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/user")
@Api(value = "User", tags = "用户")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrgService orgService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private StationService stationService;
    @Autowired
    private DozerUtils dozer;

    @ApiOperation(value = "分页查询用户", notes = "分页查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "页码", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "分页条数", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @GetMapping("/page")
    @SysLog("分页查询用户")
    public R<Page<User>> page(UserPageDTO userPage) {
        Page<User> page = getPage();
        User user = dozer.map2(userPage, User.class);
        if (userPage.getOrgId() != null && userPage.getOrgId() >= 0) {
            user.setOrgId(null);
        }
        Map<String, Object> params = new HashMap<>();
        if (userPage.getOrgId() != null && userPage.getOrgId() >= 0) {
            List<Org> children = orgService.findChildren(userPage.getOrgId());
            params.put("orgIds", children.stream().mapToLong(Org::getId).boxed().collect(Collectors.toList())); // in
        }
        if (StringUtils.isNotEmpty(userPage.getName())) {
            params.put("name", userPage.getName()); // like
        }
        if (StringUtils.isNotEmpty(userPage.getAccount())) {
            params.put("account", userPage.getAccount()); // like
        }
        if (StringUtils.isNotEmpty(userPage.getEmail())) {
            params.put("email", userPage.getEmail()); // like
        }
        if (StringUtils.isNotEmpty(userPage.getMobile())) {
            params.put("mobile", userPage.getMobile()); // like
        }
        if (userPage.getSex() != null) {
            params.put("sex", userPage.getSex()); // =
        }
        if (userPage.getStatus() != null) {
            params.put("status", userPage.getStatus());// =
        }
        if (userPage.getStationId() != null) {
            params.put("stationId", userPage.getStationId());// =
        }
        if (userPage.getRoleId() != null) {
            params.put("roleId", userPage.getRoleId());// =
        }
        if (userPage.getRoleId() != null) {
            params.put("roleId", userPage.getRoleId());// =
        }
        if (userPage.getApplicationId() != null) {
            params.put("applicationId", userPage.getApplicationId());// =
        }

        userService.findUserPage(page, params);
        List<User> list = page.getRecords().stream().map(item -> {
            Org org = orgService.getById(item.getOrgId());
            if (org != null) {
                item.setOrgName(org.getName());
            } else {
                item.setOrgName("");
            }
            Station station = stationService.getById(item.getStationId());
            if (station != null) {
                item.setStationName(station.getName());
            } else {
                item.setStationName("");
            }

            List<Role> role = roleService.findAllRoleByUserId(item.getId());
            if (!CollectionUtils.isEmpty(role)) {
                List<String> roleNames = role.stream().map(roleItem -> roleItem.getName()).collect(Collectors.toList());
                item.setRoleNames(roleNames);
                List<Long> roleIds = role.stream().map(roleItem -> roleItem.getId()).collect(Collectors.toList());
                item.setRoles(roleIds);
            }
            return item;
        }).collect(Collectors.toList());
        page.setRecords(list);
        return success(page);
    }

    @ApiOperation(value = "根据条件获取用户列表", notes = "根据条件获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "id列表", paramType = "query", defaultValue = "[1,2]"),
            @ApiImplicitParam(name = "stationId", value = "岗位id", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "name", value = "用户名称", dataType = "string", paramType = "query", defaultValue = "张三"),
            @ApiImplicitParam(name = "orgId", value = "组织id", dataType = "long", paramType = "query", defaultValue = "1"),
    })
    @GetMapping("")
    @SysLog("根据条件获取用户列表")
    public R<List<User>> list(@RequestParam(name = "ids", required = false) List<Long> ids,
                              @RequestParam(name = "stationId", required = false) Long stationId,
                              @RequestParam(name = "name", required = false) String name,
                              @RequestParam(name = "orgId", required = false) Long orgId,
                              @RequestParam(name = "account", required = false) String account) {
        log.info("查询用户集合 ids:{} stationId:{} name:{} orgId:{}", ids, stationId, name, orgId);
        LbqWrapper<User> wrapper = Wraps.lbQ();
        if (ids != null && ids.size() > 0) {
            wrapper.in(User::getId, ids);
        }
        if (stationId != null && stationId != 0) {
            wrapper.eq(User::getStationId, stationId);
        }
        if (StringUtils.isNotEmpty(name)) {
            wrapper.like(User::getName, name);
        }
        if (StringUtils.isNotEmpty(account)) {
            wrapper.eq(User::getAccount, account);
        }
        if (orgId != null && orgId != 0) {
            wrapper.eq(User::getOrgId, orgId);
        }
        return R.success(userService.list(wrapper));
    }

    @ApiOperation(value = "查询用户", notes = "查询用户")
    @GetMapping("/{id}")
    @SysLog("查询用户")
    public R<User> get(@PathVariable Long id) {
        User item = userService.getById(id);
        List<Role> role = roleService.findRoleByUserId(item.getId());
        if (!CollectionUtils.isEmpty(role)) {
            List<String> roleNames = role.stream().map(roleItem -> roleItem.getName()).collect(Collectors.toList());
            item.setRoleNames(roleNames);
            List<Long> roleIds = role.stream().map(roleItem -> roleItem.getId()).collect(Collectors.toList());
            item.setRoles(roleIds);
        }
        Station station = stationService.getById(item.getStationId());
        if (station != null) {
            item.setStationName(station.getName());
        }
        Org org = orgService.getById(item.getOrgId());
        if (org != null) {
            item.setOrgName(org.getName());
        }
        log.info("getById({}) result:{}", id, item);
        return success(item);
    }

    @ApiOperation(value = "查询用户", notes = "查询用户")
    @GetMapping("/account/{account}")
    @SysLog("查询用户")
    public R<User> getByAccount(@PathVariable String account) {
        User item = userService.getByAccount(account);
        List<Role> role = roleService.findRoleByUserId(item.getId());
        if (!CollectionUtils.isEmpty(role)) {
            List<String> roleNames = role.stream().map(roleItem -> roleItem.getName()).collect(Collectors.toList());
            item.setRoleNames(roleNames);
            List<Long> roleIds = role.stream().map(roleItem -> roleItem.getId()).collect(Collectors.toList());
            item.setRoles(roleIds);
        }
        Station station = stationService.getById(item.getStationId());
        if (station != null) {
            item.setStationName(station.getName());
        }
        Org org = orgService.getById(item.getOrgId());
        if (org != null) {
            item.setOrgName(org.getName());
        }
        log.info("getByAccount({}) result:{}", account, item);
        return success(item);
    }

    @ApiOperation(value = "新增用户", notes = "新增用户不为空的字段")
    @PostMapping
    @SysLog("新增用户")
    public R<User> save(@RequestBody @Validated UserSaveDTO data) {
        User user = dozer.map(data, User.class);
        userService.saveUser(user);
        return success(user);
    }

    @ApiOperation(value = "修改用户", notes = "修改用户不为空的字段")
    @PutMapping
    @SysLog("修改用户")
    public R<User> update(@RequestBody @Validated(SuperEntity.Update.class) UserUpdateDTO data) {
        User user = dozer.map(data, User.class);
        userService.updateUser(user);
        return success(user);
    }

    @ApiOperation(value = "分配角色", notes = "分配角色不为空的字段")
    @PutMapping("role")
    @SysLog("分配角色")
    public R<User> updateRole(@RequestBody @Validated(SuperEntity.Update.class) UserUpdateDTO data) {
        User user = new User();
        user.setId(data.getId());
        user.setRoles(data.getRoles());
        userService.updateUserRole(user);
        return success(user);
    }

    @ApiOperation(value = "修改密码", notes = "修改密码")
    @PutMapping("/password")
    @SysLog("修改密码")
    public R<Boolean> updatePassword(@RequestBody UserUpdatePasswordDTO data) {
        return success(userService.updatePassword(data));
    }

    @ApiOperation(value = "重置密码", notes = "重置密码")
    @GetMapping("/reset")
    @SysLog("重置密码")
    public R<Boolean> resetTx(@RequestParam("ids[]") List<Long> ids) {
        userService.reset(ids);
        return success();
    }

    @ApiOperation(value = "删除用户", notes = "根据id物理删除用户")
    @DeleteMapping
    @SysLog("删除用户")
    public R<Boolean> delete(@RequestParam("ids[]") List<Long> ids) {
        userService.remove(ids);
        return success(true);
    }

    @ApiOperation(value = "查询角色的已关联用户", notes = "查询角色的已关联用户")
    @GetMapping(value = "/role/{roleId}")
    public R<UserRoleDTO> findUserByRoleId(@PathVariable("roleId") Long roleId, @RequestParam(value = "keyword", required = false) String keyword) {
        List<User> list = userService.findUserByRoleId(roleId, keyword);
        List<Long> idList = list.stream().mapToLong(User::getId).boxed().collect(Collectors.toList());
        return success(UserRoleDTO.builder().idList(idList).userList(list).build());
    }

    @PostMapping("importExcel")
    @ApiOperation("导入")
    public R<? extends Object> importExcel(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            return fail(BASE_VALID_PARAM.build("导入内容为空"));
        }
        Long begin = System.currentTimeMillis();
        ImportResultVO importResultVO = userService.importExcel(file);

        Long end = System.currentTimeMillis();

        log.info("导入excel 用时 :{}", (end - begin));
        return R.success(importResultVO);
    }

    /**
     * 获取当前登录信息
     *
     * @return
     */
    @ApiOperation(value = "获取当前登录信息", notes = "获取当前登录信息")
    @GetMapping("login")
    public R<LoginDTO> currentLogin() {
        return this.userService.current();
    }
}
