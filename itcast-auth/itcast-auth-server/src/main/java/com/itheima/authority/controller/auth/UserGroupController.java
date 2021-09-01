package com.itheima.authority.controller.auth;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.authority.biz.service.auth.RoleService;
import com.itheima.authority.biz.service.auth.UserGroupService;
import com.itheima.authority.biz.service.auth.UserGroupUserService;
import com.itheima.authority.biz.service.auth.UserService;
import com.itheima.authority.biz.service.core.OrgService;
import com.itheima.authority.dto.auth.UserGroupPageDTO;
import com.itheima.authority.dto.auth.UserGroupSaveDTO;
import com.itheima.authority.dto.auth.UserGroupUpdateDTO;
import com.itheima.authority.dto.core.OrgUserTreeDTO;
import com.itheima.authority.entity.auth.Role;
import com.itheima.authority.entity.auth.User;
import com.itheima.authority.entity.auth.UserGroup;
import com.itheima.authority.entity.auth.UserGroupUser;
import com.itheima.authority.entity.core.Org;
import com.itheima.authority.vo.UserGroupVO;
import com.itheima.tools.base.BaseController;
import com.itheima.tools.base.R;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import com.itheima.tools.database.mybatis.conditions.query.LbqWrapper;
import com.itheima.tools.dozer.DozerUtils;
import com.itheima.tools.log.annotation.SysLog;
import com.itheima.tools.utils.TreeUtil;
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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * 用户组
 * </p>
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/userGroup")
@Api(value = "UserGroup", tags = "用户组")
public class UserGroupController extends BaseController {

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private UserGroupUserService userGroupUserService;

    @Autowired
    private OrgService orgService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private DozerUtils dozer;

    @ApiOperation(value = "分页查询用户组", notes = "分页查询用户组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "页码", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "分页条数", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @GetMapping("/page")
    @SysLog("分页查询用户组")
    public R<Page<UserGroup>> page(UserGroupPageDTO userGroupPage) {
        Page<UserGroup> page = getPage();
        UserGroup userGroup = dozer.map2(userGroupPage, UserGroup.class);

        LbqWrapper<UserGroup> wrapper = Wraps.lbQ(userGroup);

        if (StringUtils.isNotEmpty(userGroupPage.getName())) {
            wrapper.like(UserGroup::getName, userGroupPage.getName());
        }
        if (userGroupPage.getRoleId() != null) {
            wrapper.like(UserGroup::getRoleId, userGroupPage.getRoleId());
        }

        wrapper.orderByDesc(UserGroup::getCreateTime);

        userGroupService.page(page, wrapper);
        List<UserGroup> newRecords = page.getRecords().stream().map(item -> {
            Role role = roleService.getById(item.getRoleId());
            if (null != role) {
                String roleName = role.getName();
                item.setRoleName(roleName);
            }

            List<UserGroupUser> userGroupUsers = userGroupUserService.getUserByGroupId(item.getId());
            item.setUserCount(userGroupUsers.size());
            return item;
        }).collect(Collectors.toList());
        page.setRecords(newRecords);
        return success(page);
    }

    @ApiOperation(value = "查询系组织和用户树", notes = "查询系组织和用户树")
    @GetMapping("/orgUserTree")
    @SysLog("查询系统所有的组织树")
    public R<List<OrgUserTreeDTO>> orgUserTree() {
        List<Org> list = orgService.list(Wraps.<Org>lbQ().orderByAsc(Org::getSortValue));
        List<OrgUserTreeDTO> treeList = new ArrayList<>();
        for (Org org : list) {
            treeList.add(OrgUserTreeDTO.builder().id(org.getId()).label(org.getName()).status(org.getStatus()).type(1).parentId(org.getParentId()).build());
            List<User> users = userService.list(Wraps.<User>lbQ().eq(User::getOrgId, org.getId()));
            if (!CollectionUtils.isEmpty(users)) {
                for (User user : users) {
                    treeList.add(OrgUserTreeDTO.builder().id(user.getId()).label(user.getName()).status(user.getStatus()).type(2).parentId(org.getId()).build());
                }
            }

        }
        return this.success(TreeUtil.build(treeList));
    }

    @ApiOperation(value = "查询用户组", notes = "查询用户组")
    @GetMapping("/{id}")
    @SysLog("查询用户组")
    public R<UserGroupVO> get(@PathVariable Long id) {
        UserGroup userGroup = userGroupService.getById(id);
        UserGroupVO userGroupVO = dozer.map2(userGroup, UserGroupVO.class);
        List<UserGroupUser> userGroupUsers = userGroupUserService.getUserByGroupId(id);
        userGroupVO.setUserIds(userGroupUsers.stream().map(item -> item.getUserId()).collect(Collectors.toList()));
        userGroupVO.setUserCount(userGroupVO.getUserIds().size());
        if (!CollectionUtils.isEmpty(userGroupVO.getUserIds())) {
            List<User> users = userService.getBaseMapper().selectBatchIds(userGroupVO.getUserIds());
            userGroupVO.setUserNames(users.stream().map(item -> item.getName()).collect(Collectors.toList()));
        }
        Role role = roleService.getById(userGroupVO.getRoleId());
        if (role != null) {
            userGroupVO.setRoleName(role.getName());
        }
        return success(userGroupVO);
    }

    @ApiOperation(value = "新增用户组", notes = "新增用户组不为空的字段")
    @PostMapping
    @SysLog("新增用户组")
    public R<UserGroup> save(@RequestBody @Validated UserGroupSaveDTO userGroupSaveDTO) {

        if (CollectionUtils.isEmpty(userGroupSaveDTO.getUserIds())) {
            return fail("成员为空");
        }
        UserGroup userGroup = dozer.map2(userGroupSaveDTO, UserGroup.class);
        userGroup.setUserCount(userGroupSaveDTO.getUserIds().size());
        userGroupService.save(userGroup);
        List<UserGroupUser> userGroupUsers = new ArrayList<>();
        for (Long userId : userGroupSaveDTO.getUserIds()) {
            User user = userService.getBaseMapper().selectById(userId);
            if (user != null) {
                UserGroupUser userGroupUser = new UserGroupUser();
                userGroupUser.setGroupId(userGroup.getId());
                userGroupUser.setUserId(userId);
                userGroupUser.setCreateUser(userGroup.getCreateUser());
                userGroupUsers.add(userGroupUser);
            }
        }

        userGroupUserService.saveBatch(userGroupUsers);

        return success(userGroup);
    }

    @ApiOperation(value = "修改用户组", notes = "修改用户组不为空的字段")
    @PutMapping
    @SysLog("修改用户组")
    public R<UserGroup> update(@RequestBody @Validated UserGroupUpdateDTO userGroupUpdateDTO) {
        userGroupService.updateById(userGroupUpdateDTO);
        UserGroup userGroup = userGroupService.getById(userGroupUpdateDTO.getId());

        if (!CollectionUtils.isEmpty(userGroupUpdateDTO.getUserIds())) {
            LambdaQueryWrapper<UserGroupUser> removeWrapper = new LambdaQueryWrapper<>();
            removeWrapper.eq(UserGroupUser::getGroupId, userGroup.getId());
            userGroupUserService.remove(removeWrapper);

            List<UserGroupUser> userGroupUsers = new ArrayList<>();
            for (Long userId : userGroupUpdateDTO.getUserIds()) {
                User user = userService.getBaseMapper().selectById(userId);
                if (user != null) {
                    UserGroupUser userGroupUser = new UserGroupUser();
                    userGroupUser.setGroupId(userGroup.getId());
                    userGroupUser.setUserId(userId);
                    userGroupUser.setCreateUser(userGroup.getCreateUser());
                    userGroupUsers.add(userGroupUser);
                }
            }
            userGroupUserService.saveBatch(userGroupUsers);
        }
        return success(userGroup);
    }

    @ApiOperation(value = "删除用户组", notes = "根据id物理删除用户组")
    @DeleteMapping
    @SysLog("删除用户组")
    public R<Boolean> delete(@RequestParam("ids[]") List<Long> ids) {
        userGroupService.removeByIds(ids);
        return success(true);
    }
}
