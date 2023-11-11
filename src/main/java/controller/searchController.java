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
		storyDAO Story = new storyDAO();
		int Count;
		int pageSize = 20;
		int endPage;
		if(indexPage == null) {
			indexPage = "1";
		}
		if(storyName == null) {
			try {
				Count = Story.CountPage();
				endPage = Count / pageSize;
				if(Count % pageSize != 0) {
					endPage++;
				}
				listStory = Story.getStory((Integer.parseInt(indexPage)-1)*20);
				request.setAttribute("indexPage", indexPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("listStory", listStory);
				request.getRequestDispatcher("page.jsp").forward(request, response);
			} catch (Exception e) {}
		}
		storyDAO searchStory = new storyDAO();
		try {
			listStory = searchStory.searchStory((Integer.parseInt(indexPage)-1)*20,storyName);
			Count = Story.CountSearch(storyName);
			endPage = Count / pageSize;
			if(Count % pageSize != 0) {
				endPage++;
			}
			request.setAttribute("listStory", listStory);
			request.setAttribute("indexPage", indexPage);
			request.setAttribute("endPage", listStory.size());
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
