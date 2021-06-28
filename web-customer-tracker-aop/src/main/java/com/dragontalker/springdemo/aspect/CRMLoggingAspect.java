package com.dragontalker.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.dragontalker.springdemo.controller.*.*.(..))")
	private void forControllerPackage() {
		
	}
	
	// add @Before advice
	
	// add @AfterReturning advice
	
}
