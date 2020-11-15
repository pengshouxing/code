package com.test.tx;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxTest {
	
	@Test
	public void test() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TxConfig.class);
		TxService txService = ac.getBean(TxService.class);
		System.out.println("txService:"+txService);
		txService.insertSchool();
		
	}
}
