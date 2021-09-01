package com.itheima.authority.api.v1.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 组织树
 */
@Data
@ApiModel(value = "OrgUserTreeDTO", description = "组织用户树")
public class OrgUserTreeDTO {
    private List<OrgUserTreeDTO> children;
    private String label;
    private Long id;
    private Long parentId;
    private Boolean status;
    private Integer type;

    public Boolean getEnable() {
        if (type == 1 && CollectionUtils.isEmpty(children)) {
            return false;
        }
        return true;
    }
}
