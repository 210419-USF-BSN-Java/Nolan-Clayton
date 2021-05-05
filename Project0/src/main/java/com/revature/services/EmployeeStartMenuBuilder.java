package com.revature.services;

import java.math.BigDecimal;
import java.util.List;
import com.revature.daos.EmployeeDao;
import com.revature.daos.ItemDao;
import com.revature.daos.OfferDao;
import com.revature.daos.PaymentDao;
import com.revature.models.Employee;
import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.util.LoggerSingelton;
import com.revature.util.ScannerSingleton;

public class EmployeeStartMenuBuilder {

	// Employee session
	private static Employee loggedInEmployee;

	public static Employee getLoggedInEmployee() {
		return loggedInEmployee;
	}

	
	public static void setLoggedInEmployee(Employee emp) {
		loggedInEmployee = emp;
	}

	public static void startMenuEmployeeSelector() {

		// Selects which menu to use the regular employee or the manager menu based on
		// flag
		if (loggedInEmployee.getManFlag()) {
			EmployeeStartMenuBuilder.startMenuManager();

		} else {
			EmployeeStartMenuBuilder.startMenuEmployeeRegular();

		}

	}

	public static void startMenuEmployeeRegular() {

		Integer selection = 0;

		while (selection < 1 || selection > 9) {

			System.out.println("Welcome " + loggedInEmployee.getName());
			System.out.println("1) View all items");
			System.out.println("2) Add Item");
			System.out.println("3) Edit Item by Id");
			System.out.println("4) Delete Item by Id");
			System.out.println("5) View All Offers");
			System.out.println("6) Accept Offer by Offer Id");
			System.out.println("7) Reject Offer by Offer Id");
			System.out.println("8) View All Payments");
			System.out.println("9) Exit\n");

			System.out.print("Select: ");
			selection = Integer.parseInt(ScannerSingleton.getScanner().nextLine());

		}

		switch (selection) {

		case 1:
			EmployeeStartMenuBuilder.listAllItemsMenu();
			break;

		case 2:
			EmployeeStartMenuBuilder.addItemMenu();
			break;

		case 3:
			EmployeeStartMenuBuilder.editItemMenu();
			break;

		case 4:
			EmployeeStartMenuBuilder.deleteItemMenu();
			break;

		case 5:
			EmployeeStartMenuBuilder.viewOffersMenu();
			break;

		case 6:
			EmployeeStartMenuBuilder.acceptOfferMenu();
			break;

		case 7:
			EmployeeStartMenuBuilder.rejectOfferMenu();
			break;

		case 8:
			EmployeeStartMenuBuilder.viewAllPaymentsMenu();
			break;

		case 9:
			LoggerSingelton.getLottger().info(loggedInEmployee.getUserName() + " exited");
			System.exit(0);
			break;

		default:
			break;

		}
	}

	public static void startMenuManager() {

		Integer selection = 0;

		while (selection < 1 || selection > 12) {

			System.out.println("Welcome " + loggedInEmployee.getName());
			System.out.println("1) View all Items");
			System.out.println("2) Add Item");
			System.out.println("3) Edit Item by Id");
			System.out.println("4) Delete Item by Id");
			System.out.println("5) View All offers");
			System.out.println("6) Accept Offer by offer Id");
			System.out.println("7) Reject Offer by offer Id");
			System.out.println("8) View All Payments");
			System.out.println("9) View All Employees");
			System.out.println("10) Create Employee Account");
			System.out.println("11) Fire Employee");
			System.out.println("12) Exit\n");

			System.out.print("Select: ");
			selection = Integer.parseInt(ScannerSingleton.getScanner().nextLine());

			switch (selection) {

			case 1:
				EmployeeStartMenuBuilder.listAllItemsMenu();
				break;

			case 2:
				EmployeeStartMenuBuilder.addItemMenu();
				break;

			case 3:
				EmployeeStartMenuBuilder.editItemMenu();
				break;

			case 4:
				EmployeeStartMenuBuilder.deleteItemMenu();
				break;

			case 5:
				EmployeeStartMenuBuilder.viewOffersMenu();
				break;

			case 6:
				EmployeeStartMenuBuilder.acceptOfferMenu();
				break;

			case 7:
				EmployeeStartMenuBuilder.rejectOfferMenu();
				break;

			case 8:
				EmployeeStartMenuBuilder.viewAllPaymentsMenu();
				break;

			case 9:
				EmployeeStartMenuBuilder.viewAllEmployeesMenu();
				break;

			case 10:
				EmployeeStartMenuBuilder.EmployeeRegistrationMenu();
				break;

			case 11:
				EmployeeStartMenuBuilder.fireEmployeeMenu();
				break;

			case 12:
				LoggerSingelton.getLottger().info(loggedInEmployee.getUserName() + " exited");
				System.exit(0);
				break;

			default:
				break;

			}

		}
	}

	public static void viewAllPaymentsMenu() {

		List<Payment> payments = PaymentDao.getAll();

		System.out.println("All Payments:");

		for (Payment pay : payments) {

			System.out.println("Payment Id: " + pay.getId() + " Time Stamp: " + pay.getTimeStamp() + " Item Id: "
					+ pay.getItem().getId() + " Item Name: " + pay.getItem().getItemName() + " Customer Id: "
					+ pay.getItem().getOwnerId() + " Payment Value: " + pay.getPayValue());
		}

		LoggerSingelton.getLottger().info(loggedInEmployee.getUserName() + " viewed all payments");

		System.out.println();
		EmployeeStartMenuBuilder.startMenuEmployeeSelector();

	}

	public static void fireEmployeeMenu() {
		Integer id;

		System.out.print("Enter Employee Id to fire: ");
		id = Integer.parseInt(ScannerSingleton.getScanner().nextLine());

		EmployeeServices.removeEmployee(id);

		System.out.println("Employed Fired!");

		System.out.println();
		EmployeeStartMenuBuilder.startMenuEmployeeSelector();

	}

	public static void viewAllEmployeesMenu() {
		List<Employee> employees = EmployeeDao.getAll();

		System.out.println("All Offers:");
		// Loops though and prints out all employees retrieved
		for (Employee emp : employees) {

			System.out.println("Employee Id: " + emp.getId() + " Employee Name: " + emp.getName()
					+ " Employee Username: " + emp.getUserName() + " Is a Manager: " + emp.getManFlag());
		}

		LoggerSingelton.getLottger().info(loggedInEmployee.getUserName() + " viewed all employees ");

		System.out.println();
		EmployeeStartMenuBuilder.startMenuEmployeeSelector();

	}

	public static void EmployeeRegistrationMenu() {

		String name;
		String userName;
		String password;
		Integer flagSelection;
		Boolean manFlag = false;

		System.out.print("Please enter Name: ");
		name = ScannerSingleton.getScanner().nextLine();

		System.out.print("Please enter Username: ");
		userName = ScannerSingleton.getScanner().nextLine().toLowerCase();

		System.out.print("Please enter password: ");
		password = ScannerSingleton.getScanner().nextLine();

		System.out.print("Is a manager 0 = no or 1 = yes: ");
		flagSelection = Integer.parseInt(ScannerSingleton.getScanner().nextLine());

		if (flagSelection == 1) {
			manFlag = true;
		} else if (flagSelection == 0) {
			manFlag = false;
		}

		EmployeeServices.createEmployee(new Employee(name, userName, password, manFlag));

		System.out.println("Employee Account Created!");

		System.out.println();
		EmployeeStartMenuBuilder.startMenuEmployeeSelector();

	}

	public static void acceptOfferMenu() {
		Integer offId;

		System.out.print("Enter Offer Id to Accept: ");
		offId = Integer.parseInt(ScannerSingleton.getScanner().nextLine());

		EmployeeServices.insertAcceptedOffer(offId);

		System.out.println("Offer Accepted!");
		System.out.println();
		EmployeeStartMenuBuilder.startMenuEmployeeSelector();
	}

	public static void rejectOfferMenu() {
		Integer offId;

		System.out.print("Enter Offer Id to Reject: ");
		offId = Integer.parseInt(ScannerSingleton.getScanner().nextLine());

		EmployeeServices.removeOffer(offId);

		System.out.println("Offer Rejected!");
		System.out.println();
		EmployeeStartMenuBuilder.startMenuEmployeeSelector();

	}

	public static void viewOffersMenu() {

		List<Offer> offers = OfferDao.getAll();

		System.out.println("All Offers: ");
		for (Offer off : offers) {

			System.out.println("Offer Id: " + off.getId() + " Item Id: " + off.getIteId() + " Customer Id: "
					+ off.getCustId() + " Offer Price: " + off.getPrice());
		}

		LoggerSingelton.getLottger().info(loggedInEmployee.getUserName() + " viewed all offers");

		System.out.println();
		EmployeeStartMenuBuilder.startMenuEmployeeSelector();

	}

	public static void deleteItemMenu() {

		Integer itemId;

		System.out.print("Enter Item Id to Delete: ");
		itemId = Integer.parseInt(ScannerSingleton.getScanner().nextLine());

		EmployeeServices.removeItem(itemId);

		System.out.println("Item Removed");
		
		System.out.println();
		EmployeeStartMenuBuilder.startMenuEmployeeSelector();

	}

	public static void editItemMenu() {

		String itemName;
		String itemDescription;
		BigDecimal itemEstimatedValue;
		Integer itemId;

		System.out.print("Enter Item Id to edit: ");
		itemId = Integer.parseInt(ScannerSingleton.getScanner().nextLine());

		System.out.print("Enter New Item Name: ");
		itemName = ScannerSingleton.getScanner().nextLine();

		System.out.print("Enter New Item Description: ");
		itemDescription = ScannerSingleton.getScanner().nextLine();

		System.out.print("Enter New estimated value: ");
		itemEstimatedValue = BigDecimal.valueOf(Double.parseDouble(ScannerSingleton.getScanner().nextLine()));

		EmployeeServices.updateItem(new Item(itemId, itemName, itemDescription, itemEstimatedValue));

		System.out.println("Item modified!");
		
		System.out.println();
		EmployeeStartMenuBuilder.startMenuEmployeeSelector();

	}

	public static void listAllItemsMenu() {

		List<Item> items = ItemDao.getAll();

		System.out.println("All Items: ");
		for (Item ite : items) {

			System.out.println("Item Id: " + ite.getId() + " Item Name: " + ite.getItemName() + " Item Description: "
					+ ite.getItemDescription() + " Item Estimated Value: " + ite.getItemEstimatedValue() + " Owner Id: "
					+ ite.getOwnerId() + " Weekly Payment: " + ite.getweeklyPay() + " Price: " + ite.getPrice()
					+ " Remaining Payments: " + ite.getRemainingPayments());

		}

		LoggerSingelton.getLottger().info(loggedInEmployee.getUserName() + " viewed all items");

		System.out.println();
		EmployeeStartMenuBuilder.startMenuEmployeeSelector();
	}

	public static void addItemMenu() {

		String itemName;
		String itemDescription;
		BigDecimal itemEstimatedValue;

		System.out.print("Enter Item Name: ");
		itemName = ScannerSingleton.getScanner().nextLine();

		System.out.print("Enter Item Description: ");
		itemDescription = ScannerSingleton.getScanner().nextLine();

		System.out.print("Enter estimated value: ");
		itemEstimatedValue = BigDecimal.valueOf(Double.parseDouble(ScannerSingleton.getScanner().nextLine()));

		EmployeeServices.addItem(new Item(itemName, itemDescription, itemEstimatedValue));

		System.out.println("Item added!");
		
		System.out.println();
		EmployeeStartMenuBuilder.startMenuEmployeeSelector();

	}

}
