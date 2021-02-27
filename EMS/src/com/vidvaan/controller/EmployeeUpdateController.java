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
 * Servlet implementation class EmployeeUpdateController
 */
public class EmployeeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eid= Integer.parseInt(request.getParameter("eid"));
		EmployeeService employeeService = new EmployeeServiceImpl();
		Employee employee = employeeService.findById(eid);
		request.setAttribute("employee", employee);
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EmployeeUpdateController Post Method Called");
		int eid = Integer.parseInt(request.getParameter("eid"));
		String ename = request.getParameter("ename");
		double esal = Double.parseDouble(request.getParameter("esal"));
		Employee employee = new Employee(eid, ename, esal);
		EmployeeService employeeService = new EmployeeServiceImpl();
		employeeService.update(employee);
		request.setAttribute("msg", "Record Updated Successfully");
		RequestDispatcher rd = request.getRequestDispatcher("/FindAllEmployeeController");
		rd.forward(request, response);

	}

}
