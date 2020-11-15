package com.test.spring.annotation;

import java.lang.annotation.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

public class TestAnnoation {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AnimalConfig.class);
		AnimalConfig animal = ac.getBean(AnimalConfig.class);
		

		/*
		 * DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		 * RootBeanDefinition beanDefinition = new RootBeanDefinition(Cat.class);
		 * beanFactory.registerBeanDefinition("cat1", beanDefinition);
		 * beanFactory.registerBeanDefinition("cat2", beanDefinition);
		 * 
		 * System.out.println("isAutowireCandidate:"+beanDefinition.isAutowireCandidate(
		 * ));
		 * 
		 * String[] type = beanFactory.getBeanNamesForType(Cat.class); for (String s :
		 * type) { System.out.println(s); }
		 * 
		 * String[] type2 = beanFactory.getBeanNamesForAnnotation(Autowired.class); for
		 * (String s2 : type2) { System.out.println(s2); } Component autowired =
		 * beanFactory.findAnnotationOnBean("cat1", Component.class);
		 * System.out.println(autowired);
		 * 
		 * Annotation[] annotations = Cat.class.getDeclaredAnnotations(); for
		 * (Annotation annotation : annotations) { System.out.println("注解名称:" +
		 * annotation.toString()); }
		 * 
		 * beanFactory.preInstantiateSingletons();
		 * 
		 * test(beanFactory);
		 */
	}
	
	public static void test(ConfigurableListableBeanFactory beanFactory) {
		if(beanFactory instanceof BeanDefinitionRegistry) {
			System.out.println("是属于BeanDefinitionRegistry");
		}
	}

}
