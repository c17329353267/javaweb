package com.xja.gmsc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private Connection conn = null;
	private PreparedStatement pre = null;
	private ResultSet rs = null;

	public  Connection getConnection() throws Exception {
		Connection conn=null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/guimeishopping?useUnicode=true&characterEncoding=utf-8","root","123");	
		return conn;
	}

		public  void release(Connection conn,PreparedStatement pre,ResultSet rs) {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pre != null) {
				try {
					pre.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		public  void release(Connection conn,PreparedStatement pre) {
					
			if(pre != null) {
				try {
					pre.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		public void execuSqlNonQuery(String sql,String[] params) {

			try {
				conn = this.getConnection();
				pre = conn.prepareStatement(sql);
				if(params != null) {
					for(int i =0;i<params.length;i++) {
						pre.setString(i+1, params[i]);
					}
				}

				pre.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {

				this.release(conn, pre);
			}
		}
}
