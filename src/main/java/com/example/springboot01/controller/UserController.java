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

}
