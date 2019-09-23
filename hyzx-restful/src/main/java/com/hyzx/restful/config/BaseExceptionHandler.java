package com.hyzx.restful.config;

import com.hyzx.restful.api.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;

/**
 * 异常处理器
 *
 * @author huyue
 * @date 2016年10月27日 下午10:16:19
 */
@RestControllerAdvice
public class BaseExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 参数校验异常
     *
     * @param e
     * @return com.hyzx.restful.api.R
     * @author huy
     * @date 15:20 2019/9/23
     */
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public R methodArgumentNotValidException(MethodArgumentNotValidException e) {

        List<FieldError> fieldErrorList = e.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrorList) {
            logger.error(fieldError.getDefaultMessage());
        }
        return R.error(HttpStatus.BAD_REQUEST.value(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }


    @ExceptionHandler(Exception.class)
    public R exception(Exception e) {
        logger.error(e.getMessage(), e);
        return R.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "请联系管理员");
    }

}
