package com.itheima.authority.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImportResultVO {
    private Integer total;
    private Integer success;
    private Integer fail;
    private Collection<String> message;
}
