package com.example.springboot01.controller;

import com.example.springboot01.utils.response.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    private static final Logger log = LoggerFactory.getLogger(ExceptionController.class);

    @GetMapping("/test")
    public CommonResult test(@RequestParam String name,@RequestParam String age){
        log.info("name[{}]",name);
        log.info("age[{}]",age);
        return CommonResult.ok();
    }

}
