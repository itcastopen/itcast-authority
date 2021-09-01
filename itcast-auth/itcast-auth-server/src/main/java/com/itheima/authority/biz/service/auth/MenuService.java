package com.itheima.authority.biz.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.authority.dto.auth.MenuTreeDTO;
import com.itheima.authority.entity.auth.Menu;

import java.util.List;

/**
 * <p>
 * 业务接口
 * 菜单
 * </p>
 */
public interface MenuService extends IService<Menu> {

    boolean updateChild(Menu menu);

    List<Menu> findVisibleMenu(String group, Long userId);

    boolean move(Menu menu);

    List<MenuTreeDTO> buildTree(List<MenuTreeDTO> treeList);

    List<MenuTreeDTO> buildResourceTree(List<MenuTreeDTO> treeList);

}
