package com.cg.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import com.cg.login.bean.LoginBean;
import com.cg.login.util.DbConnection;

public class LoginDaoImpl implements ILoginDao {

	public boolean verifyLogin(LoginBean loginBean) throws LoginException, SQLException {
		boolean result = false;
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		pst = con.prepareStatement("select * from user_details where username=? and password=?");
		pst.setString(1, loginBean.getUsername());
		pst.setString(2, loginBean.getPassword());
		rs=pst.executeQuery();
		while(rs.next()) {
			result = true;
		}
		
		return result;
	}
}
