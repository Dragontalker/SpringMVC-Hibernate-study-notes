package com.dragontalker.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dragontalker.aopdemo.service.TrafficFortuneService;

public class AroundHandelExceptionDemoApp {

	private static Logger myLogger = 
			Logger.getLogger(AroundHandelExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info(">> Main Program: AroundDemoApp");
		
		myLogger.info(">> Calling getFortune()");
		
		boolean tripWire = true;

		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info(">> My fortune is: " + data);
		
		myLogger.info(">> Finished");
		
		// close the context
		context.close();
	}
}
