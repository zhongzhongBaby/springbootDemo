package com.example.demo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class UserTest {
    //@Test
    public void setAge() throws Exception {
        Class clazz = Class.forName("com.example.demo.User");
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

    @Test
    public void setAge2() throws Exception {
        File file = new File("G:" + File.separator + "file.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        InputStream inputStream = new FileInputStream(file);
        // 这里定义了数组的长度是1024个字节，如果文件超出这字节，就会溢出，结果就是读不到1024字节以后的东西
        byte[] bs = new byte[(int)file.length()];
        // 这里len获得的是文件中内容的长度
        int len = inputStream.read(bs);
        inputStream.close();
        System.out.println(new String(bs));
        User user=null;
        assert user!=null:"用户为空";

        InputStream inputStream2 = new FileInputStream(file);
        // 这里也有不同，可以根据文件的大小来声明byte数组的大小，确保能把文件读完
        byte[] bs2 = new byte[3];
        // read()方法每次只能读一个byte的内容
        inputStream2.read(bs2);
        inputStream2.close();
        System.out.println(new String(bs2));
        OutputStream outputStream = new FileOutputStream(file, true);
        String hha = "\nhello world !";
        outputStream.write(hha.getBytes());
        outputStream.close();

    }


}