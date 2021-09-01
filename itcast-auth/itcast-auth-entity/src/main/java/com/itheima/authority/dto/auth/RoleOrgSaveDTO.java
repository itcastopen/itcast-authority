package com.itheima.authority.dto.auth;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 实体类
 * 角色组织关系
 * </p>
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "RoleOrgSaveDTO", description = "角色组织关系")
public class RoleOrgSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     * #itcast_auth_role
     */
    @ApiModelProperty(value = "角色ID")
    private Long roleId;
    /**
     * 组织ID
     * #itcast_core_org
     */
    @ApiModelProperty(value = "组织ID")
    private Long orgId;

}
