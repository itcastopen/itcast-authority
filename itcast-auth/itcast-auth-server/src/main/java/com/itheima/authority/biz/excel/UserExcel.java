package com.itheima.authority.biz.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

@Data
public class UserExcel {
    @Excel(name = "账号", orderNum = "1")
    private String account;

    @Excel(name = "姓名", orderNum = "2")
    private String name;

    @Excel(name = "手机号", orderNum = "3")
    private String mobile;

    @Excel(name = "组织", orderNum = "4")
    private String orgName;

    @Excel(name = "岗位", orderNum = "5")
    private String stationName;

    @Excel(name = "角色", orderNum = "6")
    private String roleNames;

    @Excel(name = "性别", orderNum = "7")
    private String sex;

    @Excel(name = "状态", orderNum = "8")
    private String status;

}
