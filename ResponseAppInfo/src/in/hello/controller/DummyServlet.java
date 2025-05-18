package in.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class DummyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*In single application can we use both PrintWriter object and ServletOutputStream
to send the response?
Ans. Not possible, it would result in "java.lang.IllegalStateException: getWriter()
has already been called for this response".
 * 
 */
		response.setContentType("video/mp4");
		PrintWriter out = response.getWriter();
		ServletOutputStream stream = response.getOutputStream();
		out.close();
		stream.close();
	}

}
