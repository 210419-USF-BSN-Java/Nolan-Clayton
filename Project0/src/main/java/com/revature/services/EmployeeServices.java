package com.revature.services;

import com.revature.daos.EmployeeDao;
import com.revature.models.Employee;

public class EmployeeServices {

	public static Integer createEmployee(Employee emp) {

		return EmployeeDao.add(emp);

	}

}
