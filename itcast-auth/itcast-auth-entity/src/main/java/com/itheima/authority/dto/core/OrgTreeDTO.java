package com.itheima.authority.dto.core;

import java.util.List;

import com.itheima.authority.entity.core.Org;
import com.itheima.tools.model.ITreeNode;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * 组织树
 *
 */
@ToString(callSuper = true)
@Data
@ApiModel(value = "OrgTreeDTO", description = "组织树")
public class OrgTreeDTO extends Org implements ITreeNode<OrgTreeDTO, Long> {
    private List<OrgTreeDTO> children;
    private String label;

    private Boolean parentStatus;

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
    public List<OrgTreeDTO> getChildren() {
        return this.children;
    }

    @Override
    public void setChildren(List<OrgTreeDTO> children) {
        this.children = children;
    }

    public String getLabel() {
        return this.getName();
    }
}
