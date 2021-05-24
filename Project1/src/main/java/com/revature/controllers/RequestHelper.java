package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.EmployeeResolvedDelegate;
import com.revature.delegates.EmployeeUpdateDelegate;
import com.revature.delegates.EmpoyeePendingDelegate;
import com.revature.delegates.LoginDelegate;
import com.revature.delegates.MakeRequestDelegate;
import com.revature.delegates.ManagerAcceptDelegate;
import com.revature.delegates.ManagerEmployeesDelegate;
import com.revature.delegates.ManagerPendingDelegate;
import com.revature.delegates.ManagerRejectDelegate;
import com.revature.delegates.ManagerResolvedDelegate;
import com.revature.delegates.ManagerViewEmployeeDelegate;
import com.revature.delegates.ProfileDelegate;
import com.revature.util.LoggerSingelton;

public class RequestHelper {

	private LoginDelegate ld = new LoginDelegate();
	private ProfileDelegate pd = new ProfileDelegate();
	private MakeRequestDelegate mrd = new MakeRequestDelegate();
	private EmpoyeePendingDelegate epd = new EmpoyeePendingDelegate();
	private ManagerPendingDelegate mpd = new ManagerPendingDelegate();
	private ManagerAcceptDelegate mad = new ManagerAcceptDelegate();
	private ManagerRejectDelegate mred = new ManagerRejectDelegate();
	private ManagerResolvedDelegate mresd = new ManagerResolvedDelegate();
	private ManagerEmployeesDelegate med = new ManagerEmployeesDelegate();
	private ManagerViewEmployeeDelegate mved = new ManagerViewEmployeeDelegate();
	private EmployeeResolvedDelegate erd = new EmployeeResolvedDelegate();
	private EmployeeUpdateDelegate eud = new EmployeeUpdateDelegate();
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		StringBuilder uriString = new StringBuilder(request.getRequestURI());

		uriString.replace(0, request.getContextPath().length() + 1, "");


		if (uriString.indexOf("/") != -1) {
			request.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1));
			
			
			uriString.replace(uriString.indexOf("/"), uriString.length(), "");
			
		}


		LoggerSingelton.getLottger().info("Hey");
		
		String path = request.getServletPath();
		if(path.equals("/login")) {
			ld.authenticate(request, response);
		} else if (path.startsWith("/profile")) {
			pd.getProfile(request, response);
		} else if(path.equals("/makeRequest")) {
			mrd.submitRequest(request, response);
		} else if (path.startsWith("/employeePending")) {
			epd.getPending(request, response);
		} else if(path.equals("/managerPending")) {
			mpd.getPending(request, response);
		} else if(path.equals("/managerAccept")) {
			mad.acceptRequest(request, response);
		} else if(path.equals("/managerReject")) {
			mred.rejectRequest(request, response);
		} else if(path.equals("/managerResolved")) {
			mresd.getResolved(request, response);
		} else if(path.equals("/managerEmployees")) {
			med.getEmployees(request, response);
		} else if(path.startsWith("/managerViewEmployee")) {
			mved.getEmployee(request, response);
		} else if(path.startsWith("/employeeResolved")) {
			erd.getResolved(request, response);
		} else if(path.equals("/employeeUpdate")) {
			eud.updateProfile(request, response);
		} else {
			response.sendError(404, "Path not supported");
		}

	}
	
}
