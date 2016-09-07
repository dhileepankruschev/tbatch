package com.tkhts.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("After InitializationBean Name is: " + beanName);
		
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("Before InitializationBean Name is: " + beanName);
		return beanName;
	}

}
