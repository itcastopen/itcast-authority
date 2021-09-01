package com.itheima.authority.dto.auth;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.itheima.tools.model.ITreeNode;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 构建 Vue路由
 *
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VueRouter implements ITreeNode<VueRouter, Long>, Serializable {

    private static final long serialVersionUID = -3327478146308500708L;

    private Long id;
    private Long parentId;

    @ApiModelProperty(value = "路径")
    private String path;
    @ApiModelProperty(value = "菜单名称")
    private String name;
    @ApiModelProperty(value = "组件")
    private String component;
    @ApiModelProperty(value = "重定向")
    private String redirect;

    @ApiModelProperty(value = "元数据")
    private RouterMeta meta;
    @ApiModelProperty(value = "是否隐藏")
    private Boolean hidden = false;
    @ApiModelProperty(value = "总是显示")
    private Boolean alwaysShow = false;
    @ApiModelProperty(value = "子路由")
    private List<VueRouter> children;

    @Override
    public List<VueRouter> getChildren() {
        return this.children;
    }

    public Boolean getAlwaysShow() {
        return getChildren() != null && !getChildren().isEmpty();
    }

    public String getComponent() {
        if (getChildren() != null && !getChildren().isEmpty()) {
            return "Layout";
        }
        return this.component;
    }
}
