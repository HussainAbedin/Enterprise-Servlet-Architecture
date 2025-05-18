package in.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hit")
public class HitTheRequestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		Integer count = (Integer)context.getAttribute("hitCount");
		if(count==null)
			count=1;
		else
		count++;
		out.println("<h1 style='color:green'> Hit Count of the Application is ::"+count+"</h1>");
	}

}
