package com.revature.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.util.DatabaseConnectionUtil;

public class ReimbursementDao {

	private UserDao ud = new UserDao();
	private ReimbursementTypeDao rtd = new ReimbursementTypeDao();
	private ReimbursementStatusDao rsd = new ReimbursementStatusDao();
	
	public int add(Reimbursement reimb) {

		String sql = "insert into reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setBigDecimal(1, reimb.getAmount());
			ps.setObject(2, reimb.getSubmitted());
			ps.setObject(3, reimb.getResolved());
			ps.setString(4, reimb.getDescription());
			ps.setString(5, reimb.getReceipt());
			ps.setInt(6, reimb.getAuthor().getId());
			ps.setInt(7, reimb.getResolver().getId());
			ps.setInt(8, reimb.getReimbStatus().getId());
			ps.setInt(9, reimb.getReimbType().getId());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int update(Reimbursement reimb) {
		String sql = "update reimbursement set reimb_resolved = ?, reimb_resolver = ?, reimb_status_id = ? where reimb_id = ?;";
		
		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setObject(1, reimb.getResolved());
			ps.setInt(2, reimb.getResolver().getId());
			ps.setInt(3, reimb.getReimbStatus().getId());
			ps.setInt(4, reimb.getId());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;	
	}
	
	public int addForEmployee(Reimbursement reimb) {

		String sql = "insert into reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) values (?, ?, ?, ?, 1, ?);";

		try {
			PreparedStatement ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setBigDecimal(1, reimb.getAmount());
			ps.setObject(2, reimb.getSubmitted());
			ps.setString(3, reimb.getDescription());
			ps.setInt(4, reimb.getAuthor().getId());
			ps.setInt(5, reimb.getReimbType().getId());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public List<Reimbursement> getByUserIdPending(int id) {
		
		List<Reimbursement> reimbs = new ArrayList<>();
		
		
		String sql = "select * from reimbursement where reimb_author = ? AND reimb_status_id = 1;";
		PreparedStatement ps;
		try {
			ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt("reimb_id"), rs.getBigDecimal("reimb_amount"), rs.getTimestamp("reimb_submitted").toLocalDateTime(), rs.getString("reimb_description"), ud.getById(rs.getInt("reimb_author")), rtd.getById(rs.getInt("reimb_type_id"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reimbs;
		
	}
	
	public List<Reimbursement> getByUserIdResolved(int id) {
		
		List<Reimbursement> reimbs = new ArrayList<>();
		
		
		String sql = "select * from reimbursement where (reimb_author = ? AND reimb_status_id = 2) or (reimb_status_id = 3);";
		PreparedStatement ps;
		try {
			ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt("reimb_id"), rs.getBigDecimal("reimb_amount"), rs.getTimestamp("reimb_submitted").toLocalDateTime(), rs.getTimestamp("reimb_resolved").toLocalDateTime(), rs.getString("reimb_description"), "", ud.getById(rs.getInt("reimb_author")), ud.getById(rs.getInt("reimb_resolver")), rsd.getById(rs.getInt("reimb_status_id")), rtd.getById(rs.getInt("reimb_type_id"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reimbs;
		
	}
	
	public List<Reimbursement> getByUserId(int id) {
		
		List<Reimbursement> reimbs = new ArrayList<>();
		
		
		String sql = "select * from reimbursement where reimb_author = ?;";
		PreparedStatement ps;
		try {
			ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt("reimb_id"), rs.getBigDecimal("reimb_amount"), rs.getTimestamp("reimb_submitted").toLocalDateTime(), rs.getString("reimb_description"), ud.getById(rs.getInt("reimb_author")), rtd.getById(rs.getInt("reimb_type_id"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reimbs;
		
	}
	
	public Reimbursement getById(int id) {
		
		
		String sql = "select * from reimbursement where reimb_id = ?;";
		PreparedStatement ps;
		try {
			ps = DatabaseConnectionUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Reimbursement(rs.getInt("reimb_id"), rs.getBigDecimal("reimb_amount"), rs.getTimestamp("reimb_submitted").toLocalDateTime(), rs.getString("reimb_description"), ud.getById(rs.getInt("reimb_author")), rtd.getById(rs.getInt("reimb_type_id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}
	
	public List<Reimbursement> getAllPending() {
		
		List<Reimbursement> reimbs = new ArrayList<>();
		
		
		String sql = "select * from reimbursement where reimb_status_id = 1;";
		try {
			Statement s = DatabaseConnectionUtil.getConnection().createStatement();
			
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt("reimb_id"), rs.getBigDecimal("reimb_amount"), rs.getTimestamp("reimb_submitted").toLocalDateTime(), rs.getString("reimb_description"), ud.getById(rs.getInt("reimb_author")), rtd.getById(rs.getInt("reimb_type_id"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reimbs;
		
	}
	
	public List<Reimbursement> getAllResolved() {
		
		List<Reimbursement> reimbs = new ArrayList<>();
		
		
		String sql = "select * from reimbursement where reimb_status_id = 2 OR reimb_status_id = 3;";
		try {
			Statement s = DatabaseConnectionUtil.getConnection().createStatement();
			
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt("reimb_id"), rs.getBigDecimal("reimb_amount"), rs.getTimestamp("reimb_submitted").toLocalDateTime(), rs.getTimestamp("reimb_resolved").toLocalDateTime(), rs.getString("reimb_description"), "", ud.getById(rs.getInt("reimb_author")), ud.getById(rs.getInt("reimb_resolver")), rsd.getById(rs.getInt("reimb_status_id")), rtd.getById(rs.getInt("reimb_type_id"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reimbs;
		
	}

}
