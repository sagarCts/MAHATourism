package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerProfile
 */
public class CustomerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        request.getRequestDispatcher("link.html").include(request, response);  
	          
	        Cookie ck[]=request.getCookies();  
	        if(ck!=null){  
	         String name=ck[0].getValue();  
	        if(!name.equals("")||name!=null){  
	        	out.println(
						"<!DOCTYPE html><html><body onload='myFunction()'><script>function myFunction() {alert('Welcome to Your Profile!');}</script></body></html>");
	            out.println("<br>Welcome, "+name);
	            out.println("<a href='UserView?id=?'>Edit Profile</a>");
	            
	           
	        }  
	        }else{  
	        	out.println(
						"<!DOCTYPE html><html><body onload='myFunction()'><script>function myFunction() {alert('Please login first!');}</script></body></html>"); 
	            request.getRequestDispatcher("login.jsp").include(request, response);  
	        }  
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
