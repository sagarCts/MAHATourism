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
 * Servlet implementation class Edit2
 */
public class Edit2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String sid=request.getParameter("id");
	        int id=Integer.parseInt(sid);
	        String firstname=request.getParameter("First_Name");  
	        String lastname=request.getParameter("Last_Name");
	        String emailid=request.getParameter("Email_id");
	        String mobilenumber=request.getParameter("Mobile_Number");
	        String country=request.getParameter("Country");
	        String state=request.getParameter("State");
	        String city=request.getParameter("City");
	          
	        Customer c =new Customer();  
	        c.setId(id);
	        c.setFirst_name(firstname);
	        c.setLast_name(lastname);
	        c.setEmail_id(emailid);
	        c.setMobile_number(mobilenumber);
	        c.setCountry(country);
	        c.setState(state);
	        c.setCity(city);
	         
	        int status=0;
			try {
				status = CustomerDAO.update(c);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        if(status>0){  
	            response.sendRedirect("View");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	        out.close();  
	}

}
