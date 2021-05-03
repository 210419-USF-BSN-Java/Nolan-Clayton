package com.revature.models;

public class Customer extends User {

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name, String userName, String password) {
		
		this.setName(name);
		this.setUserName(userName);
		this.setPassword(password);
		
	}
	
	public Customer(int id, String name, String userName, String password) {
		
		this.setId(id);
		this.setName(name);
		this.setUserName(userName);
		this.setPassword(password);
		
	}

	
	
}
