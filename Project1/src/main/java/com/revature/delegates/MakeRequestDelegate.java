package com.revature.delegates;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementTypeDao;
import com.revature.daos.UserDao;
import com.revature.models.Reimbursement;




public class MakeRequestDelegate {

	private ReimbursementDao rd = new ReimbursementDao();
	private UserDao ud = new UserDao();
	private ReimbursementTypeDao rtd = new ReimbursementTypeDao();
	
	public void submitRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userID = request.getParameter("user");
		String amount = request.getParameter("amount");
		String description = request.getParameter("description");
		String type = request.getParameter("type");
		LocalDateTime currentTime = LocalDateTime.now();
		
		System.out.println(userID);
		System.out.println(amount);
		System.out.println(description);
		System.out.println(type);
		System.out.println(currentTime);
		
		Reimbursement reim = new Reimbursement(0, BigDecimal.valueOf(Double.parseDouble(amount)), currentTime, description, ud.getById(Integer.parseInt(userID)), rtd.getById(Integer.parseInt(type)));
		rd.addForEmployee(reim);
		

	}


	
}
