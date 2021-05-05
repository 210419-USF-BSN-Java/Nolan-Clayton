package com.revature.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

	private Integer Id;
	private LocalDateTime timeStamp;
	private BigDecimal payValue;
	private Item item;
	
	
	public Payment(LocalDateTime date, Item item, BigDecimal payValue) {
		super();
		this.timeStamp = date;
		this.item = item;
		this.payValue = payValue;
	}

	public Payment(Integer id, LocalDateTime date, Item item, BigDecimal payValue) {
		super();
		Id = id;
		this.timeStamp = date;
		this.item = item;
		this.payValue = payValue;
	}
	
	
	
	public BigDecimal getPayValue() {
		return payValue;
	}

	public void setPayValue(BigDecimal payValue) {
		this.payValue = payValue;
	}

	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer id) {
		Id = id;
	}
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(LocalDateTime date) {
		this.timeStamp = date;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
}
