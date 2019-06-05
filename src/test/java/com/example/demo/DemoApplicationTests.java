package com.example.demo;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes={DemoApplication.class})
public class DemoApplicationTests {
	@Test
	public void testOne()  throws  Exception{
	System.out.println("11111111");
	}

	@Test
	public void testTwo()  throws  Exception{
		System.out.println("22222222");
	}
}
