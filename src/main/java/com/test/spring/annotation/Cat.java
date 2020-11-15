package com.test.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Cat {
	
	@Autowired
	private Dog dog;
	
	@Transactional
	public void testDog() {
	}

}
