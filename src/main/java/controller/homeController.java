package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.*;
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
		storyDAO Story = new storyDAO();
		String indexPage = request.getParameter("index");
		if(indexPage == null) {
			indexPage = "1";
		}
		try {
			int Count = Story.CountPage();
			int pageSize = 16;
			int endPage = Count / pageSize;
			if(Count % pageSize != 0) {
				endPage++;
			}
			ArrayList<Story> list = new ArrayList<Story>();
			ArrayList<Story> Toplist = new ArrayList<Story>();
			list = Story.getStory((Integer.parseInt(indexPage)-1)*16);
			Toplist = Story.topStory();
			request.setAttribute("indexPage", indexPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listStory", list);
			request.setAttribute("topStory", Toplist);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		
		super.destroy();
	}
	
	
}
