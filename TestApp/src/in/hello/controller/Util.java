package in.hello.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		String password="HussainCS 211210";
		String username="root";
		String url="jdbc:mysql://localhost:3306/jdbcpgms";
		Connection connection = DriverManager.getConnection(url,username,password);
	
		System.out.println("Connection object got created");
	}

}
