package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.Story;

public class detailDAO {
	Connection conn = null;
	PreparedStatement preparedStmt = null;
	
	public Story getStoryDetail(int storyId) throws ClassNotFoundException, SQLException {
		Story story = new Story();
		if(conn == null) {
	        conn = ConnectionClass.initializeDatabase();
	    }
		String sql = "SELECT TITLE, AUTHOR, SUMMARY FROM STORY WHERE STORYID = " + storyId;
		preparedStmt = (PreparedStatement) conn.prepareStatement(sql);
	    ResultSet rs = preparedStmt.executeQuery();
	    
	    String title = rs.getString("TITLE");
	    String author = rs.getString("AUTHOR");
	    String summary = rs.getString("SUMMARY");
	    
	    story.setTitle(title);
	    story.setAuthor(author);
	    story.setSummary(summary);
	    
	    return story;
	}
}