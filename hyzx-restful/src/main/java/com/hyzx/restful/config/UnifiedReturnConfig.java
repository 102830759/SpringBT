package com.hyzx.restful.config;

import com.alibaba.fastjson.JSON;
import com.hyzx.restful.api.R;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * RESTful api 返回结果统一处理包装
 *
 * @author huyue
 * @date 2019/8/28 17:09
 */
@EnableWebMvc
@Configuration
public class UnifiedReturnConfig {


    /**
     * RestController 文件所在位置
     */
    @RestControllerAdvice("com.hyzx.restful.controller")
    static class CommonResultResponseAdvice implements ResponseBodyAdvice<Object> {
        @Override
        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

            if (body instanceof String) {
                String msg = (String) body;

                // 因为在controller层中返回的是String类型，这边如果换成R的话，会导致StringMessageConverter方法类型转换异常，所以这边将对象转成字符串
                return JSON.toJSONString(R.ok().put("data", msg));
            } else if (body instanceof R) {
                return body;
            } else {
                return R.ok().put("data", body);
            }
        }
    }

}
