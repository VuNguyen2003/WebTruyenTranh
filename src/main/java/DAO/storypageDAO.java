package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import DTO.*;


public class storypageDAO {
	Connection conn = null;
	PreparedStatement preparedStmt = null;
	
	
	public ArrayList<StoryPage> getStoryPage(String ChapterID , int Chapternumb) throws ClassNotFoundException, SQLException{
		ArrayList<StoryPage> list = new ArrayList<StoryPage>();
		if(conn == null)
			conn = ConnectionClass.initializeDatabase();
		String sql = "Select * from STORYPAGE Where CHAPTERID = (select CHAPTERID  from CHAPTER where STORYID = ? and CHAPTERNUMBER = ?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,ChapterID);
		pstm.setInt(2,Chapternumb);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			StoryPage story = new StoryPage();
			String pageid = rs.getString("PAGEID");
			String chapterid = rs.getString("CHAPTERID");
			String pagecontent = rs.getString("PAGECONTENT");
			int pagenumber = rs.getInt("PAGENUMBER");
			story.setChapterId(chapterid);
			story.setPageContent(pagecontent);
			story.setPageId(pageid);
			story.setPageNumber(pagenumber);
			list.add(story);
		}
		return list;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
    }
}
