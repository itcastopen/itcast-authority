package com.itheima.authority.vo;

import com.itheima.authority.entity.auth.UserGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 用户组查询对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "UserGroupSaveVO", description = "用户组查询对象")
public class UserGroupVO extends UserGroup {


    @ApiModelProperty(value = "成员")
    private List<Long> userIds;

    @ApiModelProperty(value = "成员名称")
    private List<String> userNames;

}
