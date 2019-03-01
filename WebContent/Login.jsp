<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<img src="F:\java niit\CRUD operation\MAHATourism\images\mah.png"
	align="middle" alt="Maharashtra Tourism" height="60" width="60">
<br>
<a href="HomePage.html">Home</a>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login To Maharashtra Tourism</title>
</head>
<body>
	<form action="LoginController;" method="post">
		<table>
			<tr>
				<td><label><b>Username</b></label></td>
				<td><input type="text" placeholder="Username" name="username"
					required></td>
			</tr>

			<tr>
				<td><label><b>Password</b></label></td>
				<td><input type="password" placeholder="Password"
					name="password" required></td>
			</tr>

			<tr>
				<td><button type="submit">Login</button>
		</table>
	</form>
	<h3>
		Don't Have Accoun?<a href="Registration.html">Register Here</a>
	</h3><br><br><br><br><br><br><br>
	<footer>
	<center>
		<small>&copy; A project by Animesh Amruta Sagar Bakhteyar
			AASB.co 2019,All Rights Reserved</small>
	</center>
	</footer>

</body>
</html>