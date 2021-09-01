package com.itheima.authority.dto.auth;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.itheima.authority.enumeration.auth.Sex;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * 用户
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "UserDTO", description = "用户")
public class UserDTO implements Serializable {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "上级领导")
    private Long superior;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    @NotEmpty(message = "账号不能为空")
    @Length(max = 30, message = "账号长度不能超过30")
    private String account;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @NotEmpty(message = "姓名不能为空")
    @Length(max = 50, message = "姓名长度不能超过50")
    private String name;

    /**
     * 组织ID
     * #itcast_core_org
     */
    @ApiModelProperty(value = "组织ID")
    private Long orgId;

    /**
     * 岗位ID
     * #itcast_core_station
     */
    @ApiModelProperty(value = "岗位ID")
    private Long stationId;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @Length(max = 255, message = "邮箱长度不能超过255")
    private String email;

    /**
     * 手机
     */
    @ApiModelProperty(value = "手机")
    @Length(max = 20, message = "手机长度不能超过20")
    private String mobile;

    /**
     * 性别
     * #Sex{W:女;M:男;N:未知}
     */
    @ApiModelProperty(value = "性别")
    private Sex sex;

    /**
     * 启用状态 1启用 0禁用
     */
    @ApiModelProperty(value = "启用状态 1启用 0禁用")
    private Boolean status;

    /**
     * 照片
     */
    @ApiModelProperty(value = "头像")
    private String avatar;

    /**
     * 工作描述
     * 比如：  市长、管理员、局长等等   用于登陆展示
     */
    @ApiModelProperty(value = "工作描述")
    private String workDescribe;

    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间")
    private LocalDateTime lastLoginTime;

}
