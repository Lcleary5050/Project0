package com.revature.DOAs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection connection;
	
	private static String connectionString = "jdbc:postgresql://heffalump.db.elephantsql.com:5432/mwybraie",
			username = "mwybraie",
			password = "aJGTjfK6S7JiBhd57QcuvI4SsaRiUmC3";
	
	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(connectionString, username, password);
				
			}
			
			return connection;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
