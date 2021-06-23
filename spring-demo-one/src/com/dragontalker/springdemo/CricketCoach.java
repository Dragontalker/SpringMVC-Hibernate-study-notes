package com.dragontalker.springdemo;

public class CricketCoach implements FortuneService {
	
	private FortuneService fortuneService;

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
