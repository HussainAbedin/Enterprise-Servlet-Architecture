package in.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

		String accType = request.getParameter("accType");
		String accBranch = request.getParameter("accBranch");
		
		HttpSession session = request.getSession();
		session.setAttribute("accType", accType);
		session.setAttribute("accBranch", accBranch);
		
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Deposit form</title></head>");
		out.println("<body bgcolor='cyan'>");
		out.println("<center>");
		out.println("<h1 style='color:red;'>Deposit form...</h1>");
		//using this sessionId  will be generated at url rather than client side.
		out.println("<form method='post' action='" + response.encodeURL("./third") + "'>");
		
		out.println("<table>");
		out.println("<tr><th>Depositor Name</th><td><input type='text' name='depName'/></td></tr>");
		out.println("<tr><th>Deposit Amount</th><td><input type='text' name='depAmount'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='next'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

		out.close();


		
	}

}
