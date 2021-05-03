package com.revature.models;

import java.math.BigDecimal;

public class Offer {

	private Integer id;
	private BigDecimal price;
	private Integer iteId;
	private Integer custId;
	
	
	
	public Offer() {
		super();

	}
	
	public Offer(BigDecimal price, Integer iteId, Integer custId) {
		super();
		this.price = price;
		this.iteId = iteId;
		this.custId = custId;
	}

	public Offer(Integer id, BigDecimal price, Integer iteId, Integer custId) {
		super();
		this.id = id;
		this.price = price;
		this.iteId = iteId;
		this.custId = custId;
	}

	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Integer getIteId() {
		return iteId;
	}
	
	public void setIteId(Integer iteId) {
		this.iteId = iteId;
	}
	
	public Integer getCustId() {
		return custId;
	}
	
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	
	
}
