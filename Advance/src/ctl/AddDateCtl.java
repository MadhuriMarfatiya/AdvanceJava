package ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.AddDateBean;
import in.co.rays.model.AddDateModel;
@WebServlet("/addDate")
public class AddDateCtl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String dob=req.getParameter("dob");
	AddDateBean bean=new AddDateBean();
	try {
		bean.setDob(sdf.parse(dob));
		AddDateModel m=new AddDateModel();
		m.add(bean);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(dob);
}
}
