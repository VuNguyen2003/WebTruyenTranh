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

@WebServlet(urlPatterns = "/favoritepage", name = "favoritePage")
public class favoritePageController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		User user = (User) request.getSession().getAttribute("mem");
		String index = request.getParameter("indexPage");
		int userID = user.getUserID();
		if(index == null) {
			index = "1";
		}
		int endPage;
		int pageSize = 20;
		int Count;
		storyDAO dao = new storyDAO();
		ArrayList<Story> liststory = new ArrayList<Story>();
		
		try {
			Count = dao.countfavoriteStory(userID);
			liststory = dao.favoriteStory(userID, (Integer.parseInt(index)-1)*20);
			endPage = Count / pageSize;
			if(Count % pageSize != 0) {
				endPage++;
			}
			request.setAttribute("listStory", liststory);
			request.setAttribute("indexPage", index);
			request.setAttribute("endPage", endPage);
			request.getRequestDispatcher("favoritePage.jsp").forward(request, response);
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public void destroy() {
		
		super.destroy();
	}
}
