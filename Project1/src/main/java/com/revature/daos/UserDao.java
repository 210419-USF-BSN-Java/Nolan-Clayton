package com.revature.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.User;
import com.revature.util.DatabaseConnectionUtil;

public class UserDao {

	private UserRoleDao urd = new UserRoleDao();

	public int add(User user) {

		String sql = "insert into users (user_username, user_password, user_first_name, user_last_name, user_email, user_role_id) values (?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getId());

			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int update(User user) {
		
		String sql = "update users set user_username = ?, user_password = ?, user_first_name = ?, user_last_name = ?, user_email = ? , user_role_id = ? where user_id = ?;";
		
		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getRole().getId());
			ps.setInt(7, user.getId());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}

	public User getById(int id) {

		User user = null;
		String sql = "select * from users where user_id = ?;";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return user = new User(rs.getInt("user_id"), rs.getString("user_username"),
						rs.getString("user_password"), rs.getString("user_first_name"), rs.getString("user_last_name"),
						rs.getString("user_email"), urd.getById(rs.getInt("user_role_id")));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;

	}

	public User getByUsername(String username) {

		User user = null;
		String sql = "select * from users where user_username = ?;";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return user = new User(rs.getInt("user_id"), rs.getString("user_username"),
						rs.getString("user_password"), rs.getString("user_first_name"), rs.getString("user_last_name"),
						rs.getString("user_email"), urd.getById(rs.getInt("user_role_id")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;

	}
	
	public List<User> getAll() {

		List<User> users = new ArrayList<>();
		
		
		String sql = "select * from users where user_role_id = 1;";

		try {
			Statement s = DatabaseConnectionUtil.getConnection().createStatement();
			
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {

				users.add(new User(rs.getInt("user_id"), rs.getString("user_username"), rs.getString("user_password"), rs.getString("user_first_name"), rs.getString("user_last_name"), rs.getString("user_email"), urd.getById(rs.getInt("user_role_id"))));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;

	}

}
