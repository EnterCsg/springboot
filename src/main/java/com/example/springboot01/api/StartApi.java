package com.example.springboot01.api;

import com.example.springboot01.domain.User;
import com.example.springboot01.utils.response.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/start")
public class StartApi {

    @GetMapping("/getUser")
    public CommonResult getUser(){
        User user = new User();
        user.setAge(12);
        user.setName("张三");
        return CommonResult.ok().setResult(user);
    }

    @GetMapping("/getList")
    public CommonResult getList(){
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setAge(12);
        user1.setName(null);

        User user2 = new User();
        user2.setAge(13);
        user2.setName("李四");
        list.add(user1);
        list.add(user2);
        return CommonResult.ok().setResult(list);
    }

    @GetMapping("/getError")
    public CommonResult getError(){
        return CommonResult.error().setMsg("失败！");
    }
}
