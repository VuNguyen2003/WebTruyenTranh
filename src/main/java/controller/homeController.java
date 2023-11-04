package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import BO.*;
import DTO.*;
@WebServlet(urlPatterns = "/home", name = "Home")
public class homeController extends HttpServlet{

	private static final long serialVersionUID = -5496073216125057646L;
	@Override	
	public void init() throws ServletException {
		super.init();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.service(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String page = "0";
		//tạo và set cho list bằng null
		ArrayList<Story> list = null;
		try {
			//gọi dữ liệu đc lấy ra từ StoryBO
			list = storyBO.listStory(Integer.parseInt(page));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//tạo biến và request cho jsp
		request.setAttribute("page", page);
		request.setAttribute("storyList", list);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		
		super.destroy();
	}
	
	
}
