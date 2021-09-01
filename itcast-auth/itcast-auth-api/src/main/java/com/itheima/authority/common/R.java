package com.itheima.authority.common;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Collection;


/**
 *
 */
@Data
public class R<T> {

    @ApiModelProperty(value = "响应编码:0/200-请求处理成功")
    private int code;

    @ApiModelProperty(value = "响应数据")
    private T data;

    @ApiModelProperty(value = "消息")
    private String msg;

    public static R timeout() {
        R r = new R();
        r.setCode(-1);
        r.setMsg("超时");
        return r;
    }

    /**
     * 逻辑处理是否成功
     *
     * @return 是否成功
     */
    public Boolean getIsSuccess() {
        return this.code == 0 || this.code == 200;
    }

    public Boolean hasObjectData() {
        return this.data != null;
    }

    public Boolean hasArrayData() {
        return !CollectionUtils.isEmpty((Collection<?>) this.data);
    }
}
