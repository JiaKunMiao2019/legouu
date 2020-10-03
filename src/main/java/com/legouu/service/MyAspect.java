/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Aspect
 * Author:   莉莉
 * Date:     2020/5/4 17:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.legouu.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 〈AOP编程〉
 *
 * @author 莉莉
 * @create 2020/5/4
 * @since 1.0.0
 */
public class MyAspect {
    @Pointcut("execution(* com.legouu.service.*.*(..))")
    public void myPointCut(){}
    //前置通知
    @Before("myPointCut")
    public void myBefore(JoinPoint joinpoint){
        System.out.println("前置通知：模拟执行权限检查...");
        System.out.println("目标类是："+joinpoint.getTarget());
        System.out.println("，被植入增强处理的目标方法是："+joinpoint.getSignature().getName());
    }

    //后置通知
    @AfterReturning("myPointCut")
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.println("后置通知：模拟记录日志。。。");
        System.out.println(",模拟处理日志的目标方法:"+joinPoint.getSignature().getName());
    }

    //环绕通知
    /**
     * ProceedingJoinPoint是JoinPoint的子接口，表示可执行目标方法
     * 1.必须Object类型的返回值
     * 2.必须接收一个参数
     * 3.必须是throws Throwable
     */
    @Around("myPointCut")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        System.out.println("环绕开始，执行目标方法之前，模拟开启事务。。。");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕结束：执行目标方法之后模拟关闭事务。。。");
        return  proceed;
    }

    //异常通知
    @AfterThrowing("myPointCut")
    public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
        System.out.println("异常通知：出错了！"+e.getMessage());
    }

    //最终通知
    @After("myPointCut")
    public void myAfter(JoinPoint joinPoint){
        System.out.println("最终通知:模拟方法结束后释放资源");
    }
}