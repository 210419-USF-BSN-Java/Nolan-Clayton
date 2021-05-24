package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDao;
import com.revature.models.User;

public class ProfileDelegate {

	private UserDao userDao = new UserDao();
	
	public void getProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String path = request.getServletPath();
		Integer userID = Integer.parseInt(path.substring(9));
		User u = userDao.getById(userID);
		
		try (PrintWriter pw = response.getWriter()) {
			pw.write(new ObjectMapper().writeValueAsString(u));
		}
	}
	
	
}
