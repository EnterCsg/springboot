package com.example.springboot01.api;

import com.example.springboot01.config.MicroServiceUrl;
import com.example.springboot01.domain.User;
import com.example.springboot01.utils.response.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/start")
public class StartApi {

    @Value("${url.orderUrl}")
    private String orderUrl;

    @Resource
    private MicroServiceUrl microServiceUrl;

    @GetMapping("/getUser")
    public CommonResult getUser(HttpServletRequest request){
        request.getSession();
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

    @GetMapping("/getUrl")
    public CommonResult getUrl(){
        return CommonResult.ok().setMsg("订单服务的地址："+orderUrl);
    }

    @GetMapping("/getUrlByAnnotation")
    public CommonResult getUrlByAnnotation(){
        return CommonResult.ok().setMsg("订单服务的地址："+microServiceUrl.getOrderUrl()+",用户服务的地址："+microServiceUrl.getUserUrl());
    }


    @GetMapping("/getPath/{sss}/{dfsdf}")
    public CommonResult getPathVariable(@PathVariable("sss") String path,@PathVariable("dfsdf") String ds){
        return CommonResult.ok().setMsg("入参1为："+path+",入参2为："+ds);
    }

    @GetMapping("/getPath")
    public CommonResult getPathParam(@RequestParam("id") String idd,@RequestParam("name") String namee){
        return CommonResult.ok().setMsg("RequestParam:"+idd +","+namee);
    }

    //form表单提交是键值对的数据格式，例如a=1&b=2的形式。mvc自动进行参数绑定
    @PostMapping("/getUsers1")
    public CommonResult getUser(User user){
        return CommonResult.ok().setResult(user);
    }

    //json提交是字符串的形式，需要@ResponseBody注解对json进行解析
    @PostMapping("/getUser2")
    public CommonResult getUser2(@RequestBody User user){
        return CommonResult.ok().setResult(user);
    }

    @GetMapping("/handler")
    public CommonResult getHandler(ModelMap map){
        String globalAttr = (String) map.getAttribute("globalAttr");
        return CommonResult.ok().setMsg(globalAttr);
    }

    @GetMapping("/nullPoint")
    public CommonResult getPoint(){
        User user = null;
        return CommonResult.ok().setResult(user.age);
    }

}
