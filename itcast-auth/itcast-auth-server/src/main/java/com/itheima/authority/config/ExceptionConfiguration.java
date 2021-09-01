package com.itheima.authority.config;

import com.itheima.tools.base.R;
import com.itheima.tools.common.handler.DefaultGlobalExceptionHandler;
import com.itheima.tools.exception.code.ExceptionCode;
import com.itheima.tools.utils.StrPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@Configuration
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class ExceptionConfiguration extends DefaultGlobalExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    public R<String> duplicateKeyException(DuplicateKeyException ex, HttpServletRequest request) {
        log.warn("DuplicateKeyException", ex);
        try {
            String[] exMessage = ex.getMessage().split("###");
            String message = exMessage[1].split("Duplicate entry '")[1].split("' for key")[0];
            message = message.split("-")[0]; // 联合唯一索引取第一个字段
            return R.result(ExceptionCode.ILLEGALA_ARGUMENT_EX.getCode(), StrPool.EMPTY, message + " 已存在!").setPath(request.getRequestURI());
        } catch (Exception e) {
            return R.result(ExceptionCode.SQL_EX.getCode(), StrPool.EMPTY, ExceptionCode.SQL_EX.getMsg()).setPath(request.getRequestURI());
        }
    }
}
