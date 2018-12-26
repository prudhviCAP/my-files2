package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CustomerBean;
import service.BillServiceImpl;
import service.IBillService;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String address = request.getParameter("address");
		
		IBillService billService = new BillServiceImpl();
		BillServiceImpl billServiceImpl = new BillServiceImpl();
		
		CustomerBean bean = new CustomerBean();
		bean.setUsername(username);
		bean.setAddress(address);
		
		if(billServiceImpl.validate(bean)) {
			try {
				try {
					if (billServiceImpl.verifyLogin(bean)) {
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
