package com.revature.delegates;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementStatusDao;
import com.revature.daos.UserDao;
import com.revature.models.Reimbursement;

public class ManagerAcceptDelegate {

private ReimbursementDao rd = new ReimbursementDao();
private UserDao ud = new UserDao();
private ReimbursementStatusDao rsd = new ReimbursementStatusDao();
	
	public void acceptRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String userID = request.getParameter("user");
		String requestId = request.getParameter("requestId");


		Reimbursement reimb = rd.getById(Integer.parseInt(requestId));
		reimb.setResolved(LocalDateTime.now());
		reimb.setResolver(ud.getById(Integer.parseInt(userID)));
		reimb.setReimbStatus(rsd.getById(3));
		
		rd.update(reimb);

	}
	
}
