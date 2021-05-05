package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.models.Customer;
import com.revature.services.CustomerServices;

public class CustomerServicesTest {

	@Test
	public void testRegisterCustomer() {
		
		Customer cust = new Customer("John Baker", "Jbaker", "password");
		assertEquals(1, CustomerServices.registerCustomer(cust), 0);
	}
}
