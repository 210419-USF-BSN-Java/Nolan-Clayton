package com.revature.services;

import java.time.LocalDateTime;

import com.revature.daos.CustomerDao;
import com.revature.daos.ItemDao;
import com.revature.daos.PaymentDao;
import com.revature.models.Customer;
import com.revature.models.Item;
import com.revature.models.Payment;
import com.revature.util.LoggerSingelton;

public class CustomerServices {

	public static Integer registerCustomer(Customer cust) {
		
		LoggerSingelton.getLottger().info("New Customer Registration Name = " + cust.getName() + " UserName = " + cust.getUserName());
		
		return CustomerDao.add(cust);
		
	}
	
	public static Integer addPayment(Integer itemId) {
		
		Item ite = ItemDao.getById(itemId);
		if(ite.getOwnerId() == CustomerStartMenuBuilder.getLoggedInCustomer().getId() && ite.getRemainingPayments() > 0) {
			ite.setRemainingPayments(ite.getRemainingPayments() - 1);
			ItemDao.updateRemainingPayments(ite);
			
			LoggerSingelton.getLottger().info(CustomerStartMenuBuilder.getLoggedInCustomer().getUserName() + " made a payment for item id = " + itemId + " payed = " + ite.getweeklyPay() + " remaining payments =" + (ite.getRemainingPayments()));
			
			return PaymentDao.add(new Payment(LocalDateTime.now(), ite, ite.getweeklyPay()));
			
		}
		return 0;
	}
	
}
