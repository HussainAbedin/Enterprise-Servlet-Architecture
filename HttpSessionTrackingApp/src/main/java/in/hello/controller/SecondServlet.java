package in.hello.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String squal = request.getParameter("squal");
		String sdesg = request.getParameter("sdesg");
		
		session.setAttribute("squal", squal);
		session.setAttribute("sdesg", sdesg);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./form3.html");
		requestDispatcher.forward(request, response);
	}

}
