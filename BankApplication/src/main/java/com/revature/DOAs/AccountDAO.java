package com.revature.DOAs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.Interfaces.AccountInterface;
import com.revature.models.AccountModel;

public class AccountDAO implements AccountInterface {
	
	private Connection conn = ConnectionManager.getConnection();
	
public ArrayList <AccountModel> getAccount(String accountUser) {
		
		try {
			String query = "Select * FROM Accounts WHERE custUsername = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, accountUser);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				ArrayList<AccountModel> accounts = new ArrayList<AccountModel>();
				int accountNumber = rs.getInt("Account_num");
				double accountBalance = rs.getDouble("balance");
				String approval = rs.getString("approval");
				int jointID = rs.getInt("joint_id");
				String accountUsername = rs.getString("custUsername");
				
				accounts.add(new AccountModel(accountNumber, accountBalance, approval, jointID, accountUsername));
				return accounts;
			} 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		} 
	
	public void withdrawlMoney(String accountUsername, double withdrawlAmount) {
		
		try {
			String query = "UPDATE Accounts SET balance = balance - ? WHERE custUsername = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setDouble(1, withdrawlAmount);
			pstmt.setString(2, accountUsername);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
		public void depositMoney(String accountUsername, double depositAmount) {
			
			try {
				String query = "UPDATE Accounts SET balance = balance + ? WHERE custUsername = ?";
				PreparedStatement pstmt = conn.prepareStatement(query);
				
				pstmt.setDouble(1, depositAmount);
				pstmt.setString(2, accountUsername);
				
				pstmt.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
