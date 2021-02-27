 package com.vidvaan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vidvaan.model.Employee;
import com.vidvaan.service.EmployeeService;
import com.vidvaan.service.EmployeeServiceImpl;

/**
 * Servlet implementation class FindByIdEmpController
 */
public class FindByIdEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int eid = Integer.parseInt(request.getParameter("eid"));
		EmployeeService employeeService = new EmployeeServiceImpl();
		Employee employee = employeeService.findById(eid);
		if (employee != null) {
			out.println("<h2>Employee Details Are </h2>");
			out.println("----------------------------- ");
			out.println("<br>EID : " + employee.getEid());
			out.println("<br>ENAME : " + employee.getEname());
			out.println("<br>ESAL : " + employee.getEsal());
			out.println("<br>-----------------------------");
		} else {
			out.println("<h2>No Records found</h2>");
		}
		out.println("<br><a href='home.html'>Go to Home </a>");

	}

}
