package SoftwareManagement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DCon {
	Connection conn;
	String user="lab";
	String pass="cse301";
	
	
	public DCon() {
		//JOptionPane.showMessageDialog(null, "Welcome to Airline Database System");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle JDBC Driver Registered!");
		} catch (ClassNotFoundException e) {
			System.err.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
		}
		//JOptionPane.showMessageDialog(null, "Oracle JDBC Driver Registered!");

		
		

	}
	
	public Connection getConnection(){
		Connection conn=null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost",
					user, pass);	
			System.out.println("Database Connection Successful");
		} catch (SQLException e) {
			System.err.println("Database Connection Failed!");
			e.printStackTrace();
		}
		return conn;
		
	}
	


}
