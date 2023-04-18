package in.co.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcDataSource {

	//JDBC Datasource static object
	private static JdbcDataSource jds=null;
	
	//C3P0 database connection pool
	private ComboPooledDataSource ds =null;
	
	//Make default Constructor private
	private JdbcDataSource() {
		try {
			//create data source
			ds=new ComboPooledDataSource();
			
			//set DS properties
			ds.setDriverClass("com.mysql.cj.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/advance");
			ds.setUser("root");
			ds.setPassword("root");
			ds.setInitialPoolSize(5);
			ds.setAcquireIncrement(5);
			ds.setMaxPoolSize(50);
		}catch(PropertyVetoException e){
			e.printStackTrace();
		}
	}
	
	//get singleton class instance
	public static JdbcDataSource getInstance() {
		if(jds==null) {
			jds=new JdbcDataSource();
		}
		return jds;
	}
	
	//get connection from DCP
	public static Connection getConnection() {
		try {
			return getInstance().ds.getConnection();
		}catch(SQLException e) {
			return null;
		}
	}
	
	//close connection
	public static void closeConnection(Connection conn,Statement stmt,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//close connection
	public static void closeConnection(Connection conn,Statement stmt) {
		closeConnection(conn, stmt,null);
	}
	
	//close Connection
	public static void closeConnection(Connection conn) {
		closeConnection(conn,null,null);
		
	}

}
