package com.vidvaan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vidvaan.model.Employee;
import com.vidvaan.service.EmployeeService;
import com.vidvaan.service.EmployeeServiceImpl;

/**
 * Servlet implementation class FindAllEmployeeController
 */
public class FindAllEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		EmployeeService employeeService = new EmployeeServiceImpl();
		List<Employee> employees = employeeService.findAll();
		request.setAttribute("employees", employees);
		RequestDispatcher rd = request.getRequestDispatcher("findAll.jsp");
		rd.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	

}
