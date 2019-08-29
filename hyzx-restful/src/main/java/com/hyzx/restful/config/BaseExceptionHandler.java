package com.hyzx.restful.config;

import com.hyzx.restful.api.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @author huyue
 * @date 2016年10月27日 下午10:16:19
 */
@RestControllerAdvice
public class BaseExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    public R exception(Exception e) {
        logger.error(e.getMessage(), e);
        return R.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "请联系管理员");
    }

}
