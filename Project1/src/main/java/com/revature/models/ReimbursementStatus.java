package com.revature.models;

public class ReimbursementStatus {

	private Integer id;
	private String status;
	
	
	public ReimbursementStatus(String status) {
		super();
		this.status = status;
	}
	
	public ReimbursementStatus(Integer id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	
	public ReimbursementStatus() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}	
	
}
