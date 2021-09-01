package com.itheima.authority.biz.service.auth;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;


/**
 * 验证码
 *
 */
public interface ValidateCodeService {

    void create(String key, HttpServletResponse response) throws IOException;

    boolean check(String key, String value);
}
