package com.demo.batch.sample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackageClasses = ApplicationConfiguration.class)
@ComponentScan("com.demo.batch")
public class ApplicationConfiguration {
}
