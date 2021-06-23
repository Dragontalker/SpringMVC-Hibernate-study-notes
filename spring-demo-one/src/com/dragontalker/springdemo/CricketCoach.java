package com.dragontalker.springdemo;

public class CricketCoach implements Coach {
	
	private String emailAddress;
	private String team;
	private FortuneService fortuneService;
	
	public CricketCoach() {
		System.out.println("CricketCoach: constructor triggered");
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: setter method triggered");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public String toString() {
		return "CricketCoach [emailAddress=" + emailAddress + ", team=" + team + "]";
	}
}
