package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
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
    private static final String SAVE_DIR = "user";
    
    public uploadChapterController() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/upload-chapter.jsp");
        rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // handle multiple file upload
		try {
			String chapterName = request.getParameter("name_chapter");
			
			HttpSession session = request.getSession();
			int storyId = (Integer) session.getAttribute("storyId");

			Chapter chapter = new Chapter();
			StoryPage page = new StoryPage();

			storyDAO dao = new storyDAO();

			String chapterId = UUID.randomUUID().toString();
			chapter.setChapterId(chapterId);
			chapter.setStoryId(storyId);
			chapter.setChapterName(chapterName);
			
			try {
				dao.inputChapter(chapter);
			} catch (ClassNotFoundException | SQLException | ParseException e) {
				e.printStackTrace();
			}
			
			// Get all the parts from the request
			List<Part> fileParts = request.getParts().stream().filter(part -> "content[]".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="content[]">
			
			for (Part filePart : fileParts) {
				String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
				String appPath = request.getServletContext().getRealPath("");
				String savePath = appPath + File.separator + SAVE_DIR;
				
				File fileSaveDir = new File(savePath);
				if (!fileSaveDir.exists()) {
					fileSaveDir.mkdir();
				}
				
				filePart.write(savePath + File.separator + fileName);

				request.setAttribute("filePath", savePath + File.separator + fileName);
				
				int maxPageNumber = dao.getMaxPageNumber();
				
				page.setPageId(UUID.randomUUID().toString());
				page.setChapterId(chapter.getChapterId());
				page.setPageContent(savePath + File.separator + fileName);
				page.setPageNumber(maxPageNumber);
				
				try {
					dao.inputStoryPage(page);
				} catch (ClassNotFoundException | SQLException | ParseException e) {
					e.printStackTrace();
				}
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
    }
}
