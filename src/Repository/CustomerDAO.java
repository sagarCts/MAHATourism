package Repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import CustomerEntity.Customer;
import utility.DatabaseConnect;

public class CustomerDAO {

	static Connection dbConnection = null;

	public CustomerDAO() throws ClassNotFoundException, SQLException, IOException {

	}

	public static int save(Customer c) throws ClassNotFoundException, SQLException, IOException {
		dbConnection = DatabaseConnect.connect();

		int status = 0;
		try {

			PreparedStatement ps = dbConnection.prepareStatement(
					"insert into customer_registration(First_Name,Last_Name,Email_id,Mobile_Number,Country,State,City,UserName,Password) values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, c.getFirst_name());
			ps.setString(2, c.getLast_name());
			ps.setString(3, c.getEmail_id());
			ps.setString(4, c.getMobile_number());
			ps.setString(5, c.getCountry());
			ps.setString(6, c.getState());
			ps.setString(7, c.getCity());
			ps.setString(8, c.getUser_name());
			ps.setString(9, c.getPassword());

			status = ps.executeUpdate();
			System.out.println("rows inserted");
			dbConnection.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int login(Customer c) throws ClassNotFoundException, SQLException, IOException {
		dbConnection = DatabaseConnect.connect();
		int status = 0;
		try {
			PreparedStatement ps = dbConnection.prepareStatement(
					"select UserName,Password from customer_registration where UserName=? and Password=?");
			ps.setString(1, c.getUser_name());
			ps.setString(2, c.getPassword());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				status = 1;
				System.out.println("You have been successfully Logged in");
			}
			dbConnection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;

	}

	public static int update(Customer c) throws ClassNotFoundException, SQLException, IOException {
		int status = 0;
		dbConnection = DatabaseConnect.connect();

		PreparedStatement ps = dbConnection.prepareStatement(
				"update customer_registration set first_name=? , last_name=?,email_id=?, mobile_number=?,country=?,state=?,city=? where id=?");
		ps.setString(1, c.getFirst_name());
		ps.setString(2, c.getLast_name());
		ps.setString(3, c.getEmail_id());
		ps.setString(4, c.getMobile_number());
		ps.setString(5, c.getCountry());
		ps.setString(6, c.getState());
		ps.setString(7, c.getCity());
		ps.setInt(8,c.getId());
		

		status = ps.executeUpdate();
		dbConnection.close();
		return status;

	}
public static List<Customer> getCustomerByid(int id) throws ClassNotFoundException, SQLException, IOException
{
	dbConnection = DatabaseConnect.connect();
	List<Customer> list = new ArrayList<Customer>();
	try {
		PreparedStatement ps = dbConnection.prepareStatement("select * from customer_registration where id=?");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Customer c = new Customer();
			c.setId(rs.getInt(1));
			c.setFirst_name(rs.getString(2));
			c.setLast_name(rs.getString(3));
			c.setEmail_id(rs.getString(4));
			c.setMobile_number(rs.getString(5));
			c.setCountry(rs.getString(6));
			c.setCity(rs.getString(7));
			c.setState(rs.getString(8));
			c.setUser_name(rs.getString(9));
			c.setPassword(rs.getString(10));
			list.add(c);
		}
		dbConnection.close();
	} catch (Exception ex) {
		ex.printStackTrace();
	}

	return list;

	
}
	public static Customer getCustomerById(int id)
			throws ClassNotFoundException, SQLException, IOException {
		dbConnection = DatabaseConnect.connect();
		Customer c = new Customer();
		try {
			PreparedStatement ps = dbConnection
					.prepareStatement("select * from customer_registration where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c.setId(rs.getInt(1));
				c.setFirst_name(rs.getString(2));
				c.setLast_name(rs.getString(3));
				c.setEmail_id(rs.getString(4));
				c.setMobile_number(rs.getString(5));
				c.setCountry(rs.getString(6));
				c.setState(rs.getString(7));
				c.setCity(rs.getString(8));
			}
			dbConnection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return c;

	}

	public static List<Customer> getAllCustomer() throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		dbConnection = DatabaseConnect.connect();
		List<Customer> list = new ArrayList<Customer>();
		try {
			PreparedStatement ps = dbConnection.prepareStatement("select * from customer_registration");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt(1));
				c.setFirst_name(rs.getString(2));
				c.setLast_name(rs.getString(3));
				c.setEmail_id(rs.getString(4));
				c.setMobile_number(rs.getString(5));
				c.setCountry(rs.getString(6));
				c.setCity(rs.getString(7));
				c.setState(rs.getString(8));
				c.setUser_name(rs.getString(9));
				c.setPassword(rs.getString(10));
				list.add(c);
			}
			dbConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static int delete(int id)
	{
		int status=0;
		try{
			dbConnection = DatabaseConnect.connect();
			PreparedStatement ps=dbConnection.prepareStatement("delete from customer_registration where id=?");
		    ps.setInt(1,id);  
			status=ps.executeUpdate();
			dbConnection.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	
	public static int deleteuser(Customer c)
	{
		 int status=0;  
		    try{  
		    	dbConnection = DatabaseConnect.connect();  
		        PreparedStatement ps=dbConnection.prepareStatement("delete from register where id=?");  
		        ps.setInt(1,c.getId());  
		        status=ps.executeUpdate();  
		    }catch(Exception e){System.out.println(e);}  
		  
		    return status; 
		
	}
}
