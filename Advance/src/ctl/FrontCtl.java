package ctl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter(filterName = "frontctl" ,urlPatterns = ("*.do"))
public class FrontCtl implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		Filter.super.init(filterConfig);
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		String uri=req.getRequestURI();
		
		if(session.getAttribute("bean")==null){
			RequestDispatcher rd=req.getRequestDispatcher("LoginView.jsp");
			req.setAttribute("msg", "sessionExpire!! Please login again");
			req.setAttribute("uri", uri);
			rd.forward(req, resp);
		}else {
			chain.doFilter(request, response);
		}	
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
}
