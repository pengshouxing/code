package com.test.cligb;

import org.springframework.cglib.proxy.Enhancer;

public class DogProxyFactory {
	public static Dog getAuthInstance() {
		Enhancer en = new Enhancer();
		// 设置要代理的目标类
		en.setSuperclass(Dog.class);
		// 设置要代理的拦截器
		en.setCallback(new AdviceInterceptor());
		// 生成代理类的实例
		return (Dog) en.create();
	}
}