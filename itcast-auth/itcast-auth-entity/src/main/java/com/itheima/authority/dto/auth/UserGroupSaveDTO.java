package com.itheima.authority.dto.auth;

import com.itheima.authority.entity.auth.UserGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

/**
 * 用户组保存DTO
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UserGroupSaveDTO", description = "用户组保存对象")
public class UserGroupSaveDTO extends UserGroup {


    @ApiModelProperty(value = "成员")
    @NotEmpty(message = "成员不能为空")
    private Set<Long> userIds;

}
