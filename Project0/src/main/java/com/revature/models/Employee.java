package com.revature.models;

public class Employee extends User {
	
	private boolean manFlag;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, String userName, String password, boolean manFlag) {
		
		this.setName(name);
		this.setUserName(userName);
		this.setPassword(password);
		this.setManFlag(manFlag);
		
	}
	
	public Employee(int id, String name, String userName, String password, boolean manFlag) {
		
		this.setId(id);
		this.setName(name);
		this.setUserName(userName);
		this.setPassword(password);
		this.setManFlag(manFlag);
		
	}
	
	
	public void setManFlag(boolean manFlag) {
		this.manFlag = manFlag;
	}
	
	public boolean getManFlag() {
		return manFlag;
	}

}
