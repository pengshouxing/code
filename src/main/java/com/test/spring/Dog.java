package com.test.spring;

import java.util.List;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Dog implements InitializingBean,BeanNameAware,DisposableBean{
	
	private String name;
	private String color;
	private List<String> list;
	
	public Dog() {
		System.out.println("开始进行实例化");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("这是设置的方法");
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("测试测试InitializingBean");
	}
	
	public void start() {
		System.out.println("这是init-method方法");
	}
	
	public void stop() {
		System.out.println("这是stop的方法");
	}
	@Override
	public void setBeanName(String name) {

		this.name = name;
		System.out.println("BeanNameAware"+name);
	}
	@Override
	public void destroy() throws Exception {

		System.out.println("这是一个销毁方法");
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		System.out.println("什么时候被执行了");
		this.list = list;
	}
	
	

}
