package com.mycompany.myapp.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
 
// TODO 1. Make this class behave as an Aspect
public class MyAspect {
 
//	TODO 2. This should be printed before call to UserService. Add required annotation.
 public void doLog() {
  System.out.println("do logging");
 }
 
//	TODO 3. This should be printed after call to UserService. Add required annotation.
 public void doSysout() {
  System.out.println("do sysout");
 }
 
}
