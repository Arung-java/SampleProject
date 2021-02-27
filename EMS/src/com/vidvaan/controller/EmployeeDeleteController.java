package com.vidvaan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vidvaan.model.Employee;
import com.vidvaan.service.EmployeeService;
import com.vidvaan.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeDeleteController
 */
public class EmployeeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int eid = Integer.parseInt(request.getParameter("eid"));
		EmployeeService employeeService = new EmployeeServiceImpl();
		employeeService.delete(eid);
		request.setAttribute("msg", "Record Deleted Successfully");
		RequestDispatcher rd = request.getRequestDispatcher("/FindAllEmployeeController");
		rd.forward(request, response);
	}

}
