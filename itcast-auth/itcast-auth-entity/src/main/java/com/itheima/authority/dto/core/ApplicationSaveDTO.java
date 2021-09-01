package com.itheima.authority.dto.core;

import com.itheima.authority.entity.core.Application;
import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 实体类
 * 应用新增
 * </p>
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@ApiModel(value = "ApplicationSaveDTO", description = "应用新增")
public class ApplicationSaveDTO extends Application {


}
