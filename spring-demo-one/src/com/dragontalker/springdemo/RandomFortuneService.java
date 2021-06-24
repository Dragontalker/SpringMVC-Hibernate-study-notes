package com.dragontalker.springdemo;

public class RandomFortuneService implements FortuneService {
	

	@Override
	public String getFortune() {
		String[] service = {"Who am I?", "Where am I from?", "Where should I go?"};
		int index = (int) Math.floor(Math.random() * service.length);
		return service[index];
	}

}
