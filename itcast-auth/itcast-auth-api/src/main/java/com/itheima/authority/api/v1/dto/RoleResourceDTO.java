package com.itheima.authority.api.v1.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 实体类
 * 角色
 * </p>
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "RoleResourceDTO", description = "角色")
public class RoleResourceDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    @Length(max = 30, message = "角色名称长度不能超过30")
    private String name;
    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    private String code;

    private List<ResourceDTO> resources;

    public RoleResourceDTO() {
    }

    public RoleResourceDTO(RoleDTO role, List<ResourceDTO> resources) {
        this.id = role.getId();
        this.name = role.getName();
        this.code = role.getCode();
        this.resources = resources;
    }
}
