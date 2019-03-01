<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="CustomerEntity.Customer,Repository.CustomerDAO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Customers</title>
</head>
<body>

	<%
		List<Customer> list = CustomerDAO.getAllCustomer();
		request.setAttribute("list", list);
	%>
	<h2>Customer List</h2>
	<table border="1" width="90%">
		<tr>
			<th>Customer Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Id</th>
			<th>Mobile Number</th>
			<th>Country</th>
			<th>State</th>
			<th>City</th>
			<th>User Name</th>
			<th>Password</th>
			<th>Edit</th>
		</tr>
		<c:forEach items="${list}" var="cus">
			<tr>
				<td>${cus.getId()}</td>
				<td>${cus.getFirst_Name()}</td>
				<td>${cus.getLast_Name()}</td>
				<td>${cus.getEmail_id()}</td>
				<td>${cus.getMobile_number()}</td>
				<td>${cus.getCountry()}</td>
				<td>${cus.getState() }</td>
				<td>${cus.getCity() }</td>
				<td>${cus.getUser_name() }</td>
				<td>${cus.getPassword() }</td>
				<td><a href="deleteuser.jsp?id=${cus.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>