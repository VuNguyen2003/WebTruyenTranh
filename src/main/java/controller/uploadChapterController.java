package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import DAO.storyDAO;
import DTO.Chapter;
import DTO.Story;
import DTO.StoryPage;

@WebServlet("/uploadChapterController")
@MultipartConfig
public class uploadChapterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SAVE_DIR = "user";
    
    public uploadChapterController() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/upload-chapter.jsp");
        rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chapterName = request.getParameter("name_chapter");
        
        try {
            // Get all the parts of the request
            Collection<Part> parts = request.getParts();

            // Loop through all the parts
            for (Part part : parts) {
                // Check if the part is a file (i.e., has a content type)
                if (part.getContentType() != null) {
                    // Get the file name
                    String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
                    String appPath = request.getServletContext().getRealPath("");
                    String savePath = appPath + File.separator + SAVE_DIR;

                    File fileSaveDir = new File(savePath);
                    if (!fileSaveDir.exists()) {
                        fileSaveDir.mkdir();
                    }

                    part.write(savePath + File.separator + fileName);

                    request.setAttribute("filePath", savePath + File.separator + fileName);    

                    Chapter chapter = new Chapter();
                    Story story = new Story();
                    StoryPage page = new StoryPage();

                    storyDAO dao = new storyDAO();

                    chapter.setChapterId(UUID.randomUUID().toString());
                    chapter.setStoryId(story.getStoryId());
                    chapter.setChapterName(chapterName);

                    try {
                        dao.inputChapter(chapter);
                    }
                    catch (ClassNotFoundException | SQLException | ParseException e) {
                        e.printStackTrace();
                    }

                    page.setPageId(UUID.randomUUID().toString());
                    page.setChapterId(chapter.getChapterId());
                    page.setPageContent(savePath + File.separator + fileName);

                    try {
                        dao.inputStoryPage(page);
                    } catch (ClassNotFoundException | SQLException | ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }

}