package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.models.Customer;
import com.revature.services.CustomerServices;
import com.revature.services.CustomerStartMenuBuilder;

public class CustomerServicesTest {

	@Test
	public void testRegisterCustomer() {
		
		Customer cust = new Customer("John Baker", "Jbaker", "password");
		
		assertEquals(1, CustomerServices.registerCustomer(cust), 0);
	}
	
	@Test
	public void testAddPayment() {
		CustomerStartMenuBuilder.setLoggedInCustomer(new Customer(3,"John Baker", "Jbaker", "password"));
		
		assertEquals(1, CustomerServices.addPayment(6), 0);
	}
	
}
