package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	protected static Connection initializeDatabase()
	        throws SQLException, ClassNotFoundException
	    {
	        // Initialize all the information regarding
	        // Database Connection
	        String dbDriver = "com.mysql.cj.jdbc.Driver";
	        String dbURL = "jdbc:mysql://localhost:3306/";
	        // Database name to access
	        String dbName = "storydb";
	        String dbUsername = "root";
	        String dbPassword = "Songvibame1/";
	  
	        Class.forName(dbDriver);
	        Connection con = DriverManager.getConnection(dbURL + dbName,
	                                                     dbUsername, 
	                                                     dbPassword);
	        return con;
	    }
	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		try {
			System.out.println(new ConnectionClass().initializeDatabase());
		}
		catch(Exception e) {
			
		}
	}
	
	
}
