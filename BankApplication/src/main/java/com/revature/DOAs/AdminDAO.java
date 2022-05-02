package com.revature.DOAs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.Interfaces.AdminInterface;
import com.revature.models.AdminModel;
import com.revature.models.CustomersModel;

public class AdminDAO implements AdminInterface {
	
	private Connection conn = ConnectionManager.getConnection();

	public ArrayList<CustomersModel> getallCustomersAdmin() {
		try {
			Statement statement = conn.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT * FROM Customers");
			ArrayList<CustomersModel> customers = new ArrayList<CustomersModel>();
			
			while (rs.next()) {
				String custUsername = rs.getString("cust_username");
				String custPassword = rs.getString("cust_password");
				String custFirstName = rs.getString("cust_firstName");
				String custLastName = rs.getString("cust_lastName");
				String custContact = rs.getString("cust_contact");
				int adminID = rs.getInt("admin_id");
				int empID = rs.getInt("emp_id");
				
				customers.add(new CustomersModel(custUsername, custPassword, custFirstName, custLastName, custContact, adminID, empID));
			} return customers;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} return null;
	}
		
		public void updateAdmin(String accountUsername, double accountBal) {
			
			try {
				String query = "UPDATE Accounts SET balance = ? WHERE custUsername = ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				
				pstmt.setDouble(1, accountBal);
				pstmt.setString(2, accountUsername);
				
				pstmt.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void jointApproval(String accountUsername, String jointApprov) {
			try {
				String query = "UPDATE Accounts SET approval = ?  WHERE custUsername = ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, jointApprov);
				pstmt.setString(2,  accountUsername);
				
				pstmt.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
