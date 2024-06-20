package com.bean.BeanDemo;

import org.springframework.context.annotation.Bean;

public class HelloConfiguration {

	@Bean
	public String name()
	{
		return "Yogesh";
	}
	@Bean 
	public int age()
	{
		return 21;
	}
}
