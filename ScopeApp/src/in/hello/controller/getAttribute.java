package in.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fetch")
public class getAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		ServletContext context = getServletContext();
		ServletContext context2 = getServletContext();
		context.setAttribute("hi", "hello");
		
		context.setAttribute("bye", "ok");
		
		out.println("<html><head><title>Attribute Data</title></head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:blue;'>Dynamic information in ApplicationScope...</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>AttributeName</th><th>AttributeValue</th></tr>");
		Enumeration<String> attributeNames = context.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attributeName = (String) attributeNames.nextElement();
			Object attributeValue = context.getAttribute(attributeName);
			out.println("<tr>");
			out.println("<td>" + attributeName + "</td>");
			out.println("<td>" + attributeValue + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
