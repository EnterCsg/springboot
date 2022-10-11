package com.example.springboot01.exception;

import com.example.springboot01.utils.response.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常处理，统一返回json数据
 *
 * */

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 缺少请求参数异常
     * @param ex HttpMessageNotReadableException
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public CommonResult handleHttpMessageNotReadableException(
            MissingServletRequestParameterException ex) {
        log.error("缺少请求参数，{}", ex.getMessage());
        return CommonResult.error().setMsg("缺少必要的请求参数");
    }


}
