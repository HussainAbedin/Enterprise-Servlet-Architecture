package in.hello.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/output")
public class GetOutputStream extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
response.setContentType("image/jpg");
PrintWriter writer = response.getWriter();
		
		File f = new File("E:\\ServletFinalPractice\\ResponseAppInfo\\IMG_2093.JPG");
		FileInputStream fileInputStream = new FileInputStream(f);
		
		byte[] b=new byte[(int)f.length()];
		fileInputStream.read(b);
		
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(b);

		outputStream.flush();
		outputStream.close();
		fileInputStream.close();
	}

}
