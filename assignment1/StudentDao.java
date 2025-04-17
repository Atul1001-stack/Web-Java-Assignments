package practice.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import example.jdbc.Department;
import example.jdbc.JdbcUtils;

public class StudentDao implements JdbcDao1<Student, Integer>
{

	@Override
	public Collection<Student> getAll() 
	{
		Collection<Student> allStudents = new ArrayList<>();
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				Statement stmt= dbConnection.createStatement();
				ResultSet rs= stmt.executeQuery("select * from stud")
						)
		{
			while(rs.next())
			{
				int roll= rs.getInt(1);
				String name= rs.getString(2);
				String city = rs.getString(3);
				Student stud= new Student(roll,name,city);
				allStudents.add(stud);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return allStudents;
	}

	@Override
	public Student getOne(Integer roll)
	{
		Student foundStudent = null;
		String sqlQuerry = "select * from stud where roll = ?";
		try(
			Connection dbConnection = JdbcUtils.buildConnection();
			PreparedStatement pstmt=dbConnection.prepareStatement(sqlQuerry);
				)
		{
			pstmt.setInt(1, roll);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				int roll1
				= rs.getInt(1);
				String name= rs.getString(2);
				String city = rs.getString(3);
				foundStudent = new Student(roll, name, city);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return foundStudent;
	}

	@Override
	public void add(Student stud)
	{
		String sqlQuerry = "insert into stud values(?,?,?)";
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt=dbConnection.prepareStatement(sqlQuerry);
					)
			{
			   int roll= stud.getRoll();
			   String name= stud.getName();
			   String city= stud.getCity();
			   
			  
			pstmt.setInt(1, roll);
			   pstmt.setString(2, name);
			   pstmt.setString(3, city );
			   
			   int updateCount = pstmt.executeUpdate();
			   System.out.println(updateCount + " Record Inserted ");
			}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

	

}

