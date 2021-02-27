<!DOCTYPE html>
<%@page import="com.vidvaan.model.Employee"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Update Employee</h3>
	<hr>
	<%Employee employee = (Employee)request.getAttribute("employee"); %>
	<form action="./EmployeeUpdateController" method="post">
		<table>
			<tr>
				<td>EID</td>
				<td><input type="text" name="eid" value="<%=employee.getEid()%>" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>ENAME</td>
				<td><input type="text" name="ename" value="<%=employee.getEname()%>"/></td>
			</tr>
			<tr>
				<td>ESAL</td>
				<td><input type="text" name="esal" value="<%=employee.getEsal()%>"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>