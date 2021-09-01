package com.itheima.authority.dto.auth;

import com.baomidou.mybatisplus.annotation.TableField;
import com.itheima.tools.base.entity.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * <p>
 * 实体类
 * 资源
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "ResourceUpdateDTO", description = "资源")
public class ResourceUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @NotNull(message = "id不能为空", groups = SuperEntity.Update.class)
    private Long id;
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
    private Long menuId;
    /**
     * 接口描述
     */
    @ApiModelProperty(value = "接口描述")
    @Length(max = 255, message = "接口描述长度不能超过255")
    private String describe;

}
