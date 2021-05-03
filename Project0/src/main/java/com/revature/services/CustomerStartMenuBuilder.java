package com.revature.services;

import java.math.BigDecimal;
import java.util.List;

import com.revature.daos.ItemDao;
import com.revature.daos.OfferDao;
import com.revature.models.Customer;
import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.util.ScannerSingleton;

public class CustomerStartMenuBuilder {

	private static Customer loggedInCustomer;
	
	// Used to know which customer is currently logged in
	public static void setLoggedInCustomer(Customer cust) {
		loggedInCustomer = cust;
	}
	
	public static void startMenu() {

		Integer selection = 0;

		while (selection < 1 || selection > 5) {

			System.out.println("Welcome " + loggedInCustomer.getName());
			System.out.println("1) View available items");
			System.out.println("2) Make offer for item by Id");
			System.out.println("3) View owned items");
			System.out.println("4) Make payment by Id");
			System.out.println("5) Exit\n");

			System.out.print("Select: ");
			selection = Integer.parseInt(ScannerSingleton.getScanner().nextLine());

		}

		switch (selection) {

		case 1:
			CustomerStartMenuBuilder.listItems();
			CustomerStartMenuBuilder.startMenu();
			break;

		case 2:
			CustomerStartMenuBuilder.makeOffer();
			CustomerStartMenuBuilder.startMenu();
			break;

		case 3:

			break;

		case 4:

			break;

		case 5:
			System.exit(0);
			break;
			
		default:
			break;

		}

	}
	
	public static void listItems() {
		
		List<Item> items = ItemDao.getAllAvailable();
		
		
		System.out.println("Available Items: ");
		for(Item ite : items) {
			
			System.out.println("Item Id: " + ite.getId() + " Item Name: " + ite.getItemName() + " Item Description: " + ite.getItemDescription() + " Item Estimated Value: " + ite.getItemEstimatedValue());
			
		}
		
		System.out.println();
	}
	
	
	public static void makeOffer() {
		Integer id;
		BigDecimal price;
		
		System.out.print("Enter Item Id: ");
		id = Integer.parseInt(ScannerSingleton.getScanner().nextLine());
		
		System.out.print("Enter offer price: ");
		price =  BigDecimal.valueOf(Double.parseDouble(ScannerSingleton.getScanner().nextLine()));
		
		OfferDao.add(new Offer(price, id, loggedInCustomer.getId()));
		System.out.println("Offer Made!\n");
	}

}
