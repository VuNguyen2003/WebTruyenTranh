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

import DAO.storyDAO;
import DTO.Story;

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
		Story listStory = new Story();
		storyDAO introStory = new storyDAO();
		try {
			listStory = introStory.introStory(Integer.parseInt(storyID));
		} catch (NumberFormatException | ClassNotFoundException | SQLException | ParseException e) {
			
		}
		request.setAttribute("listStory", listStory);
		request.getRequestDispatcher("intro-comic.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
}
