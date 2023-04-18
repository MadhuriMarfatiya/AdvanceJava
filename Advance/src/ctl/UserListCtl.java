package ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/userlist.do")
public class UserListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserBean bean = null;
		UserModel m = new UserModel();
		try {
			List list = m.search(bean);
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			req.setAttribute("list", list);
			rd.forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		if (op.equals("search")) {
			String fname = req.getParameter("firstName");
			String lname = req.getParameter("lastName");
			UserBean bean = new UserBean();
			bean.setFirstName(fname);
			bean.setLastName(lname);
			
			UserModel m = new UserModel();
			try {
				List list = m.search(bean);

				RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
				req.setAttribute("list", list);
				rd.forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
