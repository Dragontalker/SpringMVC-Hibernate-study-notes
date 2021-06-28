package com.dragontalker.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dragontalker.aopdemo.service.TrafficFortuneService;
public class AroundWithLoggerDemoApp {

	private static Logger myLogger = 
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		// read spring configuration java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\n>> Main Program: AroundDemoApp");
		
		myLogger.info("\n>> Calling getFortune()");

		String data = theFortuneService.getFortune();
		
		myLogger.info("\n>> My fortune is: " + data);
		
		myLogger.info("\n>> Finished");
		
		// close the context
		context.close();
	}
}
