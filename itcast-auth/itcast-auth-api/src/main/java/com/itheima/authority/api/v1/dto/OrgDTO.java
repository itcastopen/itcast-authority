package com.itheima.authority.api.v1.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * <p>
 * 实体类
 * 组织
 * </p>
 */
@Data
@ApiModel(value = "Org", description = "组织")
public class OrgDTO implements Serializable {

    @ApiModelProperty(value = "ID")
    private Long id;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 简称
     */
    @ApiModelProperty(value = "简称")
    private String abbreviation;

    /**
     * 父级ID
     */
    @ApiModelProperty(value = "父级ID")
    private Long parentId;

    /**
     * 父级名称¬
     */
    @ApiModelProperty(value = "父级名称")
    private String parentName;

    /**
     * 部门类型 1为分公司，2为一级转运中心 3为二级转运中心 4为网点
     */
    @ApiModelProperty(value = "部门类型 1为分公司，2为一级转运中心 3为二级转运中心 4为网点")
    private Integer orgType;

    /**
     * 所属省份id
     */
    @ApiModelProperty(value = "所属省份id")
    private Long provinceId;

    /**
     * 所属省份名称
     */
    @ApiModelProperty(value = "所属省份名称")
    private String provinceName;

    /**
     * 所属城市id
     */
    @ApiModelProperty(value = "所属城市id")
    private Long cityId;

    /**
     * 所属城市名称
     */
    @ApiModelProperty(value = "所属城市名称")
    private String cityName;

    /**
     * 所属区县id
     */
    @ApiModelProperty(value = "所属区县id")
    private Long countyId;

    /**
     * 所属区县名称
     */
    @ApiModelProperty(value = "所属区县名称")
    private String countyName;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String contractNumber;

    /**
     * 负责人id
     */
    @ApiModelProperty(value = "负责人id")
    private Long managerId;

    /**
     * 负责人名称
     */
    @ApiModelProperty(value = "负责人名称")
    private String manager;


    /**
     * 树结构
     */
    @ApiModelProperty(value = "树结构")
    @Length(max = 255, message = "树结构长度不能超过255")
    private String treePath;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sortValue;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Boolean status;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String describe;

}
