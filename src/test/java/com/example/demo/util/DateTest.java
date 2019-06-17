package com.example.demo.util;

import org.junit.Test;

import java.util.Date;

public class DateTest {
    @Test
    public void mytest() throws Exception {
        long startTime= new Date().getTime();
        Thread.sleep(1000);
        long endTime= new Date().getTime();
        System.out.print((endTime-startTime)/1000);
    }

}
