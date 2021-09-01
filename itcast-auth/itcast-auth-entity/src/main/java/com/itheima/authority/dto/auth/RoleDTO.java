package com.itheima.authority.dto.auth;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * 角色
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "RoleDTO", description = "角色")
public class RoleDTO {
    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    @NotEmpty(message = "角色名称不能为空")
    @Length(max = 30, message = "角色名称长度不能超过30")
    @TableField(value = "name", condition = LIKE)
    private String name;


    @ApiModelProperty(value = "互斥角色")
    private Long repel;
}
