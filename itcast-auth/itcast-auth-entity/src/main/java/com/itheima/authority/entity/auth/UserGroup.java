package com.itheima.authority.entity.auth;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.itheima.tools.base.entity.Entity;
import com.itheima.tools.base.entity.SuperEntity;
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
 * 用户组
 * 用户
 * </p>
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("itcast_auth_user_group")
@ApiModel(value = "UserGroup", description = "用户组")
public class UserGroup extends Entity<Long> {

    private static final long serialVersionUID = 1L;
    /**
     * 用户组名称
     */
    @ApiModelProperty(value = "用户组名称")
    @NotEmpty(message = "用户组名称不能为空", groups = {SuperEntity.Save.class})
    @Length(max = 30, message = "用户组名称长度不能超过30")
    @TableField(value = "name", condition = LIKE)
    private String name;

    /**
     * 角色ID
     * #itcast_auth_role
     */
    @ApiModelProperty(value = "用户数量")
    @TableField("user_count")
    private Integer userCount;

    /**
     * 角色ID
     * #itcast_auth_role
     */
    @ApiModelProperty(value = "角色ID")
    @NotNull(message = "角色ID不能为空", groups = {SuperEntity.Save.class})
    @TableField("role_id")
    private Long roleId;

    @ApiModelProperty(value = "角色名称")
    @TableField(exist = false)
    private String roleName;
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
}
