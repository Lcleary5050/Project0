package com.revature.DOAs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.Interfaces.CustomersInterface;
import com.revature.models.CustomersModel;

public class CustomersDAO implements CustomersInterface {

	private Connection conn = ConnectionManager.getConnection();

	public CustomersModel getUser(String custUsername, String custPassword) {
		try {
			
			String query = "SELECT * FROM Customers WHERE username = ? AND password = ?";
			PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(query);
			
			statement.setString(0, custUsername);
			statement.setString(1,custPassword);
			
			ResultSet rs = statement.executeQuery();
			
			
			if (rs.next()) {
				CustomersModel customers = new CustomersModel();
				customers.custUsername = rs.getString("username");
				customers.custPassword = rs.getString("password");
				customers.custFirstName = rs.getString("cust_Firstname");
				customers.custLastName = rs.getString("cust_Lastname");
				customers.custContact = rs.getString("cust_Contact");
				customers.adminID = rs.getInt("admin_id");
				customers.empID = rs.getInt("emp_id");
				return customers;
				
			} else return null;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

	
	public void addCustomer(CustomersModel newCustomer) {
		try {
			
		
		String query = "INSERT into Customers (cust_username, cust_password, cust_firstName, cust_lastName, cust_contact, admin_id, emp_id)"
				+ "values (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(0, newCustomer.custUsername);
		pstmt.setString(1, newCustomer.custPassword);
		pstmt.setString(2, newCustomer.custFirstName);
		pstmt.setString(3, newCustomer.custLastName);
		pstmt.setString(4, newCustomer.custContact);
		
		pstmt.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
