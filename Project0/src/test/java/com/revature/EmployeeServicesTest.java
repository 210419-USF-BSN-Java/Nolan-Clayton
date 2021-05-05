package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.models.Employee;
import com.revature.services.EmployeeServices;

public class EmployeeServicesTest {

	@Test
	public void testCreateEmployee() {
		
		Employee emp = new Employee("Kim Baker", "kbaker", "password", false);
		assertEquals(1, EmployeeServices.createEmployee(emp), 0);
	}

}
