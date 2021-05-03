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

		String sql = "insert into items (ite_name, ite_description, ite_estimated_val, ite_remaining_bal, cust_id) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);

			ps.setString(1, ite.getItemName());
			ps.setString(2, ite.getItemDescription());
			ps.setFloat(3, ite.getItemEstimatedValue());
			ps.setFloat(4, ite.getRemainingBalance());
			ps.setInt(5, ite.getOwnerId());

			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;

	}

	public static int update(Item ite) {

		String sql = "update items set ite_name = ?, ite_description = ?, ite_estimated_val = ?, ite_remaining_bal = ?, cust_id = ? where ite_id = ?;";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);

			ps.setString(1, ite.getItemName());
			ps.setString(2, ite.getItemDescription());
			ps.setFloat(3, ite.getItemEstimatedValue());
			ps.setFloat(4, ite.getRemainingBalance());
			ps.setInt(5, ite.getOwnerId());
			ps.setInt(6, ite.getId());

			return ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;
	}

	public static int delete(Item ite) {

		String sql = "delete from items where ite_id = ?;";
		// String sql1 = "update items set cust_id = NULL where ite_id = ?;";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);

			ps.setInt(1, ite.getId());

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
						rs.getFloat("ite_estimated_val"), rs.getInt("cust_id"), rs.getFloat("ite_remaining_bal"),
						rs.getFloat("ite_price"), rs.getInt("ite_remaining_payments")));
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
						rs.getFloat("ite_estimated_val"), rs.getInt("cust_id"), rs.getFloat("ite_remaining_bal"),
						rs.getFloat("ite_price"), rs.getInt("ite_remaining_payments")));
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

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return ite;

	}

}
