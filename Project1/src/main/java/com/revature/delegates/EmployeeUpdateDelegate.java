package com.revature.delegates;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class EmployeeUpdateDelegate {

	private UserDao ud = new UserDao();
	
	public void updateProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String userID = request.getParameter("userId");
		
		String newUsername = request.getParameter("username");
		String newPassword = request.getParameter("password");
		String newFirstName = request.getParameter("firstname");
		String newLastName = request.getParameter("lastname");
		String newEmail = request.getParameter("email");
		
		
		User user = ud.getById(Integer.parseInt(userID));
		
		user.setUsername(newUsername);
		user.setPassword(newPassword);
		user.setFirstName(newFirstName);
		user.setLastName(newLastName);
		user.setLastName(newLastName);
		user.setEmail(newEmail);
		
		ud.update(user);
		
	}
}
