package com.itheima.authority.api.v1.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户
 */
@Data
@ApiModel(value = "UserDTO", description = "用户")
public class UserDTO implements Serializable {

    private Long id;
    private LocalDateTime createTime;
    private Long createUser;
    private LocalDateTime updateTime;
    private Long updateUser;
    private Long superior;
    private String account;
    private String name;
    private Long orgId;
    private String orgName;
    private Long stationId;
    private String stationName;
    private String email;
    private String mobile;
    private Sex sex;
    private boolean status;
    private String avatar;
    private LocalDateTime lastLoginTime;
    private List<Long> roles;
}
