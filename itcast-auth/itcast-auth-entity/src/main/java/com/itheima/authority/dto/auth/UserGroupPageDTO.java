package com.itheima.authority.dto.auth;

import com.itheima.authority.entity.auth.UserGroup;
import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * 用户组分页DTO
 *
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UserGroupPageDTO", description = "用户组分页对象")
public class UserGroupPageDTO extends UserGroup {

}
