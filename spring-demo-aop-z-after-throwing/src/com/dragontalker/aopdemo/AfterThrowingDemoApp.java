package com.dragontalker.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dragontalker.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find the accounts
		List<Account> theAccounts = null;
		
		try {
			// add a boolean flag to simulate exeception
			boolean tripWire = true;
			
			theAccounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n>Error> Main Program ... caught exception: " + e);
		}
		
		// display the accounts
		System.out.println("\n\n>> Main Program: AfterThrowingDemoApp");
		System.out.println(">> -----");
		
		System.out.println(">> " + theAccounts);
		
		System.out.println(">> -----\n");
		
		// close the context
		context.close();
	}
}
