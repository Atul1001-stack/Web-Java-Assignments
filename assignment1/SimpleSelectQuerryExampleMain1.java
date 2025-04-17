package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSelectQuerryExampleMain1 
{
	public static void main(String[] args) 
	{
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		Connection dbConnection = null;
		Statement stmt = null;
		ResultSet rs= null;
		try 
		{
			// Step 1 Load The Driver
			Class.forName(driverClassName);
			System.out.println("Driver Loaded.");
		
		
		
		    // Step 2
		    // Establish Connection To Database
		   
		    String connectionUrl = "jdbc:mysql://localhost:3306/cdac";
		    String username = "root";
		    String password = "password";
		    dbConnection= DriverManager.getConnection(connectionUrl, username, password);
			System.out.println("Connection Established.");
			
			//Step 3: Obtain some Statement. 
			
			stmt= dbConnection.createStatement();
			
			//Step 4: Execute SQL Query
			
			String sqlQuery = "select roll, name, city from stud";
			rs= stmt.executeQuery(sqlQuery);
			
			// Step 5: Perform navigation on ResultSet
			while(rs.next())
			{
				int roll = rs.getInt(1);
				String name= rs.getString(2);
				String city= rs.getString(3);
				System.out.println(roll + " " +name + " " + city);
				
			}
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		finally
		{
			try {
				rs.close();
				stmt.close();
				dbConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
