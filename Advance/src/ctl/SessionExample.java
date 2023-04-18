package ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
@WebServlet("/session")
public class SessionExample extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession(true);
	
	//print session info...
	
	Date created=new Date(session.getCreationTime());
	Date accessed=new Date(session.getLastAccessedTime());
	
	resp.setContentType("text/html");
	PrintWriter out=resp.getWriter();
	
	out.println("id"+session.getId());
	out.println("created"+created);
	out.println("last accessed"+accessed);
	
	String dataName=req.getParameter("dataName");
	String dataValue=req.getParameter("dataValue");
	session.setAttribute(dataName, dataValue);
	
	//get attribute from session and print
	Enumeration e=session.getAttributeNames();
	while(e.hasMoreElements()) {
		String name=(String) e.nextElement();
		String value=(String) session.getAttribute(name);
		out.println(name+"="+value);
		
	}
	
	}
}
