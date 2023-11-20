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
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storypageDAO page = new storypageDAO();
		String chapterID = request.getParameter("chapterID");
		ArrayList<StoryPage> pagelist = new ArrayList<StoryPage>();
		try {
			pagelist = page.getStoryPage(chapterID);
			request.setAttribute("pageList",pagelist);
			request.getRequestDispatcher("read-comic.jsp").forward(request, response);
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			
		}
		
	}
	public void destroy() {
		
		super.destroy();
	}
}
