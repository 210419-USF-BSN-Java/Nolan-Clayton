package com.revature.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Customer;
import com.revature.util.DatabaseConnectionUtil;

public class CustomerDao {

	public static int add(Customer cust) {

		String sql = "insert into customers (cust_name, cust_user_name, cust_user_pass) values (?, ?, ?);";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);

			ps.setString(1, cust.getName());
			ps.setString(2, cust.getUserName().toLowerCase());
			ps.setString(3, cust.getPassword());

			return ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	public static Customer getByUsername(String userName) {

		String sql = "select * from customers where cust_user_name = ?;";
		Customer cust = null;

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);

			ps.setString(1, userName.toLowerCase());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return cust = new Customer(rs.getInt("cust_id"), rs.getString("cust_name"),
						rs.getString("cust_user_name"), rs.getString("cust_user_pass"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cust;
	}

}
