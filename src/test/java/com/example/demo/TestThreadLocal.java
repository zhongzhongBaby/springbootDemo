package com.example.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestThreadLocal  implements  Runnable{
    ThreadLocal studentLocal = new ThreadLocal();

        @Test
    public void test() {
        TestThreadLocal t = new TestThreadLocal();
        Runtime runtime=Runtime.getRuntime();
        new Thread(t, "t1").start();
        new Thread(t, "t2").start();
        System.out.println("Java虚拟机中的空闲内存量:"+runtime.freeMemory());
        System.out.println("Java 虚拟机试图使用的最大内存量:"+ runtime.maxMemory());
        System.out.println("返回 Java 虚拟机中的内存总量:"+ runtime.totalMemory());
    }
    @Override
    public void run() {
        accessStudent();
    }
    private void accessStudent() {
        Student s = this.getStudent();
        System.out.println(s.toString());
        int age =(int)(Math.random()*100);
        System.out.println("current thread set age " + Thread.currentThread()
                + ":" + age);
        s.setAge(age);
        System.out.println("current thread first get age "
                + Thread.currentThread() + ":" + s.getAge());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("current thread second get age "
                + Thread.currentThread() + ":" + s.getAge());
    }

    public Student getStudent() {
        Student s = (Student) studentLocal.get();
        if (s == null) {
            s = new Student();
            studentLocal.set(s);
        }
        return s;
    }
}
