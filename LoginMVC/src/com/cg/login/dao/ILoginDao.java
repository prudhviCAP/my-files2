package com.cg.login.dao;

import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import com.cg.login.bean.LoginBean;

public interface ILoginDao {

	public boolean verifyLogin(LoginBean loginBean) throws LoginException, SQLException;
}
