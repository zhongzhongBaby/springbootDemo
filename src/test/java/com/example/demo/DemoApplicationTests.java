package com.example.demo;


import com.example.demo.aop.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class DemoApplicationTests {
    @Test
    @Log
    public  void main() {
          System.out.print("asd");
    }

}
