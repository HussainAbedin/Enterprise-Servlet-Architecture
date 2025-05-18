package in.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/first", loadOnStartup = 2)
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
        System.out.println("FirstServlet loaded!");
    }

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 response.getWriter().println("FirstServlet Response");
	}

}
