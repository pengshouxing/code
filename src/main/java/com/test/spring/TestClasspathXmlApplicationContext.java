package com.test.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClasspathXmlApplicationContext {

	public static void main(String[] args) {

		/**
		 * 1.准备刷新。
		 * 2.创建beanFactory并解析xml文件。每个bean生成每个BeanDefinition
		 * 3.准备beanFactory。给beanFactory设置一些参数
		 * 4.后置处理BeanFactory。具体还没有实现
		 * 5.调用beanFactory的后置处理器。
		 * 6.往BeanFactory注册BeanPostProcessor后置处理器。
		 * 7.初始化国际化MessageSource。
		 * 8.初始化事件广播器ApplicationEventMulticaster。
		 * 9.初始化其他特殊的bean,暂无实现。
		 * 10.注册监听者。
		 * 11.
		 */
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		Dog dog = (Dog) ac.getBean("dog");
		ac.close();
		
	}

}
