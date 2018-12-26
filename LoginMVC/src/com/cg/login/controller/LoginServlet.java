package com.cg.login.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.login.bean.LoginBean;
import com.cg.login.service.ILoginService;
import com.cg.login.service.LoginServiceImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname").trim();
		String password = request.getParameter("pwd").trim();
		
		ILoginService service = new LoginServiceImpl();
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		if(service.validate(loginBean)) {
			try {
				try {
					if (service.verifyLogin(loginBean)) {
						HttpSession session = request.getSession();
						session.setAttribute("username", username);
						request.getRequestDispatcher("/inbox.jsp").include(request, response);
					} else {
						request.setAttribute("errmsg", "u have entreed wrong username");
						request.getRequestDispatcher("error.jsp").include(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (LoginException e) {
				request.setAttribute("errmsg", "u have entreed wrong username");
				request.getRequestDispatcher("error.jsp").include(request, response);
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			request.setAttribute("errmsg", "u have entreed wrong username");
			request.getRequestDispatcher("error.jsp").include(request, response);
		}
	}

}
