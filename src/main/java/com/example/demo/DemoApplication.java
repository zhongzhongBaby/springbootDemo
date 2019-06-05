package com.example.demo;


import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@ServletComponentScan
@SpringBootApplication
public class DemoApplication {
	private static Logger logger = Logger.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		logger.error("demo project are  running +++++++++++++++++++++++++");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("ReadTest, Please Enter Data:");
		InputStreamReader is = new InputStreamReader(System.in);  //new构造InputStreamReader对象
		BufferedReader br = new BufferedReader(is);  //拿构造的方法传到BufferedReader中
		try{  //该方法中有个IOExcepiton需要捕获
			String name = br.readLine();
			System.out.println("ReadTest Output:" + name);
		}
		catch(IOException e){
			e.printStackTrace();
		}


	}
}
