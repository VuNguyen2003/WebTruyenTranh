package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.*;
import DTO.*;

@WebServlet(urlPatterns = "/hastagsearch", name = "hastagSearch")
public class hastagSearchController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hashtagDAO listtag = new hashtagDAO();
		ArrayList<Hashtag> list = new ArrayList<Hashtag>();
		try {
			list = listtag.getTag();
			request.setAttribute("listtag", list);
			request.getRequestDispatcher("adv-search.jsp").forward(request, response);
		} catch (Exception e) {}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void destroy() {
		
		super.destroy();
	}
}
