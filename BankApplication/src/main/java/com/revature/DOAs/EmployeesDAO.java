package com.revature.DOAs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.Interfaces.EmployeesInterface;
import com.revature.models.CustomersModel;

public class EmployeesDAO implements EmployeesInterface {
	
	private Connection conn = ConnectionManager.getConnection();

	public ArrayList<CustomersModel> getallCustomersEmp() {
		try {
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT cust_username, cust_firstName, cust_lastName, cust_contact FROM Customers");
			ArrayList<CustomersModel> customers = new ArrayList<CustomersModel>();
			
			while (rs.next()) {
				String custUsername = rs.getString("cust_username");
				//String custPassword = rs.getString("cust_password");
				String custFirstName = rs.getString("cust_firstName");
				String custLastName = rs.getString("cust_lastName");
				String custContact = rs.getString("cust_contact");
				//int adminID = rs.getInt("admin_id");
				//int empID = rs.getInt("emp_id");
				
				customers.add(new CustomersModel(custUsername, custFirstName, custLastName, custContact));
			} return customers;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} return null;
	}

}
