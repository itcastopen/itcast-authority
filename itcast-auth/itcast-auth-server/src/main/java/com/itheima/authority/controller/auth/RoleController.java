package com.itheima.authority.controller.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.authority.biz.service.auth.*;
import com.itheima.authority.biz.service.auth.*;
import com.itheima.authority.dto.auth.*;
import com.itheima.authority.entity.auth.Role;
import com.itheima.authority.entity.auth.RoleAuthority;
import com.itheima.authority.entity.auth.UserRole;
import com.itheima.authority.enumeration.auth.AuthorizeType;
import com.itheima.tools.base.BaseController;
import com.itheima.tools.base.R;
import com.itheima.tools.base.entity.SuperEntity;
import com.itheima.tools.database.mybatis.auth.DataScopeType;
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
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * 角色
 * </p>
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/role")
@Api(value = "Role", tags = "角色")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleAuthorityService roleAuthorityService;
    @Autowired
    private RoleOrgService roleOrgService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserGroupUserService userGroupUserService;
    @Autowired
    private RoleApplicationService roleApplicationService;
    @Autowired
    private DozerUtils dozer;

    @ApiOperation(value = "分页查询角色", notes = "分页查询角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @GetMapping("/page")
    @SysLog("分页查询角色")
    public R<IPage<Role>> page(RolePageDTO param) {
        IPage<Role> page = getPage();
        Role role = dozer.map(param, Role.class);
        role.setDsType(null);
        // 构建值不为null的查询条件
        LbqWrapper<Role> query = Wraps.lbQ(role)
                .geHeader(Role::getCreateTime, param.getStartCreateTime())
                .leFooter(Role::getCreateTime, param.getEndCreateTime())
                .orderByDesc(Role::getId);
        roleService.page(page, query);
        return success(page);
    }

    @ApiOperation(value = "根据条件查询角色列表", notes = "根据条件查询角色列表")
    @GetMapping("listAll")
    @SysLog("根据条件查询角色列表")
    public R<List<Role>> listAll(Role role) {

        LbqWrapper<Role> query = Wraps.lbQ(role)
                .orderByDesc(Role::getCreateTime);
        List<Role> roleList = roleService.list(query);

        return success(roleList);
    }

    @ApiOperation(value = "根据条件查询角色列表", notes = "根据条件查询角色列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "query", defaultValue = "1"),
    })
    @GetMapping
    @SysLog("根据条件查询角色列表")
    public R<List<RoleDTO>> list(@RequestParam(value = "userId", required = false) Long userId,
                                 @RequestParam(value = "status", required = false) Boolean status) {
        List<Long> ids = null;
        if (userId != null && userId != 0) {
            LbqWrapper<UserRole> userRoleLbqWrapper = Wraps.lbQ();
            userRoleLbqWrapper.eq(UserRole::getUserId, userId);
            List<UserRole> userRoleList = userRoleService.list(userRoleLbqWrapper);
            if (userRoleList.size() > 0) {
                ids = userRoleList.stream().mapToLong(UserRole::getRoleId).boxed().collect(Collectors.toList());
            }
        }
        LbqWrapper<Role> roleWrapper = Wraps.lbQ();
        roleWrapper.eq(status != null, Role::getStatus, status);
        roleWrapper.in(!CollectionUtils.isEmpty(ids), Role::getId, ids);

        return success(roleService.list(roleWrapper).stream().map(item -> dozer.map2(item, RoleDTO.class)).collect(Collectors.toList()));
    }

    @ApiOperation(value = "查询角色", notes = "查询角色")
    @GetMapping("/{id}")
    @SysLog("查询角色")
    public R<RoleQueryDTO> get(@PathVariable Long id) {
        Role role = roleService.getById(id);
        log.info("角色:{}  {}", id, role);
        if (role == null) {
            return success(null);
        }
        RoleQueryDTO query = dozer.map(role, RoleQueryDTO.class);
        if (query.getDsType() != null && DataScopeType.CUSTOMIZE.eq(query.getDsType())) {
            List<Long> orgList = roleOrgService.listOrgByRoleId(role.getId());
            log.info("角色数据权限:{}  {}", id, orgList);
            query.setOrgList(orgList);
        }
        List<Long> applicationIds = roleApplicationService.getApplicationIdsByRoleId(role.getId());
        query.setApplicationIds(applicationIds);
        return success(query);
    }

    @ApiOperation(value = "新增角色", notes = "新增角色不为空的字段")
    @PostMapping
    @SysLog("新增角色")
    public R<RoleSaveDTO> save(@RequestBody @Validated RoleSaveDTO data) {
        roleService.saveRole(data, getUserId());
        return success(data);
    }

    @ApiOperation(value = "修改角色", notes = "修改角色不为空的字段")
    @PutMapping
    @SysLog("修改角色")
    public R<RoleUpdateDTO> update(@RequestBody @Validated(SuperEntity.Update.class) RoleUpdateDTO data) {
        roleService.updateRole(data, getUserId());
        return success(data);
    }

    @ApiOperation(value = "删除角色", notes = "根据id物理删除角色")
    @DeleteMapping
    @SysLog("删除角色")
    public R<List<Role>> delete(@RequestParam("ids[]") List<Long> ids) {
        List<Role> roles = roleService.removeByIdWithUnUse(ids);
        return success(roles);
    }

    @ApiOperation(value = "查询角色拥有的资源id集合", notes = "查询角色拥有的资源id集合")
    @GetMapping("/authority/{roleId}")
    @SysLog("查询角色拥有的资源")
    public R<RoleAuthoritySaveDTO> findAuthorityIdByRoleId(@PathVariable Long roleId) {
        List<RoleAuthority> list = roleAuthorityService.list(Wraps.<RoleAuthority>lbQ().eq(RoleAuthority::getRoleId, roleId));
        List<Long> menuIdList = list.stream().filter(item -> AuthorizeType.MENU.eq(item.getAuthorityType())).mapToLong(RoleAuthority::getAuthorityId).boxed().collect(Collectors.toList());
        List<Long> resourceIdList = list.stream().filter(item -> AuthorizeType.RESOURCE.eq(item.getAuthorityType())).mapToLong(RoleAuthority::getAuthorityId).boxed().collect(Collectors.toList());
        RoleAuthoritySaveDTO roleAuthority = RoleAuthoritySaveDTO.builder()
                .menuIdList(menuIdList).resourceIdList(resourceIdList)
                .build();
        return success(roleAuthority);
    }


    @ApiOperation(value = "给角色配置权限", notes = "给角色配置权限")
    @PostMapping("/authority")
    @SysLog("给角色配置权限")
    public R<Boolean> saveRoleAuthority(@RequestBody RoleAuthoritySaveDTO roleAuthoritySaveDTO) {
        return success(roleAuthorityService.saveRoleAuthority(roleAuthoritySaveDTO));
    }


    // 提供给gateway
    @ApiOperation(value = "查询角色", notes = "查询角色")
    @GetMapping("/findRoleByUserId/{id}")
    public R<List<Long>> findRoleByUserId(@PathVariable("id") Long id) {
        List<Role> roles = roleService.findRoleByUserId(id);
        List<Long> roleIds = userGroupUserService.getRoleByUserId(id);
        if (CollectionUtils.isEmpty(roleIds)) {
            roleIds = new ArrayList<>();
        }
        roleIds.addAll(roles.stream().mapToLong(Role::getId).boxed().collect(Collectors.toList()));
        return success(roleIds);
    }

    // 提供给gateway
    @ApiOperation(value = "查询角色", notes = "查询角色")
    @GetMapping("/findAllRoles")
    public R<List<RoleResourceDTO>> findAllRolesWithResource() {
        List<RoleResourceDTO> roles = roleService.findAllRolesWithResource();
        return success(roles);
    }
}
