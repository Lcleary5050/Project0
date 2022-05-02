package revature.BankApplication;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.API.CustomerController;
import com.revature.DOAs.AccountDAO;
import com.revature.DOAs.AdminDAO;
import com.revature.DOAs.CustomersDAO;
import com.revature.DOAs.EmployeesDAO;
import com.revature.models.AccountModel;
import com.revature.models.AdminModel;
import com.revature.models.CustomersModel;

import io.javalin.Javalin;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	
    	Javalin app = Javalin.create().start(7070);
    	CustomerController custcontroller = new CustomerController(app);
        
    	Scanner sc = new Scanner(System.in);
    	boolean loggedIn = false;
    	boolean isCustomer = false;
    	
    	while(true) {
    		
    		//main menu for deciding which path to take
    		System.out.println("Welcome to Metropolis Bank\n");
    		System.out.println("Please choose from the list below:");
    		System.out.println("1.Sign up (new user)");
    		System.out.println("2.Sign into account(existing user)");
    		System.out.println("3.Log in as employee");
    		System.out.println("4.Log in as admin");
    		System.out.println("5.Exit");
    		
    		try {
    			int option = Integer.parseInt(sc.nextLine());
    			
    			switch(option) {
    			
    			//new user, pass input info into new user method, log them in but wont display much
    			case 1:
    				System.out.println("Thank you for choosing to bank with Metroplois");
    				System.out.println("\nPlease enter a new username: ");
    				String enteredUsername = sc.nextLine();
    				
    				System.out.println("\nPlease enter a new password:");
    				String enteredPassword = sc.nextLine();
    				
    				System.out.println("Please enter first name:");
    				String enteredFirstName = sc.nextLine();
    				
    				System.out.println("Please enter lastname name:");
    				String enteredLastName = sc.nextLine();
    				
    				System.out.println("Please enter phone number: (xxx)xxx-xxxx format");
    				String enteredContact = sc.nextLine();
    				
    				System.out.println("Please enter 001 to verify you ar not a robot:");
    				int enteredAdminID = Integer.parseInt(sc.nextLine());
    				
    				System.out.println("Please enter 001 to verify you ar not a robot (again):");
    				int enteredEmpID = Integer.parseInt(sc.nextLine());
    				
    				
    				System.out.println("Thank you, your account is pending. Please call 555-6333 for any questions.");
    				
    				// pass this into the create user method with info.
    				
    				
    				loggedIn = true;
    				isCustomer = true;
    				break;
    			
    			/*user log in case 
    			 * 
    			 * 
    			 */
    			
    			case 2:
    				if (!loggedIn) {
    					System.out.println("Please enter username");
    					enteredUsername = sc.nextLine();
    				}
    				
    				System.out.println("Please enter password:");
    				enteredPassword = sc.nextLine();
    				//if username/password is correct display that user where they match 
    				System.out.println("Please enter username again to display account information.");
    				String enteredAccount = sc.nextLine();
    				// display account where username matches username 
    				
    				//change balance/ apply for joint account
    				
    				loggedIn = true;
    				isCustomer = true;
    				
    				
    				break;
    				
    			/* employee log in case 
    			 * 
    			 * 
    			 */
    			case 3:
    				if (!loggedIn) {
    					System.out.println("Please enter Employee username:");
    					String employeeUsername = sc.nextLine();
    				}
    				
    				System.out.println("Please enter Employee password:");
    				String employeePassword = sc.nextLine();
    				
    				EmployeesDAO employeeDAO = new EmployeesDAO();
    				ArrayList<CustomersModel> employee = employeeDAO.getallCustomersEmp();
    				
    				for (CustomersModel i: employee) {
    					System.out.println(i);
    				}
    				
    				System.out.println("Please choose from one of the option below");
    				System.out.println("1.View Account information");
    				System.out.println("2.Log out");
    				
    				int empOption = sc.nextInt();
    				if (empOption == 1) {
    					System.out.println("Please enter username of account you would like to view:");
    					
    					String enteredCustUsername = sc.nextLine();
    					
    					AccountDAO accountDAO = new AccountDAO();
    					ArrayList<AccountModel> empAccountView =  accountDAO.getAccount(enteredCustUsername);
    				}
    				
    				else if (empOption == 2) {
    					System.out.println("Thank you valued employee. You have sucessfully logged out");
    					System.exit(0);
    				}
    				else {
    					System.out.println("Please enter a valid option.");
    				}
    				break;
    			
    				
    				/* Admin log in case
    				 * 
    				 * 
    				 */
    				
    			case 4:
    				if (!loggedIn) {
    					System.out.println("Please enter Admin username:");
    					String adminUsername = sc.nextLine();
    				}
    				
    				System.out.println("Please enter Admin password:");
    				String adminassword = sc.nextLine();
    				
    				AdminDAO adminDAO = new AdminDAO();
    				ArrayList<CustomersModel> admin = adminDAO.getallCustomersAdmin();
    				
    				for (CustomersModel i: admin) {
    					System.out.println(i);
    				}
    				
    				System.out.println("Please choose from one of the option below");
    				System.out.println("1.View Account information");
    				System.out.println("2.Edit Account  balance");
    				System.out.println("3.Approve/Deny accounts, or joint accounts");
    				System.out.println("4.Log out");
    				
    				int adminOption = sc.nextInt();
    				if (adminOption == 1) {
    					System.out.println("Please enter username of account you would like to view:");
    					
    					String enteredCustUsername = sc.nextLine();
    					
    					AccountDAO accountDAO = new AccountDAO();
    					ArrayList<AccountModel> adminAccountView =  accountDAO.getAccount(enteredCustUsername);
    				}
    				
    				else if (adminOption == 2) {
    					System.out.println("Please enter username of account you would like to update:");
    					String enterUsername = sc.nextLine();
    					System.out.println("\nPlease enter updated balance");
    					double enterBalance = sc.nextDouble();
    					
    					//AdminDAO adminsDAO = new AdminDAO();
    					//AdminModel adminAccountBal = adminsDAO.updateAdmin(enterUsername, enterBalance);
    				}
    				else if (adminOption == 3) {
    					
    					System.out.println("Please enter username of account you would like to approver/deny:");
    					
    				}
    				else if (adminOption == 4) {
    					System.exit(0);
    				}
    				else {
    					System.out.println("Please enter a vaild option");
    				}
    				
    				break;
    				
    				
    				/* exit program case
    				 * 
    				 * 
    				 */
    				
    			case 5:
    				System.out.println("Thank you for banking with Metropolis. Goodbye");
    				System.exit(0);
    				break;
    			default:	
    				break;
    			}
    		} catch (NumberFormatException e) {
    			
    		}
    	}
    }
}