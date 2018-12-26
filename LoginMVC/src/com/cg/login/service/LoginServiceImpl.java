package com.cg.login.service;

import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import com.cg.login.bean.LoginBean;
import com.cg.login.dao.ILoginDao;
import com.cg.login.dao.LoginDaoImpl;

public class LoginServiceImpl implements ILoginService {

	@Override
	public boolean validate(LoginBean loginBean) {
		boolean result = false;
		if(loginBean.getUsername().length()>3 && loginBean.getPassword().length()>3) {
			result =true;
		}
		return result;
	}

	@Override
	public boolean verifyLogin(LoginBean loginBean) throws LoginException, SQLException {
		ILoginDao dao = new LoginDaoImpl();
		return dao.verifyLogin(loginBean);
	}

}
