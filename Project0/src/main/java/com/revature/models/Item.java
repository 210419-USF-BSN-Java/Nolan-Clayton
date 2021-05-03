package com.revature.models;

public class Item {

	private Integer id;
	private String itemName;
	private String itemDescription;
	private Float itemEstimatedValue;
	private Integer ownerId;
	private Float remainingBalance;
	private Float price;
	private Integer remainingPayments;

	public Item() {
		super();
	}

	public Item(String itemName, String itemDescription, Float itemEstimatedValue) {

		this.setItemName(itemName);
		this.setItemDescription(itemDescription);
		this.setItemEstimatedValue(itemEstimatedValue);
		this.setOwnerId(null);
		this.setRemainingBalance(null);

	}

	public Item(Integer id, String itemName, String itemDescription, Float itemEstimatedValue, Integer ownerId,
			Float remainingBalance, Float price, Integer remainingPayments) {

		this.setId(id);
		this.setItemName(itemName);
		this.setItemDescription(itemDescription);
		this.setItemEstimatedValue(itemEstimatedValue);
		this.setOwnerId(ownerId);
		this.setRemainingBalance(remainingBalance);
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

	public Float getItemEstimatedValue() {
		return itemEstimatedValue;
	}

	public void setItemEstimatedValue(Float itemEstimatedValue) {
		this.itemEstimatedValue = itemEstimatedValue;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer owner) {
		this.ownerId = owner;
	}

	public Float getRemainingBalance() {
		return remainingBalance;
	}

	public void setRemainingBalance(Float remainingBalance) {
		this.remainingBalance = remainingBalance;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getRemainingPayments() {
		return remainingPayments;
	}

	public void setRemainingPayments(Integer remainingPayments) {
		this.remainingPayments = remainingPayments;
	}

}
