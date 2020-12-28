package com.zg.sell.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
//    使用AOP统一处理请求日志
//    aop是一种编程范式，与语言无关，是一种程序设计思想。面向切面（AOP） 面向对象（OOP)  面向过程（POP)
//
//    AOP：面向过程到面向对象。换个角度看世界。将通用逻辑从业务逻辑中分离出来。
//
//    AOP 统一处理请求日志：记录每一个http请求：
//
//    示例：授权访问通过aop实现。
//    添加依赖：
//
//    添加HttpAspect类，定义before。后面。*.. 表示适用于任何方法，且任意参数。//
//
//    @Before("execution(public * com.zg.sell.controller.EmployeeController.*(..))")
//    public void log(){
//        System.out.println("log aspect");
//    }
//
//    @After("execution(public * com.zg.sell.controller.EmployeeController.*(..))")
//    public void doAfter(){
//        System.out.println("22222222");
//    }

    //优化：改进记录日志输出：
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.zg.sell.controller.EmployeeController.*(..))")
    public void log(){

    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("111111111");
        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        logger.info("url={}",request.getRequestURI());
        logger.info("method={}",request.getMethod());
        logger.info("id={}",request.getRemoteAddr());
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("222222222");
    }

    //扩展：获取返回内容（json串）
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        //异常处理：问题：当添加时，如果没有对某个字段未赋值，则会 返回null，导致后面tostring时，报空引用问题。

        logger.info("return={}",object.toString());
    }
}
