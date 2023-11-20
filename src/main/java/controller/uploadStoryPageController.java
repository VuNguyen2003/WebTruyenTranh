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
import DTO.StoryPage;

@WebServlet("/uploadStoryPageController")
@MultipartConfig
public class uploadStoryPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SAVE_DIR = "Resource/data/user";
    
    public uploadStoryPageController() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/upload-page.jsp");
        rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // handle multiple file upload
		try {
			StoryPage page = new StoryPage();
			storyDAO dao = new storyDAO();
			// Get all the parts from the request
			List<Part> fileParts = request.getParts().stream().filter(part -> "content[]".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="content[]">
			HttpSession storySessionGet = request.getSession();
			String chapterId = (String) storySessionGet.getAttribute("chapterId");
			
			for (Part filePart : fileParts) {
				String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
				String appPath = "D:\\Desktop\\Code Projects\\JavaServerPage\\WebTruyenTranh\\src\\main\\webapp";
		        String savePath = appPath + File.separator + SAVE_DIR;
				
				File fileSaveDir = new File(savePath);
				if (!fileSaveDir.exists()) {
					fileSaveDir.mkdir();
				}
				
				filePart.write(savePath + File.separator + fileName);

				request.setAttribute("filePath", savePath + File.separator + fileName);
				
				int maxPageNumber = dao.getMaxPageNumber();
				
				page.setPageId(UUID.randomUUID().toString());
				page.setChapterId(chapterId);
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
