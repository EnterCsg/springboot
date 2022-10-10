package com.example.springboot01.utils.response;

import java.util.HashMap;

public class CommonResult extends HashMap<String,Object> {


    public static final String CODE_NAME = "code";

    public static final String CODE_MSG = "msg";

    public static final String CODE_DATA = "data";

    public static final int SUCCESS_CODE = 200;

    public static final int ERROR_CODE = 500;

    public static final int WARN_CODE = 501;

    public static final String DEFAULT_MSG = "操作成功";

    public static CommonResult ok(){
        return createResultOk();
    }

    public static CommonResult error(){
        return createResultError();
    }

    private static CommonResult createResultOk() {
        CommonResult result = new CommonResult();
        result.put(CODE_NAME,SUCCESS_CODE);
        result.put(CODE_MSG,DEFAULT_MSG);
        return result;
    }

    private static CommonResult createResultError() {
        CommonResult result = new CommonResult();
        result.put(CODE_NAME,WARN_CODE);
        return result;
    }

    public CommonResult setResult(Object data){
        this.put(CODE_DATA,data);
        return this;
    }

    public CommonResult setMsg(String msg){
        this.put(CODE_MSG,msg);
        return this;
    }

}
