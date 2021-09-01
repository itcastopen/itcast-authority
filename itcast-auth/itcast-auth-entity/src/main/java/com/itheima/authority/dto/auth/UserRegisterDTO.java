package com.itheima.authority.dto.auth;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 用户注册DTO
 *
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UserRegisterDTO", description = "用户注册DTO")
public class UserRegisterDTO implements Serializable {

    @NotEmpty(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号")
    private String mobile;

    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "验证码")
    @NotEmpty(message = "验证码不能为空")
    private String verificationCode;
}
