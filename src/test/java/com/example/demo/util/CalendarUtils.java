package com.example.demo.util;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtils {
    @Test
    public void test() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), 1, 00, 00, 00);
        //打印本月起始日的年月日时分秒格式
        System.out.println("这个月的第一天是： " + sdf.format(cal.getTime()));
        cal.add(Calendar.MONTH, -8);
        System.out.println("上个月的第一天是： " + sdf.format(cal.getTime()));
    }


}
