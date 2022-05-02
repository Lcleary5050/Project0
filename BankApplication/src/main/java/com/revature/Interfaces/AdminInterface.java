package com.revature.Interfaces;

import java.util.ArrayList;

import com.revature.models.AdminModel;
import com.revature.models.CustomersModel;

public interface AdminInterface {

	public ArrayList<CustomersModel> getallCustomersAdmin();
	
	public AdminModel updateAdmin(String accountUsername, double accountBal);
	
	public AdminModel jointApproval(String accountUsername, String jointApprov);
}
