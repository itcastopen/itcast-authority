package com.itheima.authority.biz.service.auth.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.dao.auth.RoleMapper;
import com.itheima.authority.biz.dao.auth.UserMapper;
import com.itheima.authority.biz.excel.UserExcel;
import com.itheima.authority.biz.service.auth.ResourceService;
import com.itheima.authority.biz.service.auth.RoleOrgService;
import com.itheima.authority.biz.service.auth.UserRoleService;
import com.itheima.authority.biz.service.auth.UserService;
import com.itheima.authority.biz.service.core.OrgService;
import com.itheima.authority.biz.service.core.StationService;
import com.itheima.authority.dto.auth.LoginDTO;
import com.itheima.authority.dto.auth.ResourceQueryDTO;
import com.itheima.authority.dto.auth.UserDTO;
import com.itheima.authority.dto.auth.UserUpdatePasswordDTO;
import com.itheima.authority.entity.auth.*;
import com.itheima.authority.entity.core.Org;
import com.itheima.authority.entity.core.Station;
import com.itheima.authority.enumeration.auth.Sex;
import com.itheima.authority.vo.ImportResultVO;
import com.itheima.tools.base.R;
import com.itheima.tools.common.constant.BizConstant;
import com.itheima.tools.context.BaseContextHandler;
import com.itheima.tools.database.mybatis.auth.DataScopeType;
import com.itheima.tools.database.mybatis.conditions.Wraps;
import com.itheima.tools.database.mybatis.conditions.query.LbqWrapper;
import com.itheima.tools.dozer.DozerUtils;
import com.itheima.tools.utils.BizAssert;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 业务实现类
 * 账号
 * </p>
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleOrgService roleOrgService;
    @Autowired
    private OrgService orgService;
    @Autowired
    private StationService stationService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private DozerUtils dozer;


    /**
     * 分页查询用户
     *
     * @param page
     * @param params
     * @return
     */
    @Override
    public IPage<User> findUserPage(IPage<User> page, Map<String, Object> params) {
        IPage<User> userIPage = baseMapper.findUserPage(page, params, null);
        return userIPage;
    }

    /**
     * 重置密码错误次数
     *
     * @param id
     * @return
     */
    @Override
    public int resetPassErrorNum(Long id) {
        return baseMapper.resetPassErrorNum(id);
    }

    /**
     * 导入excel
     *
     * @param file
     * @return
     */
    @SneakyThrows
    @Override
    public ImportResultVO importExcel(MultipartFile file) {
        ImportParams importParams = new ImportParams();

        List<UserExcel> userExcels = ExcelImportUtil.importExcel(file.getInputStream(), UserExcel.class, importParams);
        int total = userExcels.size();
        log.debug("用户导入 解析文件:{} 条", total);

        TreeMap<Integer, String> resultMap = new TreeMap<>();
        for (int i = 0; i < userExcels.size(); i++) {
            UserExcel item = userExcels.get(i);
            try {
                User user = new User();
                if (StringUtils.isBlank(item.getAccount())) {
                    resultMap.put((i + 1), "行" + (i + 1) + " 账号为空");
                    continue;
                }
                user.setAccount(item.getAccount());

                if (StringUtils.isBlank(item.getName())) {
                    resultMap.put((i + 1), "行" + (i + 1) + " 姓名为空");
                    continue;
                }
                user.setName(item.getName());

                if (StringUtils.isBlank(item.getMobile())) {
                    resultMap.put((i + 1), "行" + (i + 1) + " 手机号为空");
                    continue;
                }
                user.setMobile(item.getMobile());

                if (StringUtils.isBlank(item.getOrgName())) {
                    resultMap.put((i + 1), "行" + (i + 1) + " 组织为空");
                    continue;
                }
                Org org = orgService.getByName(item.getOrgName());
                if (org == null) {
                    resultMap.put((i + 1), "行" + (i + 1) + " 组织为空");
                    continue;
                }
                user.setOrgId(org.getId());


                if (StringUtils.isBlank(item.getStationName())) {
                    resultMap.put((i + 1), "行" + (i + 1) + " 岗位为空");
                    continue;
                }
                Station station = stationService.getByName(item.getStationName());
                if (station == null) {
                    resultMap.put((i + 1), "行" + (i + 1) + " 岗位为空");
                    continue;
                }
                user.setStationId(station.getId());

                if (StringUtils.isBlank(item.getRoleNames())) {
                    resultMap.put((i + 1), "行" + (i + 1) + " 角色为空");
                    continue;
                }

                LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
                wrapper.in(Role::getName, item.getRoleNames().split(","));
                List<Role> roles = roleMapper.selectList(wrapper);

                if (CollectionUtils.isEmpty(roles)) {
                    resultMap.put((i + 1), "行" + (i + 1) + " 角色为空");
                    continue;
                }
                user.setRoles(roles.stream().map(role -> role.getId()).collect(Collectors.toList()));

                if (StringUtils.isBlank(item.getSex())) {
                    resultMap.put((i + 1), "行" + (i + 1) + " 性别为空");
                    continue;
                }
                user.setSex(item.getSex().equals("男") ? Sex.M : Sex.W);


                if (StringUtils.isBlank(item.getStatus())) {
                    resultMap.put((i + 1), "行" + (i + 1) + " 状态为空");
                    continue;
                }
                user.setStatus(item.getStatus().equals("启用"));
                user.setPassword("123456");
                user = this.saveUser(user);
                if (user == null) {
                    resultMap.put((i + 1), "行" + (i + 1) + " 用户导入失败");
                }
            } catch (Exception e) {
                if (e.getClass().getName().equals("org.springframework.dao.DuplicateKeyException")) {
                    resultMap.put((i + 1), "行" + (i + 1) + " 用户账号重复");
                } else {
                    log.warn("入库异常 {} ：", e.getClass().getName(), e);
                }
            }
        }

        ImportResultVO importResultVO = new ImportResultVO();
        importResultVO.setTotal(total);
        importResultVO.setFail(resultMap.values().size());
        importResultVO.setSuccess(total - importResultVO.getFail());
        importResultVO.setMessage(resultMap.values());
        return importResultVO;
    }

    @Override
    public void updateUserRole(User user) {
        LambdaQueryWrapper<UserRole> removeWrapper = new LambdaQueryWrapper<>();
        removeWrapper.eq(UserRole::getUserId, user.getId());
        userRoleService.remove(removeWrapper);

        if (CollectionUtils.isEmpty(user.getRoles())) {
            return;
        }
        List<UserRole> userRoles = new ArrayList<>();
        for (Long role : user.getRoles()) {
            userRoles.add(UserRole.builder().roleId(role).userId(user.getId()).build());
        }
        userRoleService.saveBatch(userRoles);
    }

    @Override
    public R<LoginDTO> current() {
        Long userId = BaseContextHandler.getUserId();
        log.info("当前登录用户权限：{}", userId);
        User user = this.getById(userId);
        List<Resource> resourceList = this.resourceService.findVisibleResource(ResourceQueryDTO.builder().userId(user.getId()).build());
        log.info("resourceList {} {}", resourceList.size(), resourceList);
        List<String> permissionsList = resourceList.stream().filter(item -> item != null).map(Resource::getCode).collect(Collectors.toList());
        if (user.getId() < 10L) {
            log.info("超级管理员");
            permissionsList = resourceService.findAllResource().stream().filter(item -> item != null).map(Resource::getCode).collect(Collectors.toList());
        }
        return R.success(LoginDTO.builder().user(this.dozer.map(user, UserDTO.class)).permissionsList(permissionsList).build());
    }

    /**
     * 修改密码
     *
     * @param data
     * @return
     */
    @Override
    public Boolean updatePassword(UserUpdatePasswordDTO data) {
        BizAssert.equals(data.getConfirmPassword(), data.getPassword(), "密码与确认密码不一致");

        User user = getById(data.getId());
        BizAssert.notNull(user, "用户不存在");
        String oldPassword = DigestUtils.md5Hex(data.getOldPassword());
        BizAssert.equals(user.getPassword(), oldPassword, "旧密码错误");

        User build = User.builder().password(data.getPassword()).id(data.getId()).build();
        this.updateUser(build);
        return true;
    }

    /**
     * 根据账户获取用户信息
     *
     * @param account
     * @return
     */
    @Override
    public User getByAccount(String account) {
        return this.baseMapper.getByAccount(account);
    }

    /**
     * 根据角色id 和 账号或名称 查询角色关联的用户
     * 注意，该接口只返回 id，账号，姓名，手机，性别
     *
     * @param roleId  角色id
     * @param keyword 账号或名称
     * @return
     */
    @Override
    public List<User> findUserByRoleId(Long roleId, String keyword) {
        return baseMapper.findUserByRoleId(roleId, keyword);
    }

    /**
     * 根据用户id获取用户权限
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public Map<String, Object> getDataScopeById(Long userId) {
        Map<String, Object> map = new HashMap<>(2);
        List<Long> orgIds = new ArrayList<>();
        DataScopeType dsType = DataScopeType.SELF;

        List<Role> list = roleMapper.findRoleByUserId(userId);
        Optional<Role> min = list.stream().min(Comparator.comparingInt((item) -> item.getDsType().getVal()));


        if (min.isPresent()) {
            Role role = min.get();
            dsType = role.getDsType();

            if (DataScopeType.CUSTOMIZE.eq(dsType)) {
                LbqWrapper<RoleOrg> wrapper = Wraps.<RoleOrg>lbQ().select(RoleOrg::getOrgId).eq(RoleOrg::getRoleId, role.getId());
                List<RoleOrg> roleOrgList = roleOrgService.list(wrapper);

                orgIds = roleOrgList.stream().mapToLong(RoleOrg::getOrgId).boxed().collect(Collectors.toList());
            } else if (DataScopeType.THIS_LEVEL.eq(dsType)) {
                User user = super.getById(userId);
                if (user != null) {
                    orgIds.add(user.getOrgId());
                }
            } else if (DataScopeType.THIS_LEVEL_CHILDREN.eq(dsType)) {
                User user = super.getById(userId);
                if (user != null) {
                    List<Org> orgList = orgService.findChildren(user.getOrgId());
                    orgIds = orgList.stream().mapToLong(Org::getId).boxed().collect(Collectors.toList());
                }
            }
        }
        map.put("dsType", dsType.getVal());
        map.put("orgIds", orgIds);
        return map;
    }

    /**
     * 根据用户id修改密码错误次数
     *
     * @param id
     */
    @Override
    public void updatePasswordErrorNumById(Long id) {
        baseMapper.incrPasswordErrorNumById(id);
    }

    /**
     * 修改上次登录时间
     *
     * @param account
     */
    @Override
    public void updateLoginTime(String account) {
        baseMapper.updateLastLoginTime(account, LocalDateTime.now());
    }

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    @Override
    public User saveUser(User user) {
        // 永不过期
        user.setPasswordExpireTime(null);

        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        user.setPasswordErrorNum(0);
        super.save(user);

        List<Long> roles = user.getRoles();
        if (!CollectionUtils.isEmpty(roles)) {
            List<UserRole> userRoles = new ArrayList<>();
            for (Long role : roles) {
                userRoles.add(UserRole.builder().roleId(role).userId(user.getId()).build());
            }
            userRoleService.saveBatch(userRoles);
        }

        return user;
    }

    /**
     * 重置密码
     *
     * @param ids
     * @return
     */
    @Override
    public boolean reset(List<Long> ids) {
        LocalDateTime passwordExpireTime = null;

        String defPassword = BizConstant.DEF_PASSWORD;
        super.update(Wraps.<User>lbU()
                .set(User::getPassword, defPassword)
                .set(User::getPasswordErrorNum, 0L)
                .set(User::getPasswordErrorLastTime, null)
                .set(User::getPasswordExpireTime, passwordExpireTime)
                .in(User::getId, ids)
        );
        return true;
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @Override
    public User updateUser(User user) {
        // 永不过期
        user.setPasswordExpireTime(null);

        if (StrUtil.isNotEmpty(user.getPassword())) {
            user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        }
        super.updateById(user);

        updateUserRole(user);

        return user;
    }

    /**
     * 批量删除用户
     *
     * @param ids
     * @return
     */
    @Override
    public boolean remove(List<Long> ids) {
        userRoleService.remove(Wraps.<UserRole>lbQ()
                .in(UserRole::getUserId, ids)
        );
        return super.removeByIds(ids);
    }
}
