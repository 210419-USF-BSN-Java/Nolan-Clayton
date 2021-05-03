package com.revature.util;

import java.util.Scanner;

public class ScannerSingleton {
	
	private static Scanner scanner;
	
	public static Scanner getScanner(){
		
		if(scanner != null) {
			return scanner;
		}
		else {
			scanner = new Scanner(System.in);
			return scanner;
		}
		
	}
	
	

}
