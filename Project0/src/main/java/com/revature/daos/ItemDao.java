package com.revature.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Item;
import com.revature.util.DatabaseConnectionUtil;

public class ItemDao {

	public static int add(Item ite) {

		String sql = "insert into items (ite_name, ite_description, ite_estimated_val, ite_weekly_pay) values (?, ?, ?, ?);";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);

			ps.setString(1, ite.getItemName());
			ps.setString(2, ite.getItemDescription());
			ps.setBigDecimal(3, ite.getItemEstimatedValue());
			ps.setBigDecimal(4, ite.getweeklyPay());

			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	public static int update(Item ite) {

		String sql = "update items set ite_name = ?, ite_description = ?, ite_estimated_val = ?, ite_weekly_pay = ? where ite_id = ?;";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);

			ps.setString(1, ite.getItemName());
			ps.setString(2, ite.getItemDescription());
			ps.setBigDecimal(3, ite.getItemEstimatedValue());
			ps.setBigDecimal(4, ite.getweeklyPay());
			ps.setInt(5, ite.getId());

			return ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	public static int updateRemainingPayments(Item ite) {

		String sql = "update items set ite_remaining_payments = ? where ite_id = ?;";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);

			ps.setInt(1, ite.getRemainingPayments());
			ps.setInt(2, ite.getId());


			return ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}
	
	
	public static int updateOwner(Item ite) {

		String sql = "update items set cust_id = ?, ite_weekly_pay = ?, ite_price = ?, ite_remaining_payments = ? where ite_id = ?;";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);

			ps.setInt(1, ite.getOwnerId());
			ps.setBigDecimal(2, ite.getweeklyPay());
			ps.setBigDecimal(3, ite.getPrice());
			ps.setInt(4, ite.getRemainingPayments());
			ps.setInt(5, ite.getId());


			return ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}
	
	
	public static int deleteById(Integer itemID) {

		String sql = "delete from items where ite_id = ?;";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);

			ps.setInt(1, itemID);
			
			return ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	public static List<Item> getAllAvailable() {

		List<Item> items = new ArrayList<>();
		String sql = "select * from items where cust_id is NULL;";

		try {

			Statement s = DatabaseConnectionUtil.getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {

				items.add(new Item(rs.getInt("ite_id"), rs.getString("ite_name"), rs.getString("ite_description"),
						rs.getBigDecimal("ite_estimated_val"), rs.getInt("cust_id"), rs.getBigDecimal("ite_weekly_pay"),
						rs.getBigDecimal("ite_price"), rs.getInt("ite_remaining_payments")));
			}

			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return items;

	}
	
	
	public static List<Item> getOwnedItems(Integer id) {

		List<Item> items = new ArrayList<>();
		String sql = "select * from items where cust_id = ?;";

		try {

			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				items.add(new Item(rs.getInt("ite_id"), rs.getString("ite_name"), rs.getString("ite_description"),
						rs.getBigDecimal("ite_estimated_val"), rs.getInt("cust_id"), rs.getBigDecimal("ite_weekly_pay"),
						rs.getBigDecimal("ite_price"), rs.getInt("ite_remaining_payments")));
			}

			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return items;

	}
	

	public static List<Item> getAll() {

		List<Item> items = new ArrayList<>();
		String sql = "select * from items;";

		try {

			Statement s = DatabaseConnectionUtil.getConnection().createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				items.add(new Item(rs.getInt("ite_id"), rs.getString("ite_name"), rs.getString("ite_description"),
						rs.getBigDecimal("ite_estimated_val"), rs.getInt("cust_id"), rs.getBigDecimal("ite_weekly_pay"),
						rs.getBigDecimal("ite_price"), rs.getInt("ite_remaining_payments")));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return items;

	}

	public static Item getById(Integer id) {

		String sql = "select * from items where ite_id = ?;";
		Item ite = null;

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				ite = new Item(rs.getInt("ite_id"), rs.getString("ite_name"), rs.getString("ite_description"),
						rs.getBigDecimal("ite_estimated_val"), rs.getInt("cust_id"), rs.getBigDecimal("ite_weekly_pay"),
						rs.getBigDecimal("ite_price"), rs.getInt("ite_remaining_payments"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return ite;

	}

}
