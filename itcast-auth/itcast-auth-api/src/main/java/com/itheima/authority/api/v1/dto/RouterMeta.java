package com.itheima.authority.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Vue路由 Meta
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouterMeta implements Serializable {

    private static final long serialVersionUID = 5499925008927195914L;

    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "图标")
    private String icon = "";
    @ApiModelProperty(value = "面包屑")
    private Boolean breadcrumb = true;

}
