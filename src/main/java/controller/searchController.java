package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.storyDAO;
import DTO.Story;

@WebServlet(urlPatterns = "/search", name = "Search")
public class searchController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storyName = request.getParameter("id");
		String indexPage = request.getParameter("index");
		ArrayList<Story> listStory = new ArrayList<Story>();
		storyDAO searchStory = new storyDAO();
		
		int Count;
		int pageSize = 20;
		int endPage;
		if(indexPage == null) {
			indexPage = "1";
		}
		if(storyName == null) {
			request.getRequestDispatcher("home").forward(request, response);
		}
		
		try {
			listStory = searchStory.searchStory((Integer.parseInt(indexPage)-1)*20,storyName);
			Count = searchStory.CountSearch(storyName);
			endPage = Count / pageSize;
			if(Count % pageSize != 0) {
				endPage++;
			}
			request.setAttribute("listStory", listStory);
			request.setAttribute("indexPage", indexPage);
			request.setAttribute("endPage", endPage);
			request.getRequestDispatcher("pageSearch.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	public void destroy() {
		
		super.destroy();
	}
}
