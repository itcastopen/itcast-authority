package com.itheima;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
/**
 * 测试DTO
 *
 */
public class D {
    private LocalDateTime date;
    private Date d2;
}
