package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import DAO.*;
import DTO.*;
@WebServlet(urlPatterns = "/readstory", name = "readStory")
public class readStoryController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storypageDAO page = new storypageDAO();
		chapterDAO chapter = new chapterDAO();
		String StoryID = request.getParameter("ID");
		String indexPage = request.getParameter("index");
		String chapterID = request.getParameter("chapterID");
		if(indexPage == null) {
			indexPage = "1";
		}
		ArrayList<StoryPage> pagelist = new ArrayList<StoryPage>();
		ArrayList<Chapter> chapterlist = new ArrayList<Chapter>();
		try {
			chapterlist = chapter.getChapterList(Integer.parseInt(StoryID));
			pagelist = page.getStoryPage(StoryID, Integer.parseInt(indexPage));
			request.setAttribute("pageList",pagelist);
			request.setAttribute("chapterlist",chapterlist);
			request.setAttribute("indexPage",indexPage);
			request.setAttribute("ID",StoryID);
			request.getRequestDispatcher("read-comic.jsp").forward(request, response);
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	public void destroy() {
		
		super.destroy();
	}
}
