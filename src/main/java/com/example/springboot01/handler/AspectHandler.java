package com.example.springboot01.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectHandler {

    private static final Logger log = LoggerFactory.getLogger(AspectHandler.class);

    @Pointcut("execution(* com.example.springboot01.api..*.*(..))")
    public void pointCut(){}

    @After("pointCut()")
    public void printLogAfter(){
        log.info("after执行了");
    }

    @Before("pointCut()")
    public void printLogBefor(){
        log.info("before执行了");
    }

//    @Around("pointCut()")
//    public void printLogAround(){
//        log.info("around执行了");
//    }

    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void printLogReturn(JoinPoint point,Object result){
        Signature signature = point.getSignature();
        String name = signature.getName();
        log.info("方法名[{}]",name);
        log.info("返回结果,"+result);
    }

    @Around("execution(* com.example.springboot01.api.LogApi.getLog())")
    public Object pointCut2(ProceedingJoinPoint point) throws Throwable {
        log.info("进入around");
        Object proceed = point.proceed();
        log.info("结束around");
        return proceed+"123";
    }

}
