package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import DTO.*;

public class hashtagDAO {
	Connection conn = null;
	PreparedStatement preparedStmt = null;
	
	public ArrayList<Hashtag> getTag() throws ClassNotFoundException, SQLException{
		ArrayList<Hashtag> listTag = new ArrayList<Hashtag>();
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		String sql = "Select * from HASHTAG ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		//lấy cơ sở dữ liệu vào lớp Story
		while (rs.next()) {
			int TagID = rs.getInt("TAGID");
			String TagName = rs.getString("TAGNAME");
			Hashtag Tags = new Hashtag();
			Tags.setTagId(TagID);
			Tags.setTagName(TagName);
			//lưu lớp story vào list story
			listTag.add(Tags);
			
		}
		return listTag;
	}
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException, ParseException {
		hashtagDAO dao = new hashtagDAO ();
		ArrayList<Hashtag> i = new ArrayList<Hashtag>();
		i = dao.getTag();
		for (Hashtag str : i) {
			System.out.println(str.getTagName());
		}
	}
}
