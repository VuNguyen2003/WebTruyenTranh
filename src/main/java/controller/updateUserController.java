package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.userDAO;
import DTO.User;


@WebServlet("/updateUser")
@MultipartConfig
public class updateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public updateUserController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("per-info.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//lấy data từ jsp
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String birthdate = request.getParameter("birthdate");
		String phonenumber = request.getParameter("phonenumber");
		String homeaddress = request.getParameter("homeaddress");
		String oldpass = request.getParameter("oldpass");
		String newpass = request.getParameter("newpass");
		String newpasscf = request.getParameter("newpasscf");
		Part part = request.getPart("image");
		String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString(); //file name
		System.out.println("fileName: "+fileName);
		
	    //lưu file ảnh vào server----------------------------------------
		String uploadPath="D:\\java\\doan\\WebTruyenTranh\\src\\main\\webapp\\images\\"+fileName;
		try {
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = part.getInputStream();
			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();			
		}catch(Exception e) {
			e.printStackTrace();
		}//----------------------------------------------------------------
		
		//update database
		User user = (User) request.getSession().getAttribute("mem");
		int id = user.getUserID();
		String password = user.getPassword();
		//kiểm tra đúng mk thì thực hiện cập nhật 
		if( !oldpass.equals(password) || !newpass.equals(newpasscf)) {
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
			if(!fileName.equals("")) {
				user.setFileName(fileName);
			}
			//nếu nhập mật khẩu mới thì update mk, không thì k cần update mk
			if(!newpass.isEmpty()) {
				user.setPassword(newpass);
			}
		//-------------------------------------
			//update db
			userDAO u = new userDAO();
			try {
				u.updateUser(id, user);
				HttpSession s = request.getSession();
				s.setAttribute("mem", user);
				
				
			} catch (ClassNotFoundException | SQLException | ParseException e) {
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("per-info.jsp").forward(request, response);
	}

}