/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: LogAsepct
 * Author:   莉莉
 * Date:     2020/6/14 10:30
 * Description: 编写切面
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.common.AspectUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
/**
 * Spring提供了两种方式来生成代理对象: JDKProxy和Cglib
 */
/**
 * 類加載器是Classloader
 */
/**
 * 编写切面的说明
 * 1.首先定义切面的注解类
 * 2.编写切面类
 *   2.1 类的注解添加@aspect和@compoment注解，作用是定义这个类是一个切面类并且这个类交给spring容器的bean
 *   2.2 通过@PointCut注解声明切点：可以定义切入的类，也可以定义注解
 *   2.3 编写切入的操作
 */

/**
 * 〈编写切面〉
 *
 * @author 莉莉
 * @create 2020/6/14
 * @since 1.0.0
 */
@Aspect//注解声明这是一个切面
@Component//注解声明该类交给spring容器管理的bean
public class LogAsepct {

    @Pointcut("@annotation(com.legouu.common.AspectUtils.Action)")
    public void annotationPointCut(){}

    @Pointcut("bean(demoMethodService)")
    public void aroundPointCut(){}

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截"+action.name());
    }

    /**
     * execution
     * @param joinPoint
     */
    @Before("execution(* com.legouu.common.AspectUtils.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法拦截式拦截："+method.getName());
    }

    /**
     * 环绕通知
     */
    @Around("aroundPointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Exception{
        try {
            System.out.println("start+"+System.currentTimeMillis());
            proceedingJoinPoint.proceed();
            System.out.println("end+"+System.currentTimeMillis());
        }
         catch (Throwable throwable) {


        }

    }
}