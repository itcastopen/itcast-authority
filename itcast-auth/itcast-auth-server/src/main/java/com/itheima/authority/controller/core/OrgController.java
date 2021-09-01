package com.itheima.authority.controller.core;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.authority.biz.service.auth.UserService;
import com.itheima.authority.biz.service.core.OrgService;
import com.itheima.authority.dto.core.OrgSaveDTO;
import com.itheima.authority.dto.core.OrgTreeDTO;
import com.itheima.authority.dto.core.OrgUpdateDTO;
import com.itheima.authority.dto.core.OrgUserTreeDTO;
import com.itheima.authority.entity.auth.User;
import com.itheima.authority.entity.core.Org;
import com.itheima.tools.base.BaseController;
import com.itheima.tools.base.R;
import com.itheima.tools.base.entity.SuperEntity;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import com.itheima.tools.database.mybatis.conditions.query.LbqWrapper;
import com.itheima.tools.dozer.DozerUtils;
import com.itheima.tools.log.annotation.SysLog;
import com.itheima.tools.utils.BizAssert;
import com.itheima.tools.utils.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.itheima.tools.utils.StrPool.DEF_PARENT_ID;
import static com.itheima.tools.utils.StrPool.DEF_ROOT_PATH;


/**
 * <p>
 * 前端控制器
 * 组织
 * </p>
 */
@Slf4j
@RestController
@RequestMapping("/org")
@Api(value = "Org", tags = "组织")
public class OrgController extends BaseController {

    @Autowired
    private OrgService orgService;
    @Autowired
    private UserService userService;
    @Autowired
    private DozerUtils dozer;

//    /**
//     * 分页查询组织
//     *
//     * @param data 分页查询对象
//     * @return 查询结果
//     */
//    @ApiOperation(value = "分页查询组织", notes = "分页查询组织")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
//            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
//    })
//    @GetMapping("/page")
//    @SysLog("分页查询组织")
//    public R<IPage<Org>> page(Org data) {
//        IPage<Org> page = this.getPage();
//        // 构建值不为null的查询条件
//        LbqWrapper<Org> query = Wraps.lbQ(data);
//        this.orgService.findByPage(page, query);
//        return this.success(page);
//    }

//    /**
//     * 分页查询组织
//     *
//     * @return 查询结果
//     */
//    @ApiOperation(value = "分页查询组织", notes = "分页查询组织")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
//            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
//    })
//    @GetMapping("/pageLike")
//    @SysLog("分页查询组织")
//    public R<IPage<Org>> pageLike(String keyword, Long cityId, String latitude, String longitude) {
//        IPage<Org> page = this.getPage();
//
//        Map params = new HashMap();
//        params.put("keyword", keyword);
//        params.put("cityId", cityId);
//        params.put("latitude", latitude);
//        params.put("longitude", longitude);
//
//        page = this.orgService.pageLike(new Page<>(page.getCurrent(), page.getSize()), params);
//
//        return this.success(page);
//    }

    @ApiOperation(value = "查询组织", notes = "查询组织")
    @GetMapping("/{id}")
    @SysLog("查询组织")
    public R<Org> get(@PathVariable Long id) {
        return this.success(this.orgService.findById(id));
    }

    @ApiOperation(value = "新增组织", notes = "新增组织不为空的字段")
    @PostMapping
    @SysLog("新增组织")
    public R<Org> save(@RequestBody @Validated OrgSaveDTO data) {
        Org org = this.dozer.map(data, Org.class);
        if (org.getParentId() == null || org.getParentId() <= 0) {
            org.setParentId(DEF_PARENT_ID);
            org.setTreePath(DEF_ROOT_PATH);
        } else {
            Org parent = this.orgService.getById(org.getParentId());
            BizAssert.notNull(parent, "父组织不能为空");

            org.setTreePath(StringUtils.join(parent.getTreePath(), parent.getId(), DEF_ROOT_PATH));
        }
        this.orgService.saveOrg(org);
        return this.success(org);
    }

    @ApiOperation(value = "修改组织", notes = "修改组织不为空的字段")
    @PutMapping
    @SysLog("修改组织")
    public R<Org> update(@RequestBody @Validated(SuperEntity.Update.class) OrgUpdateDTO data) {
        Org org = this.dozer.map(data, Org.class);
        this.orgService.updateOrg(org);
        if (data.getStatus() != null) {
            org = new Org();
            org.setId(data.getId());
            org.setStatus(data.getStatus());
            this.orgService.updateStatus(org);
        }
        return this.success(org);
    }

//    @ApiOperation(value = "拖动组织", notes = "拖动组织")
//    @PutMapping("move")
//    @SysLog("拖动组织")
//    public R<Org> move(@RequestBody @Validated(SuperEntity.Update.class) OrgUpdateDTO data) {
//        Org org = this.dozer.map(data, Org.class);
//        this.orgService.move(org);
//        return this.success(org);
//    }

    @ApiOperation(value = "修改组织状态", notes = "修改组织状态不为空的字段")
    @PutMapping("status")
    @SysLog("修改组织状态")
    public R<Org> updateStatus(@RequestBody @Validated(SuperEntity.Update.class) OrgUpdateDTO data) {
        Org org = new Org();
        org.setId(data.getId());
        org.setStatus(data.getStatus());
        this.orgService.updateStatus(org);
        return this.success(org);
    }

    @ApiOperation(value = "删除组织", notes = "根据id物理删除组织")
    @SysLog("删除组织")
    @DeleteMapping
    public R<List<Org>> delete(@RequestParam("ids[]") List<Long> ids) {
        List<Org> orgs = this.orgService.remove(ids);
        return this.success(orgs);
    }

    @ApiOperation(value = "查询系统所有的组织树", notes = "查询系统所有的组织树")
    @GetMapping("/tree")
    @SysLog("查询系统所有的组织树")
    public R<List<OrgTreeDTO>> tree(@RequestParam(value = "name", required = false) String name,
                                    @RequestParam(value = "status", required = false) Boolean status) {
        List<Org> list = this.orgService.list(Wraps.<Org>lbQ().like(Org::getName, name)
                .eq(Org::getStatus, status).orderByAsc(Org::getSortValue));
        List<OrgTreeDTO> treeList = this.dozer.mapList(list, OrgTreeDTO.class);
        List<OrgTreeDTO> result = orgService.buildTree(treeList);
        return this.success(result);
    }

//    /**
//     * 根据条件查询组织列表
//     *
//     * @param orgType  组织类型
//     * @param ids      组织id列表
//     * @param countyId 区县id
//     * @param pid      父级id
//     * @param pids     父级id列表
//     * @return
//     */
//    @ApiOperation(value = "根据条件查询组织列表", notes = "根据条件查询组织列表")
//    @GetMapping
//    @SysLog("根据条件查询组织列表")
//    public R<List<Org>> list(@RequestParam(name = "orgType", required = false) Integer orgType,
//                             @RequestParam(name = "ids", required = false) List<Long> ids,
//                             @RequestParam(name = "countyId", required = false) Long countyId,
//                             @RequestParam(name = "pid", required = false) Long pid,
//                             @RequestParam(name = "pids", required = false) List<Long> pids) {
//        return this.success(orgService.findAll(orgType, ids, countyId, pid, pids));
//    }

//    /**
//     * 根据条件查询组织列表
//     *
//     * @param orgType   组织类型
//     * @param countyIds 区县id 集合
//     * @return
//     */
//    @ApiOperation(value = "根据条件查询组织列表", notes = "根据条件查询组织列表")
//    @GetMapping("listByCountyIds")
//    @SysLog("根据条件查询组织列表")
//    public R<List<Org>> listByCountyIds(@RequestParam(name = "orgType", required = false) Integer orgType,
//                                        @RequestParam(name = "countyIds", required = false) List<Long> countyIds) {
//        LambdaQueryWrapper<Org> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(orgType != null, Org::getOrgType, orgType);
//        wrapper.in(!CollectionUtils.isEmpty(countyIds), Org::getCountyId, countyIds);
//        return this.success(orgService.list(wrapper));
//    }

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
}
