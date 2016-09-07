package com.mycompany.myapp.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
 
@Aspect
public class MyAspect {
 
 // Before Pointcut This method will be called before any method in MyService
 // is executed
 @Before("execution(* com.mycompany.myapp.service.MyService.*(..))")
 public void doLog() {
  System.out.println("do some preprocessing");
 }
 
 // After pointcut This method will be called after any method in MyService
 // is executed
 @After("execution(* com.mycompany.myapp.service.MyService.*(..))")
 public void doSysout() {
  System.out.println("do some postprocessing");
 }
 
}
