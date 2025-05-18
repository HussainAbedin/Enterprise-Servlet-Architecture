package in.hello.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		ServletConfig servletConfig = getServletConfig();
		ServletContext servletContext = getServletContext();
		System.out.println("Implementation classes of Interface..");
		System.out.println("Implemenation of config object ::"+servletConfig.getClass().getName());
		System.out.println("Implemenation of context object ::"+servletContext.getClass().getName());
		System.out.println("Implemenation of request object ::"+request.getClass().getName());
		System.out.println("Implemenation of response object ::"+response.getClass().getName());
		
		
	}

}
