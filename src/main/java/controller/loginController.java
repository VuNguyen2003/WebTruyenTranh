package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.userDAO;

@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userDAO ud = new userDAO();
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + password);
		
		try {
			if(ud.checkExitAccount(username, password)) {
				HttpSession s = request.getSession();
				s.setAttribute("msg", "signin");
				s.setAttribute("username", username);
				s.setMaxInactiveInterval(60*60);
				request.getRequestDispatcher("home").forward(request, response);
				
			}
			else System.out.println("tài khoản không tồn tại");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Không thể render data");
		}
		
		
	}

}
