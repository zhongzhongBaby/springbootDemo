package com.example.demo;


import com.example.demo.aop.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class DemoApplicationTests {


    @Test
    @Log
    public  void main() {
  System.out.print("asd");
    }



}
