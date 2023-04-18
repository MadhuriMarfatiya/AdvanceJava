package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.co.rays.bean.AddDateBean;
import in.co.rays.util.JdbcDataSource;

public class AddDateModel {

	public void add (AddDateBean bean) throws Exception {
		Connection conn=JdbcDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("insert into dateTable values(?)");
		
		ps.setDate(1, new java.sql.Date(bean.getDob().getTime()));
		
		int i =ps.executeUpdate();
		System.out.println(i+"record has been inserted");
	}
}
