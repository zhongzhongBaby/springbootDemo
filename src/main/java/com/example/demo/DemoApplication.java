package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan
@SpringBootApplication
public class DemoApplication {
	private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		logger.error("demo project are  running +++++++++++++++++++++++++");
		SpringApplication.run(DemoApplication.class, args);
	}
}
