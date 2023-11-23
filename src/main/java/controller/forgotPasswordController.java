package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.userDAO;
import DTO.Email;

@WebServlet("/forgotPassword")
public class forgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public forgotPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String to = request.getParameter("email");
		if(!to.equals("")) {
			Email email = new Email();
			if(email.sendOTP(to)>0) {
				userDAO u = new userDAO();
				request.getSession().setAttribute("email",to);
				request.getSession().removeAttribute("warning");
				request.getSession().setAttribute("otp",email.sendOTP(to));
				request.getRequestDispatcher("inputOTP.jsp").forward(request, response);
			}else { 
				request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
			}
		}
	}

}