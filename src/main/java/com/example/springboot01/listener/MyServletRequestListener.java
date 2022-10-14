package com.example.springboot01.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

@Component
public class MyServletRequestListener implements ServletRequestListener {

    public static final Logger log = LoggerFactory.getLogger(MyServletRequestListener.class);

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest servletRequest = (HttpServletRequest) sre.getServletRequest();
        log.info("session Id为{}",servletRequest.getRequestedSessionId());
        log.info("request url为{}",servletRequest.getRequestURI());
        servletRequest.setAttribute("name","csg");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest servletRequest = (HttpServletRequest) sre.getServletRequest();
        log.info("requestUrl为{}销毁",servletRequest.getRequestURI());
    }
}
