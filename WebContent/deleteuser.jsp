<%@ page import="Repository.CustomerDAO" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="cus" class="CustomerEntity.Customer"></jsp:useBean>
    <jsp:setProperty property="*" name="c"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Successfull</title>
</head>
<body>
<% CustomerDAO.deleteuser(cus);
	response.sendRedirect("View");
	%>
</body>
</html>