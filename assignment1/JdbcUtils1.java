package practice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils1
{
	public static Connection buildConnection() throws Exception
	{
		  // Class.forName() is not required because Driver get Loaded Automatically.
		  // once its JAR file is found in project's build path.
		  String connectionUrl = "jdbc:mysql://localhost:3306/cdac";
		  String username = "root";
		  String password = "password";
		  Connection dbConnection= DriverManager.getConnection(connectionUrl, username, password);
		  return dbConnection;
	}
	
	

}
