package com.example.springboot01.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/thy")
public class ThymeleafApi {

    @GetMapping("/get404")
    public String get404(HttpServletRequest request){
//        ServletContext servletContext = request.getSession().getServletContext();

        return "index";
    }

    @GetMapping("/get500")
    public String get500(){
        int i = 1/0;
        return "index";
    }

}
