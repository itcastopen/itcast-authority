package com.itheima.authority.biz.service.auth.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.authority.biz.core.ApplicationContext;
import com.itheima.authority.biz.dao.auth.MenuMapper;
import com.itheima.authority.biz.service.auth.MenuService;
import com.itheima.authority.biz.service.auth.ResourceService;
import com.itheima.authority.dto.auth.MenuTreeDTO;
import com.itheima.authority.entity.auth.Menu;
import com.itheima.authority.entity.auth.Resource;
import com.itheima.tools.utils.NumberHelper;
import com.itheima.tools.utils.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.itheima.tools.utils.StrPool.DEF_PARENT_ID;

/**
 * <p>
 * 业务实现类
 * 菜单
 * </p>
 */
@Slf4j
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private ResourceService resourceService;

    /**
     * 查询用户可用菜单
     * <p>
     * 注意：什么地方需要清除 USER_MENU 缓存
     * 给用户重新分配角色时， 角色重新分配资源/菜单时
     *
     * @param group
     * @param userId
     * @return
     */
    @Override
    public List<Menu> findVisibleMenu(String group, Long userId) {
        List<Menu> visibleMenu;
        if (userId < 10L) { // 超级管理员 设置默认应用id
            visibleMenu = baseMapper.findAdminVisibleMenu();
        } else {
            Long applicationId = ApplicationContext.get();
            if (ApplicationContext.isSystem()) {
                applicationId = 1L;
            }
            visibleMenu = baseMapper.findVisibleMenu(group, userId, applicationId);
        }
        return visibleMenu;
    }

    /**
     * 移动菜单排序
     *
     * @param menu
     * @return
     */
    @Override
    public boolean move(Menu menu) {
        log.info("移动菜单:{}", menu);
        Long parentId = menu.getParentId();

        Menu dbMenu = this.getById(menu.getId());

        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Menu::getParentId, parentId);
        if (menu.getSortValue() > dbMenu.getSortValue()) {
            wrapper.gt(Menu::getSortValue, menu.getSortValue());
            menu.setSortValue(menu.getSortValue() + 1);
        } else {
            wrapper.ge(Menu::getSortValue, menu.getSortValue());
        }
        List<Menu> list = this.list(wrapper);
        list = list.stream().map(item -> item.setSortValue(item.getSortValue() + 2)).collect(Collectors.toList());
        log.info("修改当前位置后的全部菜单:{}", list);
        if (!CollectionUtils.isEmpty(list)) {
            this.updateBatchById(list);
        }
        this.updateById(menu);

        wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Menu::getParentId, parentId);
        wrapper.orderByAsc(Menu::getSortValue);
        list = this.list(wrapper);
        log.info("重新构建顺序:{}", list);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setSortValue(i);
        }
        if (!CollectionUtils.isEmpty(list)) {
            this.updateBatchById(list);
        }
        return true;
    }

    /**
     * 构建菜单树
     *
     * @param treeList
     * @return
     */
    @Override
    public List<MenuTreeDTO> buildTree(List<MenuTreeDTO> treeList) {
        List<MenuTreeDTO> result = TreeUtil.build(treeList);
        buildParentStatus(result, null);
        buildLevel(result, 1);
        return result;
    }

    /**
     * 构建菜单+资源树
     *
     * @param treeList
     * @return
     */
    @Override
    public List<MenuTreeDTO> buildResourceTree(List<MenuTreeDTO> treeList) {
        buildResource(treeList);
        List<MenuTreeDTO> result = TreeUtil.build(treeList);
        return result;
    }

    /**
     * 构建资源信息
     *
     * @param treeList
     */
    public void buildResource(List<MenuTreeDTO> treeList) {
        for (MenuTreeDTO menuTreeDTO : treeList) {
            LambdaQueryWrapper<Resource> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Resource::getMenuId, menuTreeDTO.getId());
            List<Resource> resources = resourceService.list(wrapper);
            menuTreeDTO.setResources(resources);
        }
    }

    /**
     * 构建父菜单状态
     *
     * @param list
     * @param isEnable
     */
    private void buildParentStatus(List<MenuTreeDTO> list, Boolean isEnable) {
        for (MenuTreeDTO menuTreeDTO : list) {
            menuTreeDTO.setParentIsEnable(isEnable);
            if (CollectionUtils.isEmpty(menuTreeDTO.getChildren())) {
                continue;
            } else {
                Boolean parentIsEnable = menuTreeDTO.getIsEnable();
                buildParentStatus(menuTreeDTO.getChildren(), parentIsEnable);
            }
        }
    }

    /**
     * 构建菜单级别
     *
     * @param list
     * @param level
     */
    private void buildLevel(List<MenuTreeDTO> list, int level) {
        for (MenuTreeDTO menuTreeDTO : list) {
            menuTreeDTO.setLevel(level);
            if (CollectionUtils.isEmpty(menuTreeDTO.getChildren())) {
                continue;
            } else {
                int parentLevel = menuTreeDTO.getLevel();
                buildLevel(menuTreeDTO.getChildren(), parentLevel + 1);
            }
        }
    }

    /**
     * 根据id集合删除菜单，并同时删除资源
     *
     * @param ids
     * @return
     */
    @Override
    public boolean removeByIds(Collection<? extends Serializable> ids) {
        if (ids.isEmpty()) {
            return true;
        }
        boolean result = super.removeByIds(ids);
        if (result) {
            resourceService.removeByMenuId(ids);
        }
        return result;
    }


    /**
     * 批量更新子菜单
     *
     * @param menu
     * @return
     */
    @Override
    public boolean updateChild(Menu menu) {
        Long id = menu.getId();
        LambdaQueryWrapper<Menu> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Menu::getParentId, id);
        List<Menu> list = this.list(wrapper);
        if (!CollectionUtils.isEmpty(list)) {
            for (Menu item : list) {
                Menu menuItem = new Menu();
                menuItem.setId(item.getId());
                menuItem.setIsEnable(menu.getIsEnable());
                updateChild(menuItem);
            }
        }
        updateById(menu);
        return true;
    }

    /**
     * 保存菜单
     *
     * @param menu
     * @return
     */
    @Override
    public boolean save(Menu menu) {

        menu.setIsEnable(NumberHelper.getOrDef(menu.getIsEnable(), true));
        menu.setIsPublic(NumberHelper.getOrDef(menu.getIsPublic(), false));
        menu.setParentId(NumberHelper.getOrDef(menu.getParentId(), DEF_PARENT_ID));

        return super.save(menu);
    }
}
