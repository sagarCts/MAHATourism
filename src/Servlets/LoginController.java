package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import CustomerEntity.Customer;
import Repository.CustomerDAO;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Welcome to Maharashtra Tourism</title></head></html>");
		String un = request.getParameter("username");
		String pw = request.getParameter("password");

		request.getRequestDispatcher("link.html").include(request, response);
		
		if (un.equalsIgnoreCase("admin"))
		{
			if (pw.equalsIgnoreCase("admin")) {
				RequestDispatcher rd = request.getRequestDispatcher("AdminLogin");
				rd.forward(request, response);
			}
		}
		if (un.equalsIgnoreCase(request.getParameter("username"))) {
			Customer c = new Customer();
			c.setUser_name(un);
			c.setPassword(pw);
			int status = 0;

			try {
				status = CustomerDAO.login(c);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (status > 0) {
				out.println(
						"<!DOCTYPE html><html><body onload='myFunction()'><script>function myFunction() {alert('You have been Successfully logged IN!');}</script></body></html>");
				request.getRequestDispatcher("Home.jsp").include(request, response);
				Cookie ck=new Cookie("name",un);  
	            response.addCookie(ck);
			} else {
				out.println(
						"<!DOCTYPE html><html><body onload='myFunction()'><script>function myFunction() {alert('Sorry Username password Invalid!');}</script></body></html>");
				request.getRequestDispatcher("Login.jsp").include(request, response);

			}
			out.close();
		}
	}

}
