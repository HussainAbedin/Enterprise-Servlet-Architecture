import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns="/fourth",loadOnStartup = 10)
public class FourthServlet extends GenericServlet {
    
    // Request Processing logic
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
		
		
		String userName = request.getParameter("username");
		System.out.println("username is :: "+userName);
	
	
        System.out.println("Servlet Request Processing ...");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Output</title></head>");
		out.println("<body>");
		out.println("<h1 style='color:purple;'><marquee>Working With Generic Servlet...</marquee></h1>");
		out.println("</body>");
		out.println("</html>");

		out.close();	
		 
	}

    
}
