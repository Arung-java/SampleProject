<%@page import="com.vidvaan.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>Bootstrap Example</title>
<style type="text/css">
.success {
	text-align: center;
	color: green;
	font-size: 20px;
}
</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h3>All Employees</h3>
		<a href="./EmployeeInsertController" class="btn btn-primary">New
			Employee</a>
		<hr>
		<%
			if (request.getAttribute("msg") != null) {
		%>
		<span class="success"><%=request.getAttribute("msg")%></span>
		<%
			}
		%>
		<table class="table">
			<tr>
				<th>Eid</th>
				<th>Ename</th>
				<th>Esal</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<%
				List<Employee> employees = (List<Employee>) request.getAttribute("employees");
				for (Employee emp : employees) {
			%>
			<tr>
				<td><%=emp.getEid()%></td>
				<td><%=emp.getEname()%></td>
				<td><%=emp.getEsal()%></td>
				<td><a href="./EmployeeUpdateController?eid=<%=emp.getEid()%>">Edit</a></td>
				<td><a href="./EmployeeDeleteController?eid=<%=emp.getEid()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>