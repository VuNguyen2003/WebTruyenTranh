package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import DAO.userDAO;
import DTO.User;

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
		
		try {
			User user = ud.getUser(username, password);
			if(ud.checkExitAccount(username, password)) {
				HttpSession s = request.getSession();
				s.setAttribute("mem",user);
				s.setAttribute("msg","signin");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else System.out.println("tài khoản không tồn tại");
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			e.printStackTrace();
		}		
	}

}
