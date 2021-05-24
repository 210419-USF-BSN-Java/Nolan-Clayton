package com.revature.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.UserRole;
import com.revature.util.DatabaseConnectionUtil;

public class UserRoleDao {

	public UserRole getById(Integer id) {
		
		String sql = "select * from user_roles where user_role_id = ?;";
		UserRole role = null;
		
		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return role = new UserRole(rs.getInt("user_role_id"), rs.getString("user_role"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return role;
	}
	
}
