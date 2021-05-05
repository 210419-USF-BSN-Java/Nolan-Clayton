package com.revature.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Payment;
import com.revature.util.DatabaseConnectionUtil;

public class PaymentDao {

	
	public static int add(Payment pay) {
		
		String sql = "insert into payments (pay_time_stamp, ite_id, pay_value) values (?, ?, ?);";
		
		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setObject(1, pay.getTimeStamp());
			ps.setInt(2, pay.getItem().getId());
			ps.setBigDecimal(3, pay.getPayValue());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static List<Payment> getAll() {
		
		List<Payment> payments = new ArrayList<>();
		String sql = "select * from payments;";
		
		try {
			Statement s = DatabaseConnectionUtil.getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				payments.add(new Payment(rs.getInt("pay_id"), rs.getTimestamp("pay_time_stamp").toLocalDateTime(), ItemDao.getById(rs.getInt("ite_id")), rs.getBigDecimal("pay_value")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return payments;
		
	}
	
	
}
