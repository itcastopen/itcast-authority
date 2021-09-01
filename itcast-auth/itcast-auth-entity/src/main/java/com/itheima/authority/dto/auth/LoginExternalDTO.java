package com.itheima.authority.dto.auth;

import com.itheima.authority.entity.core.Application;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 外部登录返回信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "LoginExternalDTO", description = "外部登录信息")
public class LoginExternalDTO implements Serializable {
    private static final long serialVersionUID = -3124612657759050173L;
    @ApiModelProperty(value = "用户信息")
    private UserDTO user;
    @ApiModelProperty(value = "权限列表")
    private List<String> permissionsList;
}
