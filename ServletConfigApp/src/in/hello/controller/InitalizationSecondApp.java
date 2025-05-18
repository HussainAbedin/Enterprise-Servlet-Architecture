package in.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitalizationSecondApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		out.println("<table>");
		out.println("<tr>");
		Enumeration<String> initParameterNames = getInitParameterNames();
		while (initParameterNames.hasMoreElements()) {
			String key = (String) initParameterNames.nextElement();
			String value = getInitParameter(key);
			out.println("<tr><td>" + key + "</td><td>" + value + "</td></tr>");
			
		}
		
		
		out.println("</tr>");
		
		
		
		out.println("</table>");
	
	}

}
