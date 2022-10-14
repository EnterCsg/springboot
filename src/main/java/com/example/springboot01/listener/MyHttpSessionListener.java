package com.example.springboot01.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class MyHttpSessionListener implements HttpSessionListener {

    private static final Logger log = LoggerFactory.getLogger(MyHttpSessionListener.class);

    public Integer count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("增加新用户");
        count++;
        se.getSession().setMaxInactiveInterval(3);//服务器并不知道浏览器是否关闭。在此设置3秒不刷新，自动调用sessionDestroyed
        se.getSession().getServletContext().setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("退出用户");
        count--;
        se.getSession().getServletContext().setAttribute("count",count);
    }
}
