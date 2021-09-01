package com.itheima.authority.dto.core;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.itheima.tools.base.entity.SuperEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * <p>
 * 实体类
 * 组织
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "OrgUpdateDTO", description = "组织")
public class OrgUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @NotNull(message = "id不能为空", groups = SuperEntity.Update.class)
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @Length(max = 255, message = "名称长度不能超过255")
    private String name;
    /**
     * 简称
     */
    @ApiModelProperty(value = "简称")
    @Length(max = 255, message = "简称长度不能超过255")
    private String abbreviation;
    /**
     * 父ID
     */
    @ApiModelProperty(value = "父ID")
    private Long parentId;

    /**
     * 部门类型 1为分公司，2为一级转运中心 3为二级转运中心 4为网点
     */
    @ApiModelProperty(value = "部门类型 1为分公司，2为一级转运中心 3为二级转运中心 4为网点")
    private Integer orgType;

    @ApiModelProperty(value = "所属省份id")
    private Long provinceId;

    @ApiModelProperty(value = "所属城市id")
    private Long cityId;

    @ApiModelProperty(value = "所属区县id")
    private Long countyId;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    @Length(max = 255, message = "详细地址长度不能超过255")
    private String address;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    @Length(max = 255, message = "经度长度不能超过255")
    private String longitude;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    @Length(max = 255, message = "纬度长度不能超过255")
    private String latitude;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    @Length(max = 255, message = "联系电话长度不能超过255")
    private String contractNumber;

    /**
     * 负责人id
     */
    @ApiModelProperty(value = "负责人id")
    private Long managerId;

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
    @Length(max = 255, message = "描述长度不能超过255")
    private String describe;

}
