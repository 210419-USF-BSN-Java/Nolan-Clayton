package com.revature.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import com.revature.daos.ItemDao;
import com.revature.daos.OfferDao;
import com.revature.models.Customer;
import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.util.LoggerSingelton;
import com.revature.util.ScannerSingleton;

public class CustomerStartMenuBuilder {

	// Customer session
	private static Customer loggedInCustomer;

	
	
	public static Customer getLoggedInCustomer() {
		return loggedInCustomer;
	}


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
			CustomerStartMenuBuilder.listItemsMenu();
			break;

		case 2:
			CustomerStartMenuBuilder.makeOfferMenu();
			break;

		case 3:
			CustomerStartMenuBuilder.viewOwnedItemsMenu();
			break;

		case 4:
			CustomerStartMenuBuilder.makePaymentMenu();
			break;

		case 5:
			LoggerSingelton.getLottger().info(loggedInCustomer.getUserName() + " exited");
			System.exit(0);
			break;

		default:
			break;

		}

	}

	
	public static void makePaymentMenu() {
		
		Integer itemId;
		
		System.out.print("Enter Item Id make a payment for: ");
		itemId = Integer.parseInt(ScannerSingleton.getScanner().nextLine());
		
		CustomerServices.addPayment(itemId);

		System.out.println("Payment Made!");
		System.out.println();
		CustomerStartMenuBuilder.startMenu();
		
	}
	
	public static void listItemsMenu() {

		List<Item> items = ItemDao.getAllAvailable();

		System.out.println("Available Items: ");
		for (Item ite : items) {

			System.out.println("Item Id: " + ite.getId() + " Item Name: " + ite.getItemName() + " Item Description: "
					+ ite.getItemDescription() + " Item Estimated Value: " + ite.getItemEstimatedValue());

		}

		LoggerSingelton.getLottger().info(loggedInCustomer.getUserName() + " viewed available items");
		
		System.out.println();
		CustomerStartMenuBuilder.startMenu();
	}

	public static void makeOfferMenu() {
		Integer id;
		BigDecimal price;
		Integer numWeeklyPay;
		BigDecimal numWeeklyPayDeci;

		System.out.print("Enter Item Id: ");
		id = Integer.parseInt(ScannerSingleton.getScanner().nextLine());

		System.out.print("Enter offer price: ");
		price = BigDecimal.valueOf(Double.parseDouble(ScannerSingleton.getScanner().nextLine()));
		
		System.out.print("Enter Number of Weekly Payments: ");
		numWeeklyPay = Integer.parseInt(ScannerSingleton.getScanner().nextLine());

		OfferDao.add(new Offer(price, id, loggedInCustomer.getId(), numWeeklyPay));
		
		numWeeklyPayDeci = new BigDecimal(numWeeklyPay);
		System.out.println("Weekly Payments are: " + price.divide(numWeeklyPayDeci, 2, RoundingMode.HALF_UP));
		
		System.out.println("Offer Made!");
		
		LoggerSingelton.getLottger().info(loggedInCustomer.getUserName() + " made offer for item id = " + id + " at price = " + price);
		
		System.out.println();
		CustomerStartMenuBuilder.startMenu();
	}

	public static void viewOwnedItemsMenu() {

		List<Item> items = ItemDao.getOwnedItems(loggedInCustomer.getId());

		System.out.println("Owned Items: ");
		for (Item ite : items) {

			System.out.println("Item Id: " + ite.getId() + " Item Name: " + ite.getItemName() + " Item Description: "
					+ ite.getItemDescription() + " Item Offer Price: " + ite.getPrice() + " Remaining Payments: "
					+ ite.getRemainingPayments() + " Weekly Payments: " + ite.getweeklyPay());

		}

		LoggerSingelton.getLottger().info(loggedInCustomer.getUserName() + " viewed owned items");
		
		System.out.println();
		CustomerStartMenuBuilder.startMenu();

	}

}
