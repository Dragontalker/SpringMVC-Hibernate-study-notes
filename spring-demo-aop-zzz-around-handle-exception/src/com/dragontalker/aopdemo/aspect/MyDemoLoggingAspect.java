package com.dragontalker.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.dragontalker.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n>> Executing @Around on method: " + method);
		
		// get begin time stamp
		long begin = System.currentTimeMillis();
		
		// now, let's execute the method
		Object result = theProceedingJoinPoint.proceed();
		
		// get the end time stamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		myLogger.info("\n>> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
	}
	
	@After("execution(* com.dragontalker.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n>>> Executing @After (finally) on method: " + method);
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.dragontalker.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc"
			)
	public void afterThrowingFindAccountsAdvice(
					JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		myLogger.info("\n>>> exception is: " + theExc);
		
	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut = "execution(* com.dragontalker.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturningFindAccountsAdvice(
					JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		myLogger.info("\n>>> result is: " + result);
		
		// let's post-process the data ... let's modify it!
		
		// convert the account names to upper case
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n>>> modified result is: " + result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop through accounts
		for (Account tempAccount : result) {
			
			// get upper case version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);
			
		}
				
	}

	@Before("com.dragontalker.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddMethod(JoinPoint theJoinPoint) {
		
		myLogger.info("\n=====>> Excuting @Before advice on any add method!");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info(">> Method: " + methodSignature);
		
		// display method arguments
		
		// get args
		Object[] argObjects = theJoinPoint.getArgs();
		
		// loop thru args
		for (int i = 0; i < argObjects.length; i++) {
			myLogger.info(">> #" + i + " argument: " + argObjects[i].toString());
			
			if (argObjects[i] instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) argObjects[i];
				
				myLogger.info(">>> account name: " + theAccount.getName());
				myLogger.info(">>> account level: " + theAccount.getLevel());
			}
		}
		
	}
	
}
