package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.userDAO;
import DTO.User;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/signup")
public class signupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public signupController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("signup.jsp").include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordcf = request.getParameter("password-confirm");
		
		try {
			response.setContentType("text/html"); 
			response.setCharacterEncoding("UTF-8");
			request.removeAttribute("msg");
			
			if(!password.equals(passwordcf)) {
				System.out.println("Đăng ký thất bại");
				request.setAttribute("msg", "fail");
			}
			else {
				User newUser = new User();
				newUser.setUserID(1);
				newUser.setPerID(1);
				newUser.setUsername(username);
				newUser.setPassword(password);
				newUser.setFullname("") ;
				newUser.setBirthdate(null);
				newUser.setPhoneNumber("");
				newUser.setEmail(email);
				newUser.setHomeAddress("");
				userDAO u = new userDAO();
				u.insertUser(newUser);
				request.setAttribute("msg", "success");
			}
			request.getRequestDispatcher("signup.jsp").forward(request,response);
		}
		catch(Exception e) {
			
		}
	}
}
