package com.test.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.test.bean")
public class Color {
	
	@Bean
	public Red red() {
		 Red red = new Red();
		 return red;
	}

}
