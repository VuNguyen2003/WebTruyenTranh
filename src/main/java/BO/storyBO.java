package BO;

import java.sql.SQLException;
import java.util.ArrayList;
import DAO.storyDAO;
import DTO.Story;

public class storyBO {
	//khởi tạo StoryBO
	storyBO story = new storyBO();
	
	
	
	// gọi lớp dữ liệu story (giống cách sử dụng của dataprovider của môn cnpm)
	public static ArrayList<Story> listStory(int offset) throws ClassNotFoundException, SQLException {
		storyDAO storydao = new storyDAO();
		return storydao.getPageStory(offset);
	}
}
