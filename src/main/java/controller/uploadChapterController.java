package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
import DTO.Chapter;
import DTO.Story;
import DTO.StoryPage;

@WebServlet("/uploadChapterController")
@MultipartConfig
public class uploadChapterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SAVE_DIR = "Resource/data/user";
    
    public uploadChapterController() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/upload-chapter.jsp");
        rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Part filePart = request.getPart("chaptercover"); // Retrieves <input type="file" name="chaptercover">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String appPath = "D:\\Desktop\\Code Projects\\JavaServerPage\\WebTruyenTranh\\src\\main\\webapp";
        String savePath = appPath + File.separator + SAVE_DIR;
        
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        filePart.write(savePath + File.separator + fileName);

        request.setAttribute("filePath", savePath + File.separator + fileName);
        
        String chapterName = request.getParameter("name_chapter");
		int chapterNumber = Integer.parseInt(request.getParameter("chapternumber"));
		
		// Create a new Chapter object
		Chapter chapter = new Chapter();
		storyDAO dao = new storyDAO();
		
		// Store the storyId in a session attribute
		HttpSession storySessionGet = request.getSession();
		int storyId = (Integer) storySessionGet.getAttribute("storyId");
		
		// Store the chapterId in a session attribute (pass to uploadpage)
        HttpSession storySessionSet = request.getSession();
        storySessionSet.setAttribute("chapterId", chapter.getChapterId());

		String chapterId = UUID.randomUUID().toString();
		chapter.setChapterId(chapterId);
		chapter.setStoryId(storyId);
		chapter.setChapterName(chapterName);
		chapter.setChapterNumber(chapterNumber);
		try {
			dao.inputChapter(chapter);
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/upload-page.jsp");
        rd.forward(request, response);
    }
}
