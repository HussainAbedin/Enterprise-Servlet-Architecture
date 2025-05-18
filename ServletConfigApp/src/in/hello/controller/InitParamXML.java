package in.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		out.println("<center>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>Name</td>");
		out.println("<th>Value</td>");
		out.println("</tr>");
		
		Enumeration<String> parameterNames = getInitParameterNames();
		while (parameterNames.hasMoreElements()) {
			String key = (String) parameterNames.nextElement();
			String value = getInitParameter(key);
			out.println("<tr>");
			out.println("<td>"+key+"</td>");
			out.println("<td>"+value+"</td>");
			out.println("</tr>");
			
			
		}
		out.println("</center>");
		
	}

}
