package com.test.cligb;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class AdviceInterceptor implements MethodInterceptor {
	public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws java.lang.Throwable {
		System.out.println("执行目标方法之前，模拟开始事务 ...");
		// 执行目标方法，并保存目标方法执行后的返回值
		Object rvt = proxy.invokeSuper(target, new String[] { "被改变的参数" });
		System.out.println("执行目标方法之后，模拟结束事务 ...");
		return rvt + " 新增的内容";
	}
}
