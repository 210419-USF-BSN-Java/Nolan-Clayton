package com.revature.services;

import com.revature.daos.CustomerDao;
import com.revature.models.Customer;

public class CustomerServices {

	public static Integer registerCustomer(Customer cust) {
		
		return CustomerDao.add(cust);
		
	}
	
	
}
