package com.example.demo.aop;


import com.example.demo.annotioon.ChangeDS;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.lang.reflect.Method;

@Component
@Aspect
public class TestAop {

    private  Boolean isSelect=false;

    @Pointcut("execution(* com.example.demo.service.*.*(..))")
    public  void executeService(){
    }

    /*
     *  01 . 前置通知：方法调用前被调用
     */
    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint){//  通过JoinPoint 获取通知的签名信息，如目标方法名，目标方法参数信息等
        System.out.println("我是前置通知");
        Object[] obj=joinPoint.getArgs();//获取目标方法的参数信息
        joinPoint.getThis(); // AOP代理类信息
        joinPoint.getTarget(); // 代理的目标对象
        Signature signature=joinPoint.getSignature(); //  用的最多，通知的签名
        System.out.println("代理的方法是 ： "+signature.getName()); //  打印 代理的是哪一个方法
        // AOP 代理的名字
        System.out.println("AOP 代理的名字 ： "+signature.getDeclaringTypeName());
        try {
            Class<?> clazz=Class.forName((String)signature.getDeclaringTypeName());
            Method[] methods = clazz.getDeclaredMethods();
            for(Method method:methods){
               //没有考虑到相同名字的方法
                if(method.getName().equals(signature.getName())){
                    ChangeDS changeDS = method.getAnnotation(ChangeDS.class);
                    if(changeDS!=null&&changeDS.type().equals("select")){
                        System.out.println(changeDS.type());
                        this.isSelect=true;
                        System.out.println("执行切库操作");
                    }
                };

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        signature.getDeclaringType();//  AOP代理类的类（class）信息

    }

    /**
     * 02 . 后置最终通知（目标方法只要执行完了就会执行后置通知方法）
     */

    @After("executeService()")
    public void doAfterService(JoinPoint joinPoint){
        System.out.println("后置最终通知执行了！");
        if(this.isSelect){
            System.out.println("执行切回来的库");
            this.isSelect=false;
        }

    }

}
