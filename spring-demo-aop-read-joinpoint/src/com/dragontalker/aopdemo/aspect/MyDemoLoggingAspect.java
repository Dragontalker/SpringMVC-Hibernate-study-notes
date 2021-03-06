package com.dragontalker.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.dragontalker.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.dragontalker.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddMethod(JoinPoint theJoinPoint) {
		
		System.out.println("\n=====>> Excuting @Before advice on any add method!");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println(">> Method: " + methodSignature);
		
		// display method arguments
		
		// get args
		Object[] argObjects = theJoinPoint.getArgs();
		
		// loop thru args
		for (int i = 0; i < argObjects.length; i++) {
			System.out.println(">> #" + i + " argument: " + argObjects[i]);
			
			if (argObjects[i] instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) argObjects[i];
				
				System.out.println(">>> account name: " + theAccount.getName());
				System.out.println(">>> account level: " + theAccount.getLevel());
			}
		}
		
	}
	
}
