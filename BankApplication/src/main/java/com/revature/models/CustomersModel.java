package com.revature.models;

public class CustomersModel {

	public String custUsername;
	public String custPassword;
	public String custFirstName;
	public String custLastName;
	public String custContact;
	public int adminID;
	public int empID;
	
	
	public CustomersModel(String cust_username, String cust_password, String cust_firstName, String cust_lastName, String cust_contact, int admin_id, int emp_id) {
		this.custUsername = cust_username;
		this.custPassword = cust_password;
		this.custFirstName = cust_firstName;
		this.custLastName = cust_lastName;
		this.custContact = cust_contact;
		this.adminID = admin_id;
		this.empID = emp_id;
	}

	public CustomersModel(String cust_username, String cust_firstName, String cust_lastName, String cust_contact) {
		this.custUsername = cust_username;
		this.custFirstName = cust_firstName;
		this.custLastName = cust_lastName;
		this.custContact = cust_contact;
	}

	@Override
	public String toString() {
		return "CustomersModel [custUsername=" + custUsername + ", custPassword=" + custPassword + ", custFirstName="
				+ custFirstName + ", custLastName=" + custLastName + ", custContact=" + custContact + ", adminID="
				+ adminID + ", empID=" + empID + "]";
	}
	
	public CustomersModel() {
		
	}
	
}
