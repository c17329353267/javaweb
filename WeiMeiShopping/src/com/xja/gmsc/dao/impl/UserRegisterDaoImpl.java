package com.xja.gmsc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.xja.gmsc.dao.BaseDao;
import com.xja.gmsc.dao.UserRegisterDao;
import com.xja.gmsc.domain.Register;

public class UserRegisterDaoImpl extends BaseDao implements UserRegisterDao{

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	//添加用户
	@Override
	public void insertUser(Register reg) {
			
	String sql = "insert into user_register(reg_username,reg_surname,reg_loginname,reg_password,reg_email,reg_sex,"
			+ "reg_picture,reg_dataofbirth,state)" 
						 +" VALUES(?,?,?,?,?,?,?,?,?)";
				
	String[] params = {reg.getUserName(),reg.getSurName(),reg.getLoginName(),reg.getPassword(),reg.getEmail(),
			
	reg.getSex(),reg.getPicture(),reg.getDataOfBirth(),reg.getState().toString()};	
	this.execuSqlNonQuery(sql, params);
			
	}
	@Override
	public Register selectRegisterByNameAndPwd(String loginname, String loginpwd) {
		// TODO Auto-generated method stub
		Register reg =null;
		try {
			conn = this.getConnection();
			String sql = "select reg_userid,reg_username,reg_surname,reg_loginname,reg_password,"  
					+"reg_email,reg_sex,reg_picture,reg_dataofbirth,state "  
					+"from user_register where reg_loginname = ? and reg_password = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, loginname);
			pst.setString(2, loginpwd);
			rs = pst.executeQuery();
			while(rs.next()) {
				reg = new Register();
				reg.setUserId(rs.getInt("reg_userid"));
				reg.setUserName(rs.getString("reg_username"));
				reg.setSurName(rs.getString("reg_surname"));
				reg.setLoginName(rs.getString("reg_loginname"));
				reg.setPassword(rs.getString("reg_password"));
				reg.setPicture(rs.getString("reg_picture"));
				reg.setEmail(rs.getString("reg_email"));
				reg.setDataOfBirth(rs.getString("reg_dataofbirth"));
				reg.setSex(rs.getString("reg_sex"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.release(conn, pst, rs);
		}
		return reg;
	}

}
