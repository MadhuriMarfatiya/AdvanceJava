package in.co.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.util.JdbcDataSource;

public class UserModel {

	public Integer nextPk() throws Exception {
		
		Connection conn=JdbcDataSource.getConnection();
		PreparedStatement ps= conn.prepareStatement("select max(id)from user");
		
		int pk=0;
		ResultSet rs=ps.executeQuery();
		 while(rs.next()) {
			 pk=rs.getInt(1);
		 }
		
	return pk+1;	
	}
	
	public void add(UserBean bean) throws Exception {
		Connection conn=JdbcDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("insert into user values(?,?,?,?,?)");
		
		ps.setInt(1, nextPk());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		int i=ps.executeUpdate();
		System.out.println("record inserted.."+i);
		
	}
	
	public void update(UserBean bean) throws Exception {
		Connection conn=JdbcDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("update user set firstName=?,lastName=?,loginId=?,password=? where id =?");
		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setInt(5, bean.getId());
		
		int i=ps.executeUpdate();
		System.out.println(i+" record has been updated");
	}
	
	public void delete(int id) throws Exception {
		Connection conn=JdbcDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("delete from user where id=?");
		ps.setInt(1, id);
		int i= ps.executeUpdate();
		System.out.println(i+"recod has been deleted");
	}
	
	public UserBean findById (int id) throws Exception {
		Connection conn=JdbcDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from user where id =?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		UserBean bean=null;
		while(rs.next()) {
			bean=new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
		}
		return bean;
	}
	
	public List search(UserBean bean) throws Exception {
		Connection conn=JdbcDataSource.getConnection();
		StringBuffer sql=new StringBuffer("select * from user where 1=1");
		if(bean !=null) {
			if(bean.getFirstName()!=null && bean.getFirstName().length()>0) {
				sql.append(" and firstName like '"+bean.getFirstName()+"%'");
				
			}
			if(bean.getLastName()!=null && bean.getLastName().length()>0) {
				sql.append(" and lastName like '"+bean.getLastName()+"%'");
				
			}
		}
		
		System.out.println("SQL = "+sql);
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		//MarksheetBean bean = null;

		System.out.println("id\tfirstName\tlastName\tloginId\tpassword");
		while(rs.next()) {
			bean=new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			
			list.add(bean);
		}
		return list;
		}
		
	public UserBean authenticate (String loginId,String password) throws Exception {
		Connection conn=JdbcDataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from user where loginId =? && password=?");
		ps.setString(1, loginId);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		UserBean bean=null;
		while(rs.next()) {
			bean=new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
		}
		return bean;
	}
		
		
	}

