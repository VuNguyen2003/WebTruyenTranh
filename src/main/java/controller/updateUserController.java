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

@WebServlet("/updateUser")
public class updateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public updateUserController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//lấy data từ jsp
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String birthdate = request.getParameter("birthdate");
		String phonenumber = request.getParameter("phonenumber");
		String homeaddress = request.getParameter("homeaddress");
		String oldpass = request.getParameter("oldpass");
		String newpass = request.getParameter("newpass");
		String newpasscf = request.getParameter("newpasscf");
		//lấy id và password từ session
		User user = (User) request.getSession().getAttribute("mem");
		int id = user.getUserID();
		String password = user.getPassword();
		System.out.println(password+" k");
		
		if(!newpass.equals(newpasscf) || !oldpass.equals(password)) {
			System.out.println(oldpass+"\n"+newpass+"\n"+newpasscf);
		}
		else if(oldpass.equals(password)){
			//truyền dữ liệu cập nhật vào user tạm
			user.setUsername(username);
			user.setEmail(email);
			user.setFullname(fullname);
			user.setBirthdate(birthdate);
			user.setPhoneNumber(phonenumber);
			user.setHomeAddress(homeaddress);
			user.setPassword(newpass);
			
			userDAO u = new userDAO();
			try {
				u.updateUser(id, user);
				HttpSession s = request.getSession();
				s.setAttribute("mem", user);
				request.getRequestDispatcher("per-info.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException | ParseException e) {
				e.printStackTrace();
			}
		}
	}

}
