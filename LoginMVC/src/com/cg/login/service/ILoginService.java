package com.cg.login.service;

import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import com.cg.login.bean.LoginBean;

public interface ILoginService {

	boolean validate(LoginBean loginBean);

	boolean verifyLogin(LoginBean loginBean) throws LoginException, SQLException;

}
