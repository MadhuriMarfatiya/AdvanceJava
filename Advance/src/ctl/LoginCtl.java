package ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/login")
public class LoginCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		HttpSession session = req.getSession();
		if (op != null && op.equals("logout")) {
			session.invalidate();
			req.setAttribute("msg", "Logout successfully");
		}
		RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");

		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("loginId");
		String pwd = req.getParameter("password");

		String op = req.getParameter("operation");

		if (op.equals("SignIn")) {
			HttpSession session = req.getSession();

			if (login.equals("") || pwd.equals("")) {

				if (login.equals("")) {

					req.setAttribute("m1", "Login is required..!!");

				}

				if (pwd.equals("")) {

					req.setAttribute("m2", "Password is required..!!");

				}

				RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
				rd.forward(req, resp);

			} else {
				UserModel m = new UserModel();
				try {
					UserBean bean = m.authenticate(login, pwd);
					String uri = (String) req.getParameter("uri");
					if (bean != null) {
						session.setAttribute("bean", bean);
						if (uri.equalsIgnoreCase("null")) {
							RequestDispatcher rd = req.getRequestDispatcher("welcome.do");

							rd.forward(req, resp);
						} else {
							resp.sendRedirect(uri);
						}
					} else {
						RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
						req.setAttribute("msg", "invalid Id and password...");
						rd.forward(req, resp);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		if (op.equals("SignUp")) {
			resp.sendRedirect("userRegistration");
		}
	}
}
