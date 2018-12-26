package com.cg.login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import com.cg.login.exception.ExceptionMessages;

public class DbConnection {

	private static Connection connection=null;
	public static Connection getConnection() throws LoginException {
		if(connection==null) {
			try {
			connection = DriverManager.getConnection("jdbc:orcale:thin:@10.219.34.3:1521/orcl","trg707","training707");
			}catch(SQLException e) {
				throw new LoginException(ExceptionMessages.MESSAGE1);
			}
		}
		return connection;
	}
}
