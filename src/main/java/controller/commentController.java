
package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.commentDAO;
import DTO.Comment;
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
    
	protected void doPost(
		HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("mem");
		int userId = user.getUserID();
		int storyId = Integer.parseInt(request.getParameter("strId"));
		String cmt = request.getParameter("comment");
		System.out.println(userId +"\n" +"\n"+cmt);
		commentDAO cmtdao = new commentDAO();
		try {
			cmtdao.insertComment(new Comment(userId,storyId,cmt));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("intro-comic.jsp").forward(request, response);
	}
	
	
}
