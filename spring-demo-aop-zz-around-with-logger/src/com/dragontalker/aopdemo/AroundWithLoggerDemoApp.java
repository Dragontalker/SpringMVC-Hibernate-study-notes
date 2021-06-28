package com.dragontalker.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dragontalker.aopdemo.service.TrafficFortuneService;
import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;

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
		
		System.out.println("\n>> Main Program: AroundDemoApp");
		
		System.out.println(">> Calling getFortune()");

		System.out.println(theFortuneService.getFortune());
		
		// close the context
		context.close();
	}
}
