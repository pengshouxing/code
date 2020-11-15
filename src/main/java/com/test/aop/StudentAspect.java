package com.test.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAspect {
	
	@Pointcut("execution(public void com.test.aop.Student.afterClass(..))")
	private void studentPoint() {}
	
	@Before("studentPoint()")
	public void finishWork() {
		System.out.println("下课之前需要先完成作业");
	}
	
	@After("studentPoint()")
	public void play() {
		System.out.println("作业完成了可以好好玩");
	}

}
