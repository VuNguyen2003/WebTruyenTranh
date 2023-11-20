package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/detailController")
public class detailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public detailController() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		// Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/storydb", "root", "Nguyenhuutan01");

            // Create a statement

            HttpSession storySessionGet = request.getSession();
    		int storyId = (Integer) storySessionGet.getAttribute("storyId");
            
            String sql = "SELECT TITLE, AUTHOR FROM STORY WHERE STORYID = " + storyId;
            
            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);

            // Execute a query
            ResultSet resultSet = statement.executeQuery(sql);

            // Get data from the result set
            if (resultSet.next()) {
                String name_story = resultSet.getString("name_story");
                String author = resultSet.getString("author");

                // Set data as attributes
                request.setAttribute("name_story", name_story);
                request.setAttribute("author", author);
            }

            // Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("/upload-chapter.jsp");
        rd.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("/upload-chapter.jsp");
        rd.forward(request, response);
    }
}