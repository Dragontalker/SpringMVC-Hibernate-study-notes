package com.dragontalker.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Pointcut("execution(* com.dragontalker.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create point cut for getter methods
	@Pointcut("execution(* com.dragontalker.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create point cut for setter methods
	@Pointcut("execution(* com.dragontalker.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// combine point cut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddMethod() {
		
		System.out.println("\n>> Excuting @Before advice on any add method!");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		
		System.out.println("\n>> Performing API analytics");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void logToCloudAsync() {
		
		System.out.println("\n>> Logging to Cloud in async fashion");
	}
	
}
