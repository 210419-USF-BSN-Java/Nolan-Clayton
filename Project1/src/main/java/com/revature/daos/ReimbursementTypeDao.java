package com.revature.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.ReimbursementType;
import com.revature.util.DatabaseConnectionUtil;

public class ReimbursementTypeDao {

	public ReimbursementType getById(Integer id) {
		
		String sql = "select * from reimbursement_type where reimb_type_id = ?;";
		ReimbursementType type = null;
		
		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return type = new ReimbursementType(rs.getInt("reimb_type_id"), rs.getString("reimb_type"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return type;
	}
	
}
