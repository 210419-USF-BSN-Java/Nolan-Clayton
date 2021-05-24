package com.revature.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.ReimbursementStatus;
import com.revature.util.DatabaseConnectionUtil;

public class ReimbursementStatusDao {

	public int add(ReimbursementStatus stat) {
		
		String sql = "insert into reimbursement_status (reimb_status) values (?);";
		
		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setString(1, stat.getStatus());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	public ReimbursementStatus getById(Integer id) {
		
		String sql = "select * from reimbursement_status where reimb_status_id = ?;";
		ReimbursementStatus stat = null;
		
		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				return stat = new ReimbursementStatus(rs.getInt("reimb_status_id"), rs.getString("reimb_status"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stat;
	}
	
}
