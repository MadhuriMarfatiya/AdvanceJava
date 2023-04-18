package ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/userRegistration")
public class Userctl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserModel m = new UserModel();
		String id = req.getParameter("id");
		if (id != null) {
			try {
				UserBean bean = m.findById(Integer.parseInt(id));
				req.setAttribute("bean1", bean);
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		RequestDispatcher rd = req.getRequestDispatcher("UserRegistration.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		if (op.equals("Add")) {

			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();

			UserBean bean = new UserBean();

			bean.setFirstName(req.getParameter("firstName"));
			bean.setLastName(req.getParameter("lastName"));
			bean.setLoginId(req.getParameter("loginId"));
			bean.setPassword(req.getParameter("password"));

			UserModel m = new UserModel();

			try {
				m.add(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			RequestDispatcher rd=req.getRequestDispatcher("LoginView.jsp");
			req.setAttribute("ADDmsg","you have successfully added...Please login.!");
			rd.forward(req, resp);
		}

		if (op.equals("Update")) {
			int id = Integer.parseInt(req.getParameter("id"));


			UserBean bean = new UserBean();
			bean.setId(id);
			bean.setFirstName(req.getParameter("firstName"));
			bean.setLastName(req.getParameter("lastName"));
			bean.setLoginId(req.getParameter("loginId"));
			bean.setPassword(req.getParameter("password"));
			UserModel m = new UserModel();
			try {
				
				m.update(bean);
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd=req.getRequestDispatcher("UserRegistration.jsp");
			req.setAttribute("msg","you have successfully updated..!");
			req.setAttribute("bean1", bean);
			rd.forward(req, resp);
			//resp.sendRedirect("userlist.do");
		}

	}

}
