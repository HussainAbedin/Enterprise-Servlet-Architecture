package in.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html><head><title>OUTPUT</title></head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:green;'>CONTEXT PARAMTER INFORMATION</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>ContextParameter Name</th><th>ContextParameter Value</th></tr>");
		ServletContext context = getServletContext();
		Enumeration<String> initParameterNames = context.getInitParameterNames();
		while (initParameterNames.hasMoreElements()) {
			String key = (String) initParameterNames.nextElement();
			String value = context.getInitParameter(key);
			out.println("<tr>");
			out.println("<td>" + key + "</td>");
			out.println("<td>" + value + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	
	}

}
