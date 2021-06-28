package com.dragontalker.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddMethod() {
		
		System.out.println("\n=====>> Excuting @Before advice on any add method!");
	}
	
	
	
	
	
}
