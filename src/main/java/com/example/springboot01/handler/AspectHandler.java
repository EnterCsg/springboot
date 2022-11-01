package com.example.springboot01.handler;

import com.example.springboot01.annotation.AopTest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class AspectHandler {

    private static final Logger log = LoggerFactory.getLogger(AspectHandler.class);

    @Pointcut("execution(* com.example.springboot01.api..*.*(..))")
    public void pointCut(){}

    @Pointcut(value = "execution(* com.example.springboot01.service.impl.*.*(..)) && @annotation(com.example.springboot01.annotation.AopTest)")
    public void pointCut2(){}

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

    @After("pointCut2()")
    public void annotationTest(JoinPoint joinPoint) throws NoSuchMethodException {
        Signature signature = joinPoint.getSignature();
        MethodSignature msg=(MethodSignature) signature;
        Object target = joinPoint.getTarget();
        //获取注解标注的方法
        Method method = target.getClass().getMethod(msg.getName(), msg.getParameterTypes());
        //通过方法获取注解
        AopTest annotation = method.getAnnotation(AopTest.class);
        //获取参数
        Object[] args = joinPoint.getArgs();

        int index = annotation.index();
        String id = String.valueOf(args[index]);
        System.out.println("通过aop获取的ip为："+id);
    }

}
