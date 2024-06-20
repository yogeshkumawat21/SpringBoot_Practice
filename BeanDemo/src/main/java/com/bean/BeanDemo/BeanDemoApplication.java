package com.bean.BeanDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanDemoApplication {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(HelloConfiguration.class);
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
	}

}
