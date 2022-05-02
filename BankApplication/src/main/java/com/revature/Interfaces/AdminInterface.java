package com.revature.Interfaces;

import java.util.ArrayList;

import com.revature.models.CustomersModel;

public interface AdminInterface {

	public ArrayList<CustomersModel> getallCustomersAdmin();
	
	public void updateAdmin(String accountUsername, double accountBal);
	
	public void jointApproval(String accountUsername, String jointApprov);
}
