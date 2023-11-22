
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.Story;
import DTO.User;

@WebServlet("/comment")
public class commentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public commentController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("intro-comic.jsp").forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("mem");
		Story story = (Story)request.getAttribute("listStory");
		int userId = user.getUserID();
		int storyId = story.getStoryId();
		String cmt = request.getParameter("comment");
		System.out.println(userId +"\n"+storyId +"\n"+cmt);
		request.getRequestDispatcher("intro-comic.jsp").forward(request, response);
	}

}
