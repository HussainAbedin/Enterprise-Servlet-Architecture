package in.hello.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		HttpSession session = request.getSession();
		String sname = request.getParameter("sname");
		String sage = request.getParameter("sage");
		
		session.setAttribute("sname", sname);
		session.setAttribute("sage", sage);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./form2.html");
		requestDispatcher.forward(request, response);
		
	}

}
