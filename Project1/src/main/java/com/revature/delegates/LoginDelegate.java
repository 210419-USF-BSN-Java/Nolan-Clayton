package com.revature.delegates;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class LoginDelegate {

	private UserDao userDao = new UserDao();

	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User u = userDao.getByUsername(username);

		if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
			String token = u.getId() + ":" + u.getRole().getId();
			response.setStatus(200);
			response.setHeader("Authorization", token);
		} else {
			response.sendError(401);
		}
	}

	public boolean isAuthorized(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization");
		// check to see if there is an auth header
		if (authToken != null) {
			String[] tokenArr = authToken.split(":");
			// if the token is formatted the way we expect, we can take the id from it and
			// query for that user
			if (tokenArr.length == 2) {
				String idStr = tokenArr[0];
				String userRoleStr = tokenArr[1];

				// check to see if there is a valid user and if that user is the appropriate
				// role in their token
				User u = userDao.getById(Integer.parseInt(idStr));
				if (u != null && u.getRole().equals(userRoleStr)) {
					return true;
				}

			}
		}
		return false;
	}

}
