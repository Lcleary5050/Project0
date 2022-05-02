package com.revature.API;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.DOAs.ConnectionManager;
import com.revature.models.AccountModel;

public class AccountsAPIdao implements CustomerAPIinterface<AccountModel, String> {

	private Connection conn = ConnectionManager.getConnection();

	@Override
	public void create(AccountModel element) {
		
		try {
			PreparedStatement statement = conn.prepareStatement("INSERT INTO Account VALUES(?,?,?,?,?)");
			
			statement.setInt(1, element.accountNumber);
			statement.setDouble(2, element.accountBalance);
			statement.setString(3, element.approval);
			statement.setInt(4, element.jointID);
			statement.setString(5, element.accountUsername);
			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		
	}

	@Override
	public AccountModel get(String accountUsername) {
		
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM Account WHERE custUsername = ?");
			statement.setString(1, accountUsername);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				AccountModel a = new AccountModel(0, 0, accountUsername, 0, accountUsername);
				a.accountUsername = rs.getString("custUsername");
				a.accountBalance = rs.getDouble("account_balance");
				a.approval = rs.getString("approval");
				a.jointID = rs.getInt("joint_id");
				a.accountUsername = rs.getString("Account_num");
				
				
				return a;
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public void update(AccountModel element) {
		
		try {
			PreparedStatement statement = conn.prepareStatement("UPDATE Account SET Account_num = ?, account_balance = ?, approval = ?, joint_id = ?, custUsername = ? WHERE custUsername = ?");
			
			statement.setInt(1, element.accountNumber);
			statement.setDouble(2, element.accountBalance);
			statement.setString(3, element.approval);
			statement.setInt(4, element.jointID);
			statement.setString(5, element.accountUsername);

			
			statement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(AccountModel element) {
		try {
			PreparedStatement statement = conn.prepareStatement("DELETE FROM Account WHERE custUsername = ?");
			
			statement.setString(1,  element.accountUsername);
			
			statement.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
} 
