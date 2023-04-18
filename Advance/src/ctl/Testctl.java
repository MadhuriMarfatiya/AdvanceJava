package ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test")
public class Testctl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] add=req.getParameterValues("address");
		String name=req.getParameter("name");
		
		for (String string : add) {
			System.out.println(string);
		}
		System.out.println(name);

		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println(name);

		
	}
	
}
