package in.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBConnectionViaInit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection=null;
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Loaded..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public DBConnectionViaInit() {
		
		System.out.println("Instantiation has been done..");
	}
	public void init() {
		
		String url = getInitParameter("url");
		String username = getInitParameter("username");
		String password = getInitParameter("password");
		try {
		 connection = DriverManager.getConnection(url,username,password);
		 System.out.println("Connection Object got Created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			PreparedStatement pstmt = connection.prepareStatement("insert into student(`sname`,`sage`,`saddr`) values(?,?,?)");
			pstmt.setString(1, "Rubina");
			pstmt.setInt(2, 63);
			pstmt.setString(3, "Bhujwala");
			int rowCount = pstmt.executeUpdate();
			if(rowCount==1) {
				out.println("<h1 style='text-align:center;color:green'>Record entered Successfully..</h1>");
			}
			else {
				out.println("<h1 style='text-align:center;color:red'>Failed</h1>");
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
