package com.itheima.authority.dto.core;

import com.itheima.tools.model.ITreeNode;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 组织树
 */
@ToString(callSuper = true)
@Data
@ApiModel(value = "OrgUserTreeDTO", description = "组织用户树")
@Builder
public class OrgUserTreeDTO implements ITreeNode<OrgUserTreeDTO, Long> {
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
