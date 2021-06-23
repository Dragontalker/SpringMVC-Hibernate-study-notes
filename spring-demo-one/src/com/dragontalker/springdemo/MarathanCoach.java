package com.dragontalker.springdemo;

public class MarathanCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public MarathanCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Do a 1/4 Marathan now!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
