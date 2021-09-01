package com.itheima.authority.dto.auth;

/**
 * 用户角色DTO
 *
 */

import java.io.Serializable;
import java.util.List;

import com.itheima.authority.entity.auth.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "UserRoleDTO", description = "用户角色DTO")
public class UserRoleDTO implements Serializable {
    @ApiModelProperty(value = "用户id")
    private List<Long> idList;
    @ApiModelProperty(value = "用户信息")
    private List<User> userList;
}
