package com.itheima.authority.api.v1.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * <p>
 * 实体类
 * 资源
 * </p>
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "Resource", description = "资源")
public class ResourceDTO implements Serializable {


    @Override
    public int hashCode() {
        return (method + "/" + url).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ResourceDTO) {
            ResourceDTO entity = (ResourceDTO) obj;
            return ((method + "/" + url).equals(entity.getMethod() + "/" + entity.getUrl()));
        }
        return super.equals(obj);
    }

    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * 资源编码
     * 规则：
     * 链接：
     * 数据列：
     * 按钮：
     */
    @ApiModelProperty(value = "资源编码")
    @Length(max = 255, message = "资源编码长度不能超过255")
    private String code;

    /**
     * 接口名称
     */
    @ApiModelProperty(value = "接口名称")
    @NotEmpty(message = "接口名称不能为空")
    @Length(max = 255, message = "接口名称长度不能超过255")
    private String name;

    /**
     * 请求方式
     */
    @ApiModelProperty(value = "请求方式")
    @NotEmpty(message = "请求方式不能为空")
    @Length(max = 10, message = "请求方式长度不能超过10")
    private String method;

    /**
     * 接口地址
     */
    @ApiModelProperty(value = "接口地址")
    @NotEmpty(message = "接口地址不能为空")
    @Length(max = 255, message = "接口地址长度不能超过255")
    private String url;

    /**
     * 菜单ID
     * #itcast_auth_menu
     */
    @ApiModelProperty(value = "菜单ID")
    private Long menuId;

    /**
     * 接口描述
     */
    @ApiModelProperty(value = "接口描述")
    @Length(max = 255, message = "接口描述长度不能超过255")
    private String describe;

}
