package com.itheima.authority.entity.auth;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.itheima.tools.base.entity.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 实体类
 * 角色应用关系
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
@TableName("itcast_auth_role_application")
@ApiModel(value = "RoleApplication", description = "角色应用关系")
public class RoleApplication extends SuperEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    @TableField("role_id")
    private Long roleId;

    /**
     * 应用ID
     */
    @ApiModelProperty(value = "应用ID")
    @TableField("application_id")
    private Long applicationId;

}
