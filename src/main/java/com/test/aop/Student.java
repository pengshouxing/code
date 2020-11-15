package com.test.aop;

import org.springframework.stereotype.Component;

@Component
public class Student {
	
	public void afterClass() {
		System.out.println("学生下课。。。");
	}
	
}
