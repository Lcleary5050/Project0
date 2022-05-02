package com.revature.API;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.DOAs.ConnectionManager;
import com.revature.models.EmployeesModel;

public class EmployeesAPIdao implements CustomerAPIinterface<EmployeesModel, String> {

		private Connection conn = ConnectionManager.getConnection();

		public void create(EmployeesModel element) {
			
			try {
				PreparedStatement statement = conn.prepareStatement("INSERT INTO Employees VALUES(?,?,?,?)");
				
				statement.setInt(1, element.empID);
				statement.setString(2, element.empUsername);
				statement.setString(3, element.empPassword);
				statement.setString(4, element.empName);
				
			} catch (SQLException e ) {
				e.printStackTrace();
			}
			
		}

		public EmployeesModel get(String empUsername) {
			
			try {
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM Employees WHERE emp_username = ?");
				statement.setString(1, empUsername);
				ResultSet rs = statement.executeQuery();
				
				if(rs.next()) {
					EmployeesModel e = new EmployeesModel(0, empUsername, empUsername, empUsername);
					e.empID = rs.getInt("emp_id");
					e.empUsername = rs.getString("emp_username");
					e.empPassword = rs.getString("emp_password");
					e.empName = rs.getString("emp_name");
		
					
					
					return e;
				}
			} catch (Exception e) {
				
			}
			return null;
		}

		public void update(EmployeesModel element) {
			
			try {
				PreparedStatement statement = conn.prepareStatement("UPDATE Employees SET emp_id = ?, emp_username = ?, emp_password = ?, emp_name = ? WHERE emp_username = ?");
				
				statement.setInt(1, element.empID);
				statement.setString(2, element.empUsername);
				statement.setString(3, element.empPassword);
				statement.setString(4, element.empName);

				
				statement.executeQuery();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public void delete(EmployeesModel element) {
			try {
				PreparedStatement statement = conn.prepareStatement("DELETE FROM Employees WHERE emp_username = ?");
				
				statement.setString(1,  element.empUsername);
				
				statement.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}
