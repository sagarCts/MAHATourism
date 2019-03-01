package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CustomerEntity.Customer;
import Repository.CustomerDAO;

/**
 * Servlet implementation class UserView
 */
public class UserView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		out.println("<h1>Edit Profile</h1>");
		List<Customer> list = null;
		try {
			String sid=request.getParameter("id");
			int id=Integer.parseInt(sid);
			list = CustomerDAO.getCustomerByid(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("<table border='1' width='100%'>");
		out.print(
				"<tr><th>Customer ID</th><th>First Name</th><th>Last Name</th><th>Email Id</th><th>Mobile Number</th><th>Country</th><th>State</th><th>City</th><th>User Name</th><th>Password</th><th>Edit></th><th>Delete</th></tr>");
		for (Customer c : list) {
			out.print("<tr><td>" + c.getId() + "</td><td>" + c.getFirst_name() + "</td><td>" + c.getLast_name()
					+ "</td><td>" + c.getEmail_id() + "</td><td>" + c.getMobile_number() + "</td><td>" + c.getCountry()
					+ "</td><td>" + c.getState() + "</td><td>" + c.getCity() + "</td><td>" + c.getUser_name()
					+ "</td><td>" + c.getPassword() + "</td><td><a href='Edit?id=" + c.getId()
					+ "'>edit</a></td><td><a href='Deleteuser?id=" + c.getId() + "'>Delete</a></td></tr>");

		}
		out.print("</table>");
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
