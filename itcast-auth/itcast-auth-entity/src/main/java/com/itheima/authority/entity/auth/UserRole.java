package com.itheima.authority.entity.auth;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.itheima.tools.base.entity.SuperEntity;

import com.itheima.tools.base.entity.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 实体类
 * 角色分配
 * 账号角色绑定
 * </p>
 *
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("itcast_auth_user_role")
@ApiModel(value = "UserRole", description = "角色分配")
public class UserRole extends SuperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     * #itcast_auth_role
     */
    @ApiModelProperty(value = "角色ID")
    @NotNull(message = "角色ID不能为空")
    @TableField("role_id")
    private Long roleId;

    /**
     * 用户ID
     * #c_core_accou
     */
    @ApiModelProperty(value = "用户ID")
    @NotNull(message = "用户ID不能为空")
    @TableField("user_id")
    private Long userId;

    /**
     * 类型 0用户 1 用户组
     */
    @ApiModelProperty(value = "类型 0用户 1 用户组")
    @NotNull(message = "类型不能为空")
    @TableField("type")
    private Integer type;

}
