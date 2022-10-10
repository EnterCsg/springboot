package com.example.springboot01.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/log")
public class LogApi {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/getLog")
    public String getLog(){
        log.error("测试error");
        log.warn("测试warn");
        log.info("测试info");
        log.debug("测试debug");

        String str1 = "csg";
        String str2 = "address";
        log.info("测试占位符1[{}],占位符2[{}]",str1,str2);

        return "success";
    }
}
