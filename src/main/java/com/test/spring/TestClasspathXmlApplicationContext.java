package com.test.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClasspathXmlApplicationContext {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		Dog dog = (Dog) ac.getBean("dog");
		ac.close();
		System.out.println(dog.getName());
		
	}

}
