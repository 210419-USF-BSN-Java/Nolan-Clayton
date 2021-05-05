package com.revature.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Offer;
import com.revature.util.DatabaseConnectionUtil;

public class OfferDao {

	
	public static int add(Offer off) {
		
		String sql = "insert into offers (off_price, ite_id, cust_id, off_num_weekly_payments) values (?, ?, ?, ?);";
		
		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			
			ps.setBigDecimal(1, off.getPrice());
			ps.setInt(2, off.getIteId());
			ps.setInt(3, off.getCustId());
			ps.setInt(4, off.getNumOfWeeklyPayments());
			
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
	public static int deleteByOfferId(Integer offId) {
		String sql = "delete from offers where off_id = ?;";
		
		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			
			
			ps.setInt(1, offId);
			ps.executeUpdate();

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public static int deleteByItemId(Integer itemId) {
		String sql = "delete from offers where ite_id = ?;";
		
		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			
			
			ps.setInt(1, itemId);
			return ps.executeUpdate();

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public static Offer getOfferById(Integer offId) {
		String sql = "select * from offers where off_id = ?;";
		Offer off = null;
		
		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, offId);
			
			ResultSet rs = ps.executeQuery();
			
			
			if (rs.next()) {
				off = new Offer(rs.getInt("off_id"), rs.getBigDecimal("off_price"), rs.getInt("ite_id"), rs.getInt("cust_id"), rs.getInt("off_num_weekly_payments"));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return off;
	}
	
	public static List<Offer> getAll(){
		
		List<Offer> offers = new ArrayList<>();
		String sql = "select * from offers;";
		
		Statement s;
		try {
			s = DatabaseConnectionUtil.getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				offers.add(new Offer(rs.getInt("off_id"), rs.getBigDecimal("off_price"), rs.getInt("ite_id"), rs.getInt("cust_id"), rs.getInt("off_num_weekly_payments")));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return offers;
		
	}
	
}
