package com.test.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {

	@Test
	public void test() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(StudentConfig.class);
		Student student = ac.getBean(Student.class);
		student.afterClass();

	}

}
