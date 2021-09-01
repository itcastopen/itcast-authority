package com.itheima.authority.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 构建 Vue路由
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VueRouter implements Serializable {

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
