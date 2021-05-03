package com.revature.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Employee;
import com.revature.util.DatabaseConnectionUtil;

public class EmployeeDao {

	public static int add(Employee empl) {

		String sql = "insert into employees (empl_name, empl_user_name, empl_user_pass, empl_is_manager) values (?, ?, ?, ?)";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);

			ps.setString(1, empl.getName());
			ps.setString(2, empl.getUserName().toLowerCase());
			ps.setString(3, empl.getPassword());
			ps.setBoolean(4, empl.getManFlag());

			return ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;

	}

	public static Employee getByUsername(String userName) {

		String sql = "select * from employees where empl_user_name = ?;";
		Employee empl = null;

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);

			ps.setString(1, userName);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return empl = new Employee(rs.getInt("empl_id"), rs.getString("empl_name"),
						rs.getString("empl_user_name"), rs.getString("empl_user_pass"),
						rs.getBoolean("empl_is_manager"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empl;
	}

}
