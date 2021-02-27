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
 * Servlet implementation class EmployeeInsertController
 */
public class EmployeeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		rd.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("EmployeeInsertController Post Method Called");
		//int eid = Integer.parseInt(request.getParameter("eid"));
		String ename = request.getParameter("ename");
		double esal = Double.parseDouble(request.getParameter("esal"));
		Employee employee = new Employee();
		employee.setEname(ename);
		employee.setEsal(esal);
		EmployeeService employeeService = new EmployeeServiceImpl();
		employeeService.insert(employee);
		request.setAttribute("msg", "New Record Inserted Successfully");
		RequestDispatcher rd = request.getRequestDispatcher("/FindAllEmployeeController");
		rd.forward(request, response);
		

	}

}
