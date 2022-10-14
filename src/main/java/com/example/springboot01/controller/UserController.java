package com.example.springboot01.controller;

import com.example.springboot01.domain.User;
import com.example.springboot01.service.UserService;
import com.example.springboot01.utils.response.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public CommonResult getUserById(@PathVariable("id") Long id){
        User user = userService.selectUserById(id);
        return CommonResult.ok().setResult(user);
    }

    @GetMapping("/2/{id}")
    @ResponseBody
    public CommonResult getUserById2(@PathVariable("id") Long id){
        User user = userService.selectUserById2(id);
        return CommonResult.ok().setResult(user);
    }

    @GetMapping("/applicationListener")
    @ResponseBody
    public CommonResult getUserListener(HttpServletRequest req){
        ServletContext servletContext = req.getServletContext();
        User user =  (User)servletContext.getAttribute("user");
        return CommonResult.ok().setResult(user);
    }

    @GetMapping("/total")
    @ResponseBody
    public CommonResult getUserCount(HttpServletRequest req, HttpServletResponse res){
        Cookie cookie;
        try {
            //将sessionid记录在浏览器中
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(req.getSession().getId(), "utf-8"));
            cookie.setPath("/");
            cookie.setMaxAge(2*24*60*60);//
            res.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        ServletContext servletContext = req.getSession().getServletContext();
        Integer count = (Integer) servletContext.getAttribute("count");
        return CommonResult.ok().setResult("当前在线人数"+count);
    }

}
