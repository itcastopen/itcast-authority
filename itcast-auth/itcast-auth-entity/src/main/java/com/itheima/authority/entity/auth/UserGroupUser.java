package com.itheima.authority.entity.auth;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.itheima.tools.base.entity.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * <p>
 * 实体类
 * 角色分配
 * 账号角色绑定
 * </p>
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("itcast_auth_user_group_user")
@ApiModel(value = "UserGroupUser", description = "用户组、用户绑定")
public class UserGroupUser extends SuperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户组ID
     * #itcast_auth_role
     */
    @ApiModelProperty(value = "用户组ID")
    @NotNull(message = "用户组ID不能为空")
    @TableField("group_id")
    private Long groupId;

    /**
     * 用户ID
     * #c_core_accou
     */
    @ApiModelProperty(value = "用户ID")
    @NotNull(message = "用户ID不能为空")
    @TableField("user_id")
    private Long userId;

}
