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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.storyDAO;
import DTO.Find;
import DTO.Post;
import DTO.Story;
import DTO.User;

@WebServlet("/uploadController")
@MultipartConfig
public class uploadController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String SAVE_DIR = "Resource/data/user";

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
        String appPath = "D:\\Desktop\\Code Projects\\JavaServerPage\\WebTruyenTranh\\src\\main\\webapp";
        String savePath = appPath + File.separator + SAVE_DIR;

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        filePart.write(savePath + File.separator + fileName);

        request.setAttribute("filePath", savePath + File.separator + fileName);

        // Get form data
        String storyName = request.getParameter("name_story");
        String author = request.getParameter("author");
        String[] tags = request.getParameterValues("tag");
        
        // Create a new Story object
        Story story = new Story();
        
        // Save the Story object to the database
        storyDAO dao = new storyDAO();
        
        int maxStoryId = 0;
        try {
            maxStoryId = dao.getMaxStoryId();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        // storyId tự động tăng
        story.setStoryId(maxStoryId + 1);
        
        // Store the storyId in a session attribute
        HttpSession session = request.getSession();
        session.setAttribute("storyId", story.getStoryId());
        story.setTitle(storyName);
        story.setAuthor(author);
        // lưu đường dẫn của file ảnh
        story.setCover(savePath + File.separator + fileName);
        
        
        try {
			dao.inputStory(story);
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			e.printStackTrace();
		}
        
        // Save the tags to the database
        for (String tag : tags) {
            Find find = new Find();
            find.setStoryId(story.getStoryId());
            find.setTagId(Integer.parseInt(tag));
            try {
				dao.inputFind(find);
			} catch (ClassNotFoundException | SQLException | ParseException e) {
				e.printStackTrace();
			}
        }
        User user = new User();
        Post post = new Post();
        post.setUserId(user.getUserID());
        post.setStoryId(story.getStoryId());
        
        try {
        	dao.inputPost(post);
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			e.printStackTrace();
		}
        System.out.println("Upload success!");
        
        RequestDispatcher rd = request.getRequestDispatcher("/detail-comic.jsp");
        rd.forward(request, response);
    }

}