package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.hashtagDAO;
import DTO.Hashtag;

@WebServlet(urlPatterns = "/category", name = "Category")
public class categryController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		hashtagDAO listtag = new hashtagDAO();
		ArrayList<Hashtag> list = new ArrayList<Hashtag>();
		try {
			list = listtag.getTag();
			request.setAttribute("listtag", list);
			request.getRequestDispatcher("category.jsp").forward(request, response);
		} catch (Exception e) {}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	public void destroy() {
		
		super.destroy();
	}
}
