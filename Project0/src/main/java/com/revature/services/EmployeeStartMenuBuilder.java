package com.revature.services;


import com.revature.models.Employee;
import com.revature.util.ScannerSingleton;

public class EmployeeStartMenuBuilder {

	private static Employee loggedInEmployee;
	
	// Used to know which employee is currently logged in
	public static void setLoggedInEmployee(Employee emp) {
		loggedInEmployee = emp;
	}
	
	
	public static void startMenuEmployeeSelector() {
		
		//Selects which menu to use the regular employee or the manager menu
		if(loggedInEmployee.getManFlag()) {
			EmployeeStartMenuBuilder.startMenuManager();
			
		} else {
			EmployeeStartMenuBuilder.startMenuEmployeeRegular();
			
		}
		
	}
	
	public static void startMenuEmployeeRegular() {
		
		Integer selection = 0;

		while (selection < 1 || selection > 8) {

			System.out.println("Welcome " + loggedInEmployee.getName());
			System.out.println("1) View all items");
			System.out.println("2) Add item");
			System.out.println("3) Edit item by Id");
			System.out.println("4) Delete item by Id");
			System.out.println("5) View all offers");
			System.out.println("6) Accept/Reject offer by offer Id");
			System.out.println("7) View all payments");
			System.out.println("8) Exit\n");

			System.out.print("Select: ");
			selection = Integer.parseInt(ScannerSingleton.getScanner().nextLine());

		}
	}
	
	
	
	public static void startMenuManager() {
		
		Integer selection = 0;

		while (selection < 1 || selection > 8) {

			System.out.println("Welcome " + loggedInEmployee.getName());
			System.out.println("1) View all items");
			System.out.println("2) Add item");
			System.out.println("3) Edit item by Id");
			System.out.println("4) Delete item by Id");
			System.out.println("5) View all offers");
			System.out.println("6) Accept/Reject offer by offer Id");
			System.out.println("7) View all payments");
			System.out.println("8) Exit\n");

			System.out.print("Select: ");
			selection = Integer.parseInt(ScannerSingleton.getScanner().nextLine());

		}
	}
	
	
}
