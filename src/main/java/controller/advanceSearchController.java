package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
import DTO.*;
@WebServlet(urlPatterns = "/advancesearch", name = "advanceSearch")
public class advanceSearchController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] tag = request.getParameterValues("tags");
		String tags = "tags=" + tag[0];
		for(int n = 1; n<tag.length ;n++) {
			tags += "&tags=" + tag[n];
		}
		String indexPage = request.getParameter("index");
		ArrayList<Story> listStory = new ArrayList<Story>();
		int pageSize = 20;
		int endPage;
		if(indexPage == null) {
			indexPage = "1";
		}
		if(tag == null) {
			storyDAO Story = new storyDAO();
			try {
				int Count = Story.CountPage();
				
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
			int Count = searchStory.countSearchStoriesByTags(tag);
			endPage = Count / pageSize;
			if(Count % pageSize != 0) {
				endPage++;
			}
			listStory = searchStory.searchStoriesByTags((Integer.parseInt(indexPage)-1)*20, tag);
			request.setAttribute("listStory", listStory);
			request.setAttribute("indexPage", indexPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("tags", tags);
			request.getRequestDispatcher("pageAdv-search.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public void destroy() {
		
		super.destroy();
	}
	
	
}
