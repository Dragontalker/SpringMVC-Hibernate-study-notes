package com.dragontalker.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
	
	public HappyFortuneService() {
		System.out.println(">> HappyFortuneService: inside default constructor");
	}

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}

