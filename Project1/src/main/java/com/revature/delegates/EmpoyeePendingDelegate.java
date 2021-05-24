package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.daos.ReimbursementDao;
import com.revature.models.Reimbursement;
import com.revature.util.LoggerSingelton;


public class EmpoyeePendingDelegate {

	private ReimbursementDao rd = new ReimbursementDao();
	
	public void getPending(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		String path = request.getServletPath();
		Integer userID = Integer.parseInt(path.substring(17));

		LoggerSingelton.getLottger().info("UserId " + userID + "viewed pending requests");
		
		List<Reimbursement> reimbs = rd.getByUserIdPending(userID);
		
		try (PrintWriter pw = response.getWriter()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new Jdk8Module());
			mapper.registerModule(new JavaTimeModule());
			
			pw.write(mapper.writeValueAsString(reimbs));
		}
		
	}
}
