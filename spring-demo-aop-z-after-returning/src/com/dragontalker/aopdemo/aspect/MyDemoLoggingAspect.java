package com.dragontalker.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut = "execution(* com.dragontalker.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturningFindAccountsAdvice(
					JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n>>> result is: " + result);
		
		// let's post-process the data ... let's modify it!
		
		// convert the account names to upper case
		convertAccountNamesToUpperCase(result);
	}
	
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
