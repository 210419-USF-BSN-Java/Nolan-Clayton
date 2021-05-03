package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUtil {
	
	private static Connection c;

	public static Connection getConnection() throws SQLException
	{

		String url = System.getenv("DB_URL");
		String username = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");

		if(c == null || c.isClosed()) {
		c = DriverManager.getConnection(url, username, password);
		}
		
		return c;
	}
	
}
