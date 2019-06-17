package com.example.demo;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


public class UserTest {
    @Test
    public void setAge() throws Exception {
        Class clazz = Class.forName("com.example.demo.entity.User");
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("setAge", int.class);
        int val = 6;
        //获取指定名称的注解
        Annotation annotation = method.getAnnotation(AfterOpe.class);
        if (annotation != null) {
            if (annotation instanceof AfterOpe) {
                AfterOpe afterOpe = (AfterOpe) annotation;
                System.out.println("谁谁谁" + afterOpe.value() + "为  操作类型:" + afterOpe.operatorType());
            }
        }
        method.invoke(obj, 20);
        System.out.println(obj);
    }




}