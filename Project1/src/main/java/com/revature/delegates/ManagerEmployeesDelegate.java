package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.daos.UserDao;
import com.revature.models.User;

public class ManagerEmployeesDelegate {

	private UserDao ud = new UserDao();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<User> users = ud.getAll();
		
		try (PrintWriter pw = response.getWriter()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new Jdk8Module());
			mapper.registerModule(new JavaTimeModule());
			
			pw.write(mapper.writeValueAsString(users));
		}
		
	}
}
