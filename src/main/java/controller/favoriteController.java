package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.favoriteDAO;
import DTO.Favorite;

@WebServlet(urlPatterns = "/favorite", name = "favorite")
public class favoriteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("viewintro").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int userid = Integer.parseInt(request.getParameter("userId"));
		int storyid = Integer.parseInt(request.getParameter("id"));
		Favorite fav = new Favorite(userid,storyid);
		
		favoriteDAO fdao = new favoriteDAO();
		try {
			if (fdao.checkfavorite(fav) == 0 ) {
				fdao.insert(fav);
				System.out.println("thêm yêu thích");
			}
			else {
				fdao.remove(fav);
				System.out.println("xóa yêu thích");
			}
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("viewintro").forward(request, response);
	}
	public void destroy() {
		
		super.destroy();
	}
}
