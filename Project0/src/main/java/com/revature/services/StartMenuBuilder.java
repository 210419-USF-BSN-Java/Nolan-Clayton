package com.revature.services;

import com.revature.daos.CustomerDao;
import com.revature.daos.EmployeeDao;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.util.LoggerSingelton;
import com.revature.util.ScannerSingleton;

public class StartMenuBuilder {

	public static void startUpMenu() {

		Integer selection = 0;

		while (selection < 1 || selection > 4) {

			System.out.println("Welcome to Nolan's Pawn Shop! \nMenu Options:");
			System.out.println("1) Customer Registration");
			System.out.println("2) Customer Login");
			System.out.println("3) Employee Login");
			System.out.println("4) Exit\n");

			System.out.print("Select: ");
			selection = Integer.parseInt(ScannerSingleton.getScanner().nextLine());
		}

		switch (selection) {

		case 1:
			StartMenuBuilder.customerRegistrationMenu();
			break;

		case 2:
			StartMenuBuilder.customerLoginMenu();
			break;

		case 3:
			StartMenuBuilder.employeeLoginMenu();
			break;

		case 4:
			System.exit(0);
			
		default:
			break;

		}
	}

	public static void customerRegistrationMenu() {

		String name;
		String userName;
		String password;
		Customer cust;
		
		System.out.print("Please enter Name: ");
		name = ScannerSingleton.getScanner().nextLine();

		System.out.print("Please enter Username: ");
		userName = ScannerSingleton.getScanner().nextLine().toLowerCase();

		System.out.print("Please enter password: ");
		password = ScannerSingleton.getScanner().nextLine();
		
		cust = new Customer(name, userName, password);
		CustomerServices.registerCustomer(cust);
		
		LoggerSingelton.getLottger().info("New Customer Registration Name = " + name + " UserName = " + userName);
		
		StartMenuBuilder.startUpMenu();

	}

	public static void customerLoginMenu() {

		String inputUserName;
		String inputPassword;
		Customer cust;

		System.out.print("Please enter Username: ");
		inputUserName = ScannerSingleton.getScanner().nextLine().toLowerCase();

		System.out.print("Please enter password: ");
		inputPassword = ScannerSingleton.getScanner().nextLine();

		cust = CustomerDao.getByUsername(inputUserName);

		LoggerSingelton.getLottger().info("Attempted Login " + inputUserName);
		
		if (cust != null) {
			// Checks entered password and tests if it is the same as the one in the
			// database
			if (cust.getPassword().equals(inputPassword)) {
				System.out.println("Password is correct!");
				
				LoggerSingelton.getLottger().info("Successful Login " + inputUserName);
				
				CustomerStartMenuBuilder.setLoggedInCustomer(cust);
				CustomerStartMenuBuilder.startMenu();
			} else {
				System.out.println("Password is incorrect.");
				StartMenuBuilder.startUpMenu();
			}

		} else {
			System.out.println("Username does not exist");
			StartMenuBuilder.startUpMenu();
		}
	}

	public static void employeeLoginMenu() {

		String inputUserName;
		String inputPassword;
		Employee empl;

		System.out.print("Please enter Username: ");
		inputUserName = ScannerSingleton.getScanner().nextLine().toLowerCase();

		System.out.print("Please enter password: ");
		inputPassword = ScannerSingleton.getScanner().nextLine();

		empl = EmployeeDao.getByUsername(inputUserName);
		
		LoggerSingelton.getLottger().info("Attempted Login " + inputUserName);

		if (empl != null) {
			// Checks entered password and tests if it is the same as the one in the
			// database
			if (empl.getPassword().equals(inputPassword)) {
				System.out.println("Password is correct!");
				
				LoggerSingelton.getLottger().info("Successful Login " + inputUserName);
				
				EmployeeStartMenuBuilder.setLoggedInEmployee(empl);
				EmployeeStartMenuBuilder.startMenuEmployeeSelector();
			} else {
				System.out.println("Password is incorrect.");
				StartMenuBuilder.startUpMenu();
			}

		} else {
			System.out.println("Username does not exist");
			StartMenuBuilder.startUpMenu();
		}
	}

}
