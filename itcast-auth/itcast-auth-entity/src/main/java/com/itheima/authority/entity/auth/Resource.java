package com.itheima.authority.entity.auth;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.itheima.tools.base.entity.Entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

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
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("itcast_auth_resource")
@ApiModel(value = "Resource", description = "资源")
public class Resource extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    @Override
    public int hashCode() {
        return (method + "/" + url).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Resource) {
            Resource entity = (Resource) obj;
            return ((method + "/" + url).equals(entity.getMethod() + "/" + entity.getUrl()));
        }
        return super.equals(obj);
    }

    /**
     * 资源编码
     * 规则：
     * 链接：
     * 数据列：
     * 按钮：
     */
    @ApiModelProperty(value = "资源编码")
    @Length(max = 255, message = "资源编码长度不能超过255")
    @TableField(value = "code", condition = LIKE)
    private String code;

    /**
     * 接口名称
     */
    @ApiModelProperty(value = "接口名称")
    @NotEmpty(message = "接口名称不能为空")
    @Length(max = 255, message = "接口名称长度不能超过255")
    @TableField(value = "name", condition = LIKE)
    private String name;

    /**
     * 请求方式
     */
    @ApiModelProperty(value = "请求方式")
    @NotEmpty(message = "请求方式不能为空")
    @Length(max = 10, message = "请求方式长度不能超过10")
    @TableField(value = "method", condition = LIKE)
    private String method;

    /**
     * 接口地址
     */
    @ApiModelProperty(value = "接口地址")
    @NotEmpty(message = "接口地址不能为空")
    @Length(max = 255, message = "接口地址长度不能超过255")
    @TableField(value = "url", condition = LIKE)
    private String url;

    /**
     * 菜单ID
     * #itcast_auth_menu
     */
    @ApiModelProperty(value = "菜单ID")
    @TableField("menu_id")
    private Long menuId;

    /**
     * 接口描述
     */
    @ApiModelProperty(value = "接口描述")
    @Length(max = 255, message = "接口描述长度不能超过255")
    @TableField(value = "describe_", condition = LIKE)
    private String describe;

}
