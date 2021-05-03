package com.revature.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.Offer;
import com.revature.util.DatabaseConnectionUtil;

public class OfferDao {

	
	public static int add(Offer off) {
		
		String sql = "insert into offers (off_price, ite_id, cust_id) values (?, ?, ?);";
		
		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			
			ps.setBigDecimal(1, off.getPrice());
			ps.setInt(2, off.getIteId());
			ps.setInt(3, off.getCustId());
			
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
	public static int deleteByItemId(Integer itemId) {
		String sql = "update offers set ite_id = ?, cust_id = ? where ite_id = ?;";
		String sql1 = "delete from offers where ite_id is NULL;";
		
		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			PreparedStatement ps1 = DatabaseConnectionUtil.getConnection().prepareStatement(sql1);
			
			
			ps.setInt(1, itemId);
			ps.executeUpdate();
			ps1.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
}
