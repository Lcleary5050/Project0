package com.revature.models;

public class AccountModel {

	public int accountNumber;
	public double accountBalance;
	public String approval;
	public int jointID;
	public String accountUsername;
	
	public AccountModel(int Account_num, double balance, String approval, int joint_id, String custUsername) {
		this.accountNumber = Account_num;
		this.accountBalance = balance;
		this.approval = approval;
		this.jointID = joint_id;
		this.accountUsername = custUsername;
	}
}
