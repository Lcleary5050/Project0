package com.revature.models;

public class EmployeesModel {

	
	public int empID;
	public String empUsername;
	public String empPassword;
	public String empName;
	
	public EmployeesModel(int EmployeeID, String emp_username, String emp_password, String emp_name) {
		this.empID = EmployeeID;
		this.empUsername = emp_username;
		this.empPassword = emp_password;
		this.empName = emp_name;
	}

	
	
	@Override
	public String toString() {
		return "EmployeesModel [empID=" + empID + ", empUsername=" + empUsername + ", empPassword=" + empPassword
				+ ", empName=" + empName + "]";
	}



	public EmployeesModel() {
		
	}
}

