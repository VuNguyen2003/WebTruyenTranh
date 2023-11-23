package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import DTO.Email;

@WebServlet("/inputOTP")
public class inputOTPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public inputOTPController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("inputOTP.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String otp =(String) request.getSession().getAttribute("otp").toString();
		String otpcf = request.getParameter("otpcf");
		
		if(!otp.equals(otpcf)) {
			request.getSession().setAttribute("warning", "warning");
			request.getRequestDispatcher("inputOTP.jsp").forward(request, response);
		}
		else {
			request.getSession().removeAttribute("otp");
			System.out.println("giong "+otp+"\n"+otpcf);
			request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
		}
	}

}