package com.itheima.authority.entity.auth;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.itheima.tools.base.entity.Entity;
import com.itheima.tools.database.mybatis.auth.DataScopeType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * <p>
 * 实体类
 * 角色
 * </p>
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("itcast_auth_role")
@ApiModel(value = "Role", description = "角色")
public class Role extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    @NotEmpty(message = "角色名称不能为空")
    @Length(max = 30, message = "角色名称长度不能超过30")
    @TableField(value = "name", condition = LIKE)
    private String name;

    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    @Length(max = 20, message = "角色编码长度不能超过20")
    @TableField(value = "code", condition = LIKE)
    private String code;

    /**
     * 功能描述
     */
    @ApiModelProperty(value = "功能描述")
    @Length(max = 100, message = "功能描述长度不能超过100")
    @TableField(value = "describe_", condition = LIKE)
    private String describe;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Boolean status;

    /**
     * 是否内置角色
     */
    @ApiModelProperty(value = "是否内置角色")
    @TableField("readonly")
    private Boolean readonly;

    /**
     * 数据权限类型
     * #DataScopeType{ALL:1,全部;THIS_LEVEL:2,本级;THIS_LEVEL_CHILDREN:3,本级以及子级;CUSTOMIZE:4,自定义;SELF:5,个人;}
     */
    @ApiModelProperty(value = "数据权限类型")
    @NotNull(message = "数据权限类型不能为空")
    @TableField("ds_type")
    private DataScopeType dsType;

    @ApiModelProperty(value = "互斥角色")
    @NotNull(message = "互斥角色不能为空")
    @TableField("repel")
    private Long repel;

    @ApiModelProperty(value = "应用ID")
    @TableField("application_id")
    private Long applicationId;

}
