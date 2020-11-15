package com.test.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Animal {
	
	public Dog dog;
	
	public Animal(@Autowired Dog dog) {
		this.dog = dog; 
	}
	
	public Animal() {
		
	}

}
