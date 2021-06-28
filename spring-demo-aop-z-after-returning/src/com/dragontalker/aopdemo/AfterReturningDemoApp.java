package com.dragontalker.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dragontalker.aopdemo.dao.AccountDAO;
import com.dragontalker.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = 
				context.getBean("accountDAO", AccountDAO.class);

		
		// close the context
		context.close();
	}
}
