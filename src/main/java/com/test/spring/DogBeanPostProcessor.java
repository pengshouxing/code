package com.test.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

public class DogBeanPostProcessor implements BeanPostProcessor,InstantiationAwareBeanPostProcessor {
	
	public DogBeanPostProcessor() {
		System.out.println("DogBeanPostProcessor:init");
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName+":postProcessBeforeInitialization");
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName+":postProcessAfterInitialization");
		return bean;
	}
	
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInstantiation"+beanName);
		return null;
	}
	
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInstantiation"+beanName);
		return true;
	}

}
