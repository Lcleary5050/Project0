package com.revature.Interfaces;

import java.util.ArrayList;

import com.revature.models.AccountModel;

public interface AccountInterface {

	public ArrayList <AccountModel> getAccount(String accountUser);
	
	public ArrayList<AccountModel> withdrawlMoney(String accountUsername, double withdrawlAmount);
	
	public void depositMoney(String accountUsername, double depositAmount);
}
