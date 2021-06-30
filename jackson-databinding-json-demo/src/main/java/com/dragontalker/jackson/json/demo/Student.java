package com.dragontalker.jackson.json.demo;

import java.util.Arrays;

public class Student {
	
	private int id;
	private String firstName;
	private String lastName;
	private boolean active;
	private Address address;
	private String[] langugages;
	
	public Student() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String[] getLangugages() {
		return langugages;
	}

	public void setLangugages(String[] langugages) {
		this.langugages = langugages;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", active=" + active
				+ ", address=" + address + ", langugages=" + Arrays.toString(langugages) + "]";
	}

}
