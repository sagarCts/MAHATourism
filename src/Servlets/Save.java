package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CustomerEntity.Customer;
import Repository.CustomerDAO;

/**
 * Servlet implementation class Save
 */
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Save() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String first_name=request.getParameter("First_Name");
        String last_name=request.getParameter("Last_Name");
        String email_id=request.getParameter("Email_id");
        String  mobile_number=request.getParameter("Mobile_Number");
        String country=request.getParameter("Country");
        String state=request.getParameter("State");
        String city=request.getParameter("City");
        String user_name=request.getParameter("User_Name");
        String password=request.getParameter("Password");
        
        Customer c= new Customer();
        c.setFirst_name(first_name);
        c.setLast_name(last_name);
        c.setEmail_id(email_id);
        c.setMobile_number(mobile_number);
        c.setCountry(country);
        c.setState(state);
        c.setCity(city);
        c.setUser_name(user_name);
        c.setPassword(password);
        int status = 0;
        
        	try {
				status = CustomerDAO.save(c);
				request.getRequestDispatcher("Login.jsp").include(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
          if(status>0)
          {
        	  out.println(
						"<!DOCTYPE html><html><body onload='myFunction()'><script>function myFunction() {alert('You have been Successfully Registered!');}</script></body></html>");
        	  request.getRequestDispatcher("Login.html").include(request, response);
          }
          else
          {
        	  out.println("Sorry! unable to save record");
          }
          out.close();  
	}


	}


