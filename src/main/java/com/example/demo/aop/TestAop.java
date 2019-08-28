package com.example.demo.aop;


import com.example.demo.annotioon.ChangeDS;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
public class TestAop {

    @Around("@annotation(Log)")
    public Object doBeforeAdvice(ProceedingJoinPoint joinPoint) throws Throwable{//  通过JoinPoint 获取通知的签名信息，如目标方法名，目标方法参数信息等
        System.out.println("方法执行前");
        Object[] obj=joinPoint.getArgs();//获取目标方法的参数信息
        Signature signature=joinPoint.getSignature(); //  用的最多，通知的签名
        System.out.println("代理的方法是 ： "+signature.getName()); //  打印 代理的是哪一个方法
        Object  object=joinPoint.proceed();
        System.out.println("方法执行后...........");
        return object;
    }








}
