package com.revature;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.revature.models.Employee;
import com.revature.models.Item;
import com.revature.services.EmployeeServices;
import com.revature.services.EmployeeStartMenuBuilder;

public class EmployeeServicesTest {

	@Test
	public void testCreateEmployee() {
		
		Employee emp = new Employee("Kim Baker", "kbaker", "password", false);
		
		assertEquals(1, EmployeeServices.createEmployee(emp), 0);
	}

	@Test
	public void testRemoveEmployee() {
		
		assertEquals(1, EmployeeServices.removeEmployee(3), 0);
	}
	
	@Test
	public void testInsertAcceptedOffer() {
		EmployeeStartMenuBuilder.setLoggedInEmployee(new Employee(3,"John Baker", "Jbaker", "password", true));
		
		assertEquals(1, EmployeeServices.insertAcceptedOffer(1), 0);
	}
	
	@Test
	public void testRemoveOffer() {
		EmployeeStartMenuBuilder.setLoggedInEmployee(new Employee(3,"John Baker", "Jbaker", "password", true));
		
		assertEquals(1, EmployeeServices.removeOffer(2), 0);
	}
	
	@Test
	public void testRemoveItem() {
		EmployeeStartMenuBuilder.setLoggedInEmployee(new Employee(3,"John Baker", "Jbaker", "password", true));
		
		assertEquals(1, EmployeeServices.removeItem(1), 0);
	}
	
	@Test
	public void testUpdateItem() {
		EmployeeStartMenuBuilder.setLoggedInEmployee(new Employee(3,"John Baker", "Jbaker", "password", true));
		Item ite = new Item(1, "test", "test description", new BigDecimal(5));
		
		assertEquals(1, EmployeeServices.updateItem(ite), 0);
	}
	
	@Test
	public void testAddItem() {
		EmployeeStartMenuBuilder.setLoggedInEmployee(new Employee(3,"John Baker", "Jbaker", "password", true));
		Item ite = new Item(2, "test2", "test description 2", new BigDecimal(10.50));
		
		assertEquals(1, EmployeeServices.addItem(ite), 0);
	}
}
