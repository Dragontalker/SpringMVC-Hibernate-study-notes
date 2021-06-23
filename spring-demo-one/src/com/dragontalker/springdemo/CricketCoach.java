package com.dragontalker.springdemo;

public class CricketCoach implements Coach {
	
	private String emailAddress;
	private String team;
	private FortuneService fortuneService;
	
	public CricketCoach() {
		System.out.println("CricketCoach: constructor triggered");
	}
	
	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: emailAddress setter triggered");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: team setter triggered");
		this.team = team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: fortuneService setter triggered");
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
