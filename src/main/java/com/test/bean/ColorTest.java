package com.test.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ColorTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Color.class);
		String[] names = ac.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}

}
