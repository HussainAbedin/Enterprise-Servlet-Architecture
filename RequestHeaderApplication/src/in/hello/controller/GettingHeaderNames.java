package in.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class GettingHeaderNames extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>Name :</th>");
		out.println("<th>Value :</th>");
		out.println("</tr>");
		
		
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			out.println("<tr>");
			out.println("<td>"+key+"</td>");
			out.println("<td>"+value+"</td>");
			
			out.println("</tr>");
			
		}

		out.println("</table>");
	}

}
