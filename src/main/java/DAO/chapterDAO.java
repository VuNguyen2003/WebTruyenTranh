package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.*;
public class chapterDAO {
	Connection conn = null;
	PreparedStatement preparedStmt = null;
	
	public ArrayList<Chapter> getChapterList(int StoryID) throws ClassNotFoundException, SQLException{
		ArrayList<Chapter> list = new ArrayList<Chapter>();
		if(conn == null)
			conn = ConnectionClass.initializeDatabase();
		String sql = "Select * from Chapter Where STORYID = ? order by CHAPTERNUMBER";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1,StoryID);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			Chapter chapter = new Chapter();
			String chapterid = rs.getString("CHAPTERID");
			int storyid = rs.getInt("STORYID");
			String chaptername = rs.getString("CHAPTERNAME");
			int chapternumber = rs.getInt("CHAPTERNUMBER");
			chapter.setChapterId(chapterid);
			chapter.setChapterName(chaptername);
			chapter.setChapterNumber(chapternumber);
			chapter.setStoryId(storyid);
			list.add(chapter);
		}
		return list;
	}
}
