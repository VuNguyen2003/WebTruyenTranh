package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;


public class storypageDAO {
	Connection conn = null;
	PreparedStatement preparedStmt = null;
	
	String chapterID = UUID.randomUUID().toString();
	
	public ArrayList<String> getStoryPage(int StoryID, String ChapterID) throws ClassNotFoundException, SQLException{
		ArrayList<String> list = new ArrayList<String>();
		if(conn == null)
			conn = ConnectionClass.initializeDatabase();
		String sql = "Select * from STORY Where TITLE like ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,"%" + ChapterID + "%");
		pstm.setInt(2,StoryID);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			list.add(rs.getString(1));
		}
		return list;
	}
}
