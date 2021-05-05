package com.revature.models;

import java.math.BigDecimal;

public class Item {

	private Integer id;
	private String itemName;
	private String itemDescription;
	private BigDecimal itemEstimatedValue;
	private Integer ownerId;
	private BigDecimal weeklyPay;
	private BigDecimal price;
	private Integer remainingPayments;

	public Item() {
		super();
	}

	public Item(Integer id, String itemName, String itemDescription, BigDecimal itemEstimatedValue) {

		this.setId(id);
		this.setItemName(itemName);
		this.setItemDescription(itemDescription);
		this.setItemEstimatedValue(itemEstimatedValue);
		this.setOwnerId(null);
		this.setweeklyPay(null);
		this.setPrice(null);
		this.setRemainingPayments(null);

	}
	
	
	public Item(String itemName, String itemDescription, BigDecimal itemEstimatedValue) {

		this.setItemName(itemName);
		this.setItemDescription(itemDescription);
		this.setItemEstimatedValue(itemEstimatedValue);
		this.setOwnerId(null);
		this.setweeklyPay(null);
		this.setPrice(null);
		this.setRemainingPayments(null);

	}

	public Item(Integer id, String itemName, String itemDescription, BigDecimal itemEstimatedValue, Integer ownerId,
			BigDecimal weeklyPay, BigDecimal price, Integer remainingPayments) {

		this.setId(id);
		this.setItemName(itemName);
		this.setItemDescription(itemDescription);
		this.setItemEstimatedValue(itemEstimatedValue);
		this.setOwnerId(ownerId);
		this.setweeklyPay(weeklyPay);
		this.setPrice(price);
		this.setRemainingPayments(remainingPayments);

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public BigDecimal getItemEstimatedValue() {
		return itemEstimatedValue;
	}

	public void setItemEstimatedValue(BigDecimal itemEstimatedValue) {
		this.itemEstimatedValue = itemEstimatedValue;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer owner) {
		this.ownerId = owner;
	}

	public BigDecimal getweeklyPay() {
		return weeklyPay;
	}

	public void setweeklyPay(BigDecimal weeklyPay) {
		this.weeklyPay = weeklyPay;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getRemainingPayments() {
		return remainingPayments;
	}

	public void setRemainingPayments(Integer remainingPayments) {
		this.remainingPayments = remainingPayments;
	}

}
