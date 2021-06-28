package com.dragontalker.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount() {
		
		System.out.println(">> " + getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public void addSillyMember() {
		
		System.out.println(">> " + getClass() + ": DOING STUFF: ADDING A MEMBER");
	}
}
