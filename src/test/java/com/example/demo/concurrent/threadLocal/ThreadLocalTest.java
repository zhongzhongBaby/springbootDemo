package com.example.demo.concurrent.threadLocal;

import com.example.demo.concurrent.threadLocal.DateUtilsNotSafe;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 20, 0l, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1024), threadFactory);
        DateUtilsNotSafe dateUtilsNotSafe = new DateUtilsNotSafe();
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(dateUtilsNotSafe.parse("2020-01-01 10:01:01"));
            });
        }
    }


}
