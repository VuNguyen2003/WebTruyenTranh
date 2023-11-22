package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;

import javax.mail.Folder;
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
    	response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
    	
    	Part filePart = request.getPart("cover"); // Retrieves <input type="file" name="cover">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        System.out.println(fileName);
        
        //lưu file ảnh vào server----------------------------------------
        String projectPath = System.getProperty("user.dir");

        // Tạo một đối tượng File với đường dẫn của project
        File projectDirectory = new File(projectPath);

        // Lấy đường dẫn tuyệt đối của project
        String absolutePath = projectDirectory.getAbsolutePath();

        System.out.println("Đường dẫn tuyệt đối của project trong Eclipse: " + absolutePath);
        String uploadPath = System.getProperty("user.dir")+"\\"+fileName;
    	System.out.println(uploadPath);
        try {
        	FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = filePart.getInputStream();
			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
			System.out.println("lưu vào server thành công!");
		} catch (Exception e) {
			e.printStackTrace();
		}
        //----------------------------------------------------------------
        //filePart.write(savePath + File.separator + fileName);
        //request.setAttribute("filePath", savePath + File.separator + fileName);
        //RequestDispatcher rd = request.getRequestDispatcher("/upload.jsp");
        //rd.forward(request, response);
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
        
        story.setStoryId(maxStoryId + 1);
        
        // Store the storyId in a session attribute
        HttpSession session = request.getSession();
        session.setAttribute("storyId", story.getStoryId());
        story.setTitle(storyName);
        story.setAuthor(author);
        if(fileName!="") {
        	story.setCover(fileName);
        }
        
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
        /*
        User user = new User();
        Post post = new Post();
        post.setUserId(user.getUserID());
        post.setStoryId(story.getStoryId());
        
        
        System.out.println("Upload success!");
        request.setAttribute("story",story);
        request.getRequestDispatcher("upload.jsp").forward(request, response);
    }
    
    public static void main (String[] args) {
    	File f = new File("src\\main\\webapp\\Resource\\img\\images");
    	String path = f.getAbsolutePath()+"\\"+"001.jpg";
    	String imgPath = path.replace('\\', '/');
    	System.out.println(path);
    }
}