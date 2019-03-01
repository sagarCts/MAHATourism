package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CustomerEntity.Customer;
import Repository.CustomerDAO;

/**
 * Servlet implementation class Edit
 */
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Customer</h1>");
		String sid = request.getParameter("id");
		int id=Integer.parseInt(sid);

		Customer c = null;
		try {
			c = CustomerDAO.getCustomerById(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.print("<form action='Edit2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+c.getId()+"'/></td></tr>");
		out.print("<tr><td>First Name:</td><td><input type='text' name='First_Name' value='" + c.getFirst_name()
				+ "'/></td></tr>");
		out.print("<tr><td>Last Name:</td><td><input type='text' name='Last_Name' value='" + c.getLast_name()
				+ "'/></td></tr>");
		out.print("<tr><td>Email ID:</td><td><input type='email' name='Email_id' value='" + c.getEmail_id()
				+ "'/></td></tr>");
		out.print("<tr><td>Mobile Number:</td><td><input type='number' name='Mobile_Number' value='"
				+ c.getMobile_number() + "'/></td></tr>");
		out.print("<tr><td>Country:</td><td><input type='text' name='Country' value='" + c.getCountry() + "'/></td>");
		out.print("<tr><td>State:</td><td><input type='text' name='State' value='" + c.getState() + "'/></td>");
		out.print("<tr><td>City:</td><td><input type='text' name='City' value='" + c.getCity() + "'/></td>");
		out.print("<tr><td></td><td><input type='hidden' name='User_Name' value='" + c.getUser_name()
				+ "'/></td>");
		
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
