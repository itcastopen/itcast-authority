package com.itheima.authority.dto.auth;

import java.util.List;

import com.itheima.authority.entity.auth.Menu;
import com.itheima.authority.entity.auth.Resource;
import com.itheima.tools.model.ITreeNode;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * 树形菜单 DTO
 *
 */
@ToString(callSuper = true)
@Data
@ApiModel(value = "MenuTreeDTO", description = "菜单树")
public class MenuTreeDTO extends Menu implements ITreeNode<MenuTreeDTO, Long> {
    private List<MenuTreeDTO> children;

    private String label;

    private Boolean parentIsEnable;

    private int level;

    private List<Resource> resources;

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public Long getCreateUser() {
        return super.getCreateUser();
    }

    @Override
    public Long getUpdateUser() {
        return super.getUpdateUser();
    }

    @Override
    public List<MenuTreeDTO> getChildren() {
        return this.children;
    }

    @Override
    public void setChildren(List<MenuTreeDTO> children) {
        this.children = children;
    }

}
