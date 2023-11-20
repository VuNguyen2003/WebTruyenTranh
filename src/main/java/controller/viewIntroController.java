package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
import DTO.*;

@WebServlet(urlPatterns = "/viewintro", name = "viewIntro")
public class viewIntroController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public viewIntroController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storyID = request.getParameter("id");
		Story Story = new Story();
		storyDAO introStory = new storyDAO();
		chapterDAO listChapter = new chapterDAO();
		ArrayList<Chapter> chapter = new ArrayList<Chapter>();
		try {
			
			Story = introStory.introStory(Integer.parseInt(storyID));
			chapter = listChapter.getChapterList(Integer.parseInt(storyID));
			request.setAttribute("listStory", Story);
			request.setAttribute("listChapter", chapter);
			request.getRequestDispatcher("intro-comic.jsp").forward(request, response);
			
		} catch (NumberFormatException | ClassNotFoundException | SQLException | ParseException e) {
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
