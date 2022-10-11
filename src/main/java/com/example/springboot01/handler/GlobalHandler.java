package com.example.springboot01.handler;

import com.example.springboot01.utils.response.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 全局异常处理，统一返回json数据
 *
 * */

@ControllerAdvice
@ResponseBody
public class GlobalHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalHandler.class);

    /**
     * 请求参数预处理
     *
     * */
    @InitBinder
    public void processParam(WebDataBinder binder){
        /**
         * 创建一个字符串微调编辑器
         * 参数{boolean emptyAsNull}: 是否把空字符串("")视为 null
         * */
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);

        /*
         * 注册自定义编辑器
         * 接受两个参数{Class<?> requiredType, PropertyEditor propertyEditor}
         * requiredType：所需处理的类型
         * propertyEditor：属性编辑器，StringTrimmerEditor就是 propertyEditor的一个子类
         */
        binder.registerCustomEditor(String.class, trimmerEditor);

        //同上，这里就不再一步一步讲解了
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    /**
     * 拦截异常（缺少请求参数异常)
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

    /**
     * 拦截异常（缺少请求参数异常)
     * @param ex HttpMessageNotReadableException
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public CommonResult handleNullPointerException(
            NullPointerException ex) {
        log.error("空指针异常，{}", ex.getMessage());
        return CommonResult.error().setMsg("空指针异常！");
    }

    /**
     * 预设全局数据。。
     * 注意：添加在视图中
     * */
    @ModelAttribute
    public void presetParam(Model model){
        model.addAttribute("globalAttr","this is a global Attr!");
    }

}
