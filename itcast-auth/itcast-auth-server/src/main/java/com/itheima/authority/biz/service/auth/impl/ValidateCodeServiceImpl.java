package com.itheima.authority.biz.service.auth.impl;

import com.itheima.authority.biz.service.auth.ValidateCodeService;
import com.itheima.tools.common.constant.CacheKey;
import com.itheima.tools.exception.BizException;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.extern.slf4j.Slf4j;
import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码服务
 */
@Service
@Slf4j
public class ValidateCodeServiceImpl implements ValidateCodeService {

    @Autowired
    private CacheChannel cache;


    /**
     * 生成验证码
     * @param key      验证码 uuid
     * @param response HttpServletResponse
     * @throws IOException
     */
    @Override
    public void create(String key, HttpServletResponse response) throws IOException {
        if (StringUtils.isBlank(key)) {
            throw BizException.validFail("验证码key不能为空");
        }

        setHeader(response, "png");

        Captcha captcha = createCaptcha("png");
        log.info("cache {} :{}", captcha.text(), cache);
        cache.set(CacheKey.CAPTCHA, key, StringUtils.lowerCase(captcha.text()));
        captcha.out(response.getOutputStream());
    }

    /**
     * 校验验证码
     * @param key   前端上送 key
     * @param value 前端上送待校验值
     * @return
     */
    @Override
    public boolean check(String key, String value) {
        if (StringUtils.isBlank(value)) {
            throw BizException.validFail("请输入验证码");
        }
        CacheObject cacheObject = cache.get(CacheKey.CAPTCHA, key);
        if (cacheObject.getValue() == null) {
            throw BizException.validFail("验证码已过期");
        }
        if (!StringUtils.equalsIgnoreCase(value, String.valueOf(cacheObject.getValue()))) {
            throw BizException.validFail("验证码不正确");
        }
        cache.evict(CacheKey.CAPTCHA, key);
        return true;
    }

    /**
     * 根据类型创建验证码
     * @param type
     * @return
     */
    private Captcha createCaptcha(String type) {
        Captcha captcha = null;
        if (StringUtils.equalsIgnoreCase(type, "gif")) {
            captcha = new GifCaptcha(115, 42, 4);
        } else if (StringUtils.equalsIgnoreCase(type, "png")) {
            captcha = new SpecCaptcha(115, 42, 4);
        } else if (StringUtils.equalsIgnoreCase(type, "arithmetic")) {
            captcha = new ArithmeticCaptcha(115, 42);
        } else if (StringUtils.equalsIgnoreCase(type, "chinese")) {
            captcha = new ChineseCaptcha(115, 42);
        }
        captcha.setCharType(2);
        return captcha;
    }

    /**
     * 设置返回头信息
     * @param response
     * @param type
     */
    private void setHeader(HttpServletResponse response, String type) {
        if (StringUtils.equalsIgnoreCase(type, "gif")) {
            response.setContentType(MediaType.IMAGE_GIF_VALUE);
        } else {
            response.setContentType(MediaType.IMAGE_PNG_VALUE);
        }
        response.setHeader(HttpHeaders.PRAGMA, "No-cache");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "No-cache");
        response.setDateHeader(HttpHeaders.EXPIRES, 0L);
    }
}
