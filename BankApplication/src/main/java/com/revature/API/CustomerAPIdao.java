package com.revature.API;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.DOAs.ConnectionManager;
import com.revature.models.CustomersModel;

public class CustomerAPIdao implements CustomerAPIinterface<CustomersModel, String> {

	private Connection conn = ConnectionManager.getConnection();

	@Override
	public void create(CustomersModel element) {
		
		try {
			PreparedStatement statement = conn.prepareStatement("INSERT INTO Customers VALUES(?,?,?,?,?,?,?)");
			
			statement.setString(1, element.custUsername);
			statement.setString(2, element.custPassword);
			statement.setString(3, element.custFirstName);
			statement.setString(4, element.custLastName);
			statement.setString(5, element.custContact);
			statement.setInt(6, element.adminID);
			statement.setInt(7, element.empID);
			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		
	}

	@Override
	public CustomersModel get(String custUsername) {
		
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM Customers WHERE cust_username = ?");
			statement.setString(1, custUsername);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				CustomersModel c = new CustomersModel();
				c.custUsername = custUsername;
				c.custPassword = rs.getString("cust_password");
				c.custFirstName = rs.getString("cust_firstname");
				c.custLastName = rs.getString("cust_lastname");
				c.custContact = rs.getString("cust_contact");
				c.adminID = rs.getInt("admin_id");
				c.empID = rs.getInt("emp_id");
				
				return c;
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public void update(CustomersModel element) {
		
		try {
			PreparedStatement statement = conn.prepareStatement("UPDATE Customers SET cust_password = ?, cust_firstname = ?, cust_lastname = ?, cust_contact = ?, admin_id = ?, emp_id = ? WHERE cust_username = ?");
			
			statement.setString(1, element.custPassword);
			statement.setString(2, element.custFirstName);
			statement.setString(3, element.custLastName);
			statement.setString(4, element.custContact);
			statement.setInt(5, element.adminID);
			statement.setInt(6, element.empID);
			statement.setString(7, element.custUsername);
			
			statement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(CustomersModel element) {
		try {
			PreparedStatement statement = conn.prepareStatement("DELETE FROM Customers WHERE cust_username = ?");
			
			statement.setString(1,  element.custUsername);
			
			statement.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
