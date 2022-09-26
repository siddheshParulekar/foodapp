package com.jdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	public static Connection connect() throws SQLException, ClassNotFoundException {
		
		Class c=Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Found");
		
		Connection connection=null;
		String url="jdbc:mysql://localhost:3306/jdbc_siddhesh";
		String username="root";
		String password="root";
		connection=DriverManager.getConnection(url,username,password);
		System.out.println(connection.getClass());
		System.out.println("Connection Established");
		return connection;
	}

}