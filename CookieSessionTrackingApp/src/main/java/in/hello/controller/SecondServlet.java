package in.hello.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pband = request.getParameter("pband");
		String pqty = request.getParameter("pqty");
		
		Cookie cookie3 = new Cookie("pband",pband);
		Cookie cookie4 = new Cookie("pqty",pqty);
		
		response.addCookie(cookie3);
		response.addCookie(cookie4);
		
		RequestDispatcher rd = request.getRequestDispatcher("./form3.html");
		rd.forward(request, response);
		
		
		
	}

}
