package com.ds.beanProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DemoBeanPostProcessor implements BeanPostProcessor {
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("processing bean instance after initialization of: " + beanName);
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("processing bean instance before initialization of: " + beanName);
		return bean;
	}

}