package ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/info")
public class RequestInfo extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
resp.setContentType("text/html");
PrintWriter out=resp.getWriter();
out.println("<h3>Request Information example</h3>");
out.println("method: "+req.getMethod());
out.println("Request URI: "+req.getRequestURI());
out.println("Protocol: "+req.getProtocol());
out.println("Remote Address: "+req.getRemoteAddr());


Enumeration e=req.getHeaderNames();
while(e.hasMoreElements()) {
	String name=(String) e.nextElement();
	String value=req.getHeader(name);
	out.println(name+"="+value);
}
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	doGet(req, resp);		
		
	}
}
