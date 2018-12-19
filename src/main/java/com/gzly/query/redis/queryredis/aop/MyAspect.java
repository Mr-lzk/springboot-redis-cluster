package com.gzly.query.redis.queryredis.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lzk
 * @date 2018/8/28
 */

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.gzly.query.redis.queryredis.controller.TestController.aspect(..))")
    public void mycut() {}

    @AfterReturning("mycut()")
    public void afterReturning(JoinPoint joinPoint) {

        System.out.println("joinPoint.getArgs():" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("joinPoint.getSignature():" + joinPoint.getSignature());
        System.out.println("joinPoint.getTarget()" + joinPoint.getTarget());

        System.out.println("=======|||||||aspect detective 。。。after returning");
    }

}
