package com.test.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dog {
	
	private Animal animal;
	
	public Dog(@Autowired Animal animal) {
		this.animal = animal;
	}
	
	public Dog() {
		
	}

}
