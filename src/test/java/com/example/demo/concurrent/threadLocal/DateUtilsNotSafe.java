package com.example.demo.concurrent.threadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilsNotSafe {

    public  ThreadLocal<SimpleDateFormat> threadLocal =ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    public   Date parse(String dateStr) {
        try {
            Date date = threadLocal.get().parse(dateStr);
            return date;
        } catch (ParseException e) {
        e.printStackTrace();
    }
        return null;
    }
}
