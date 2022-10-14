package com.example.springboot01.listener;

import com.example.springboot01.domain.User;
import com.example.springboot01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Component
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    public HttpServletRequest httpServletRequest;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        UserService userService = applicationContext.getBean(UserService.class);
        User user = userService.selectUserById(1L);
        ServletContext application = applicationContext.getBean(ServletContext.class);
        application.setAttribute("user",user);
    }
}
