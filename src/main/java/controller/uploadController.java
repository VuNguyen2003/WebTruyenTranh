package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.storyDAO;
import DTO.Find;
import DTO.Story;

@WebServlet("/uploadController")
@MultipartConfig
public class uploadController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String SAVE_DIR = "user";

    public uploadController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/upload.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("cover"); // Retrieves <input type="file" name="cover">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        filePart.write(savePath + File.separator + fileName);

        request.setAttribute("filePath", savePath + File.separator + fileName);
        //RequestDispatcher rd = request.getRequestDispatcher("/upload.jsp");
        //rd.forward(request, response);
        // Get form data
        String storyName = request.getParameter("name_story");
        String author = request.getParameter("author");
        String[] tags = request.getParameterValues("tag");
        
        // Create a new Story object
        Story story = new Story();
        story.setTitle(storyName);
        story.setAuthor(author);
        story.setCover(fileName);
        
        // Save the Story object to the database
        storyDAO dao = new storyDAO();
        try {
			dao.inputStory(story);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        // Save the tags to the database
        for (String tag : tags) {
            Find find = new Find();
            find.setStoryId(story.getStoryId());
            find.setTagId(Integer.parseInt(tag));
            try {
				dao.inputFind(find);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
        
        System.out.println("Upload success!");
    }

}