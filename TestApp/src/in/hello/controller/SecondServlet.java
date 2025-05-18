package in.hello.controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/second",loadOnStartup = 1)
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    public void init() throws ServletException {
        System.out.println("SecondServlet loaded!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("SecondServlet Response");
    }
}

