package com.example.demo;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CommonTest {
    @Test
    public void mytest() throws Exception {
        List<String> a=new ArrayList<>();
        a.add("b");
        a.add("asdasd");
        a.add("asdasd");
        a.add("asdasd");
        int i=0;
        a.forEach(c->{
            if(c.equals("b")){
                return;
            }
        });


    }


}
