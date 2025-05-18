package in.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns= {"/secondapp"},
		initParams= {
				@WebInitParam(name="url",value="jdbc:mysql:///jdbcpgms"),
				@WebInitParam(name="username",value="root"),
				@WebInitParam(name="password",value="HussainCS 211210"),
				
		},loadOnStartup=10	)
public class SecondServlet extends HttpServlet {
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
	@Override
	public void init(){

		String url = getInitParameter("url");
		String username  = getInitParameter("username");
		String password = getInitParameter("password");
		
	try {
		connection = DriverManager.getConnection(url,username,password);
		System.out.println("Connection object created..");
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
	    out.println("<h1>From Second Servlet</h1>");
		try {
			
			PreparedStatement pstmt = connection.prepareStatement("insert into student(`sname`,`sage`,`saddr`) values(?,?,?)");
			String name=request.getParameter("username");
			pstmt.setString(1, name);
			String age=request.getParameter("userage");
			pstmt.setInt(2, Integer.parseInt(age));
			String addr=request.getParameter("useraddr");
			pstmt.setString(3, addr);
			
			out.println("<table>");
			out.println("<tr>");
			out.println("<td>"+name+"</td>");
			out.println("</tr>");
			
			
			out.println("<tr>");
			out.println("<td>"+age+"</td>");
			out.println("</tr>");
			
			
			out.println("<tr>");
			out.println("<td>"+addr+"</td>");
			out.println("</tr>");
			
			
			out.println("<table>");
			
			int rowCount = pstmt.executeUpdate();
			if (rowCount==1) {
				System.out.println("Insertion Done Successfully");
			}
			else {
				System.out.println("Failure");
			}
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
	
	}

}
