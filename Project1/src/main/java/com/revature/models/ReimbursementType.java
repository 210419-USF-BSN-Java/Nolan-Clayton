package com.revature.models;

public class ReimbursementType {

	private Integer id;
	private String type;
	
		
	public ReimbursementType(String type) {
		super();
		this.type = type;
	}
	
	public ReimbursementType(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	public ReimbursementType() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	
}
