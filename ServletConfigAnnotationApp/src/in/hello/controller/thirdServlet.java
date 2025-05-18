package in.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = {"third"},
		initParams = {
				@WebInitParam(name="url",value="jdbc:mysql://jdbcpgms"),
				@WebInitParam(name="username",value="root"),
				@WebInitParam(name="password",value="HussainCS 211210")
		},loadOnStartup = 10 )
public class thirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Class Loaded...");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}	
	}
	public thirdServlet() {
		System.out.println("Instantation Done..");
	}
	public void init() {
		
		String url = getInitParameter("url");
		String username = getInitParameter("username");
		String password = getInitParameter("password");
		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			System.out.println("Connection Object Created..");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PrintWriter writer = response.getWriter();
		
	}

}
