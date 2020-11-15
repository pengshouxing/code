package com.test.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Red {

	public Red() {
		System.out.println("red在实例化");
	}
	
	@Bean
	public Blue blue() {
		System.out.println("blue在实例化");
		return new Blue();
	}
}
