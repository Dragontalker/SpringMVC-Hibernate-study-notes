package com.dragontalker.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach cricketCoach = context.getBean("myCricketCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyWorkout());
		
		// let's call our new method for fortuneService
		System.out.println(theCoach.getDailyFortune());
		System.out.println(cricketCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
