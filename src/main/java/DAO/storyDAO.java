package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import DTO.*;



public class storyDAO {
	Connection conn = null;
	PreparedStatement preparedStmt = null;
	
	//đưa cơ sở dữ liệu vào bảng story
	public void inputStory(Story story) throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try
	    {
			String sql = "INSERT INTO STORY(STORYID, TITLE, UPLOADDATE, LIKES, COMMENTS, REPORTS, RATING, COVER) VALUES (?,?,?,?,?,?,?,?)";
			preparedStmt = (PreparedStatement) conn.prepareStatement(sql);
			//thay thế biến thành dữ liệu đầu vào
			preparedStmt.setInt(1,story.getStoryId());
			preparedStmt.setString(2,story.getTitle());
			Calendar calendar = Calendar.getInstance();
			java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
			preparedStmt.setDate(3,date);
			preparedStmt.setFloat(7,story.getRating());
			preparedStmt.setString(8,story.getCover());
			preparedStmt.execute();
			System.out.println(sql);
	    }
		catch (Exception e){
			System.err.println("Got an exception!");
		    System.err.println(e.getMessage());
		}
	}
	
	
	// tải truyện từ database
	public ArrayList<Story> getPageStory(int startpage) throws ClassNotFoundException, SQLException {
		//lấy kết nối cơ sở dữ liệu
		if(conn == null)
			conn = ConnectionClass.initializeDatabase();
		
		//tạo list Story để lưu truyện về
		ArrayList<Story> list = new ArrayList<Story> ();
		//câu truy vấn
		String sql = "Select * from STORY LIMIT 20 OFFSET " + String.valueOf(startpage);
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		//lấy cơ sở dữ liệu vào lớp Story
		while (rs.next()) {
			int storyId = rs.getInt("STORYID");
			String title = rs.getString("TITLE");
			Date uploadDate = rs.getDate("UPLOADDATE");
			//format lại ngày tháng thành kiểu string "ngày/tháng/năm"
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = dateFormat.format(uploadDate);
			float rating = rs.getFloat("RATING");
			String cover = rs.getString("COVER");
			Story story = new Story();
			story.setStoryId(storyId);
			story.setTitle(title);
			story.setUploadDate(strDate);
			story.setRating(rating);
			story.setCover(cover);
			//lưu lớp story vào list story
			list.add(story);	
		}
		// trả về list story
		return list;
		
	}
	public static void main(String args[]) throws ClassNotFoundException, SQLException, ParseException {
		storyDAO dao = new storyDAO ();
		ArrayList<Story> list = dao.getPageStory(4);
		for (Story o : list) {
			System.out.println(o);
		}
		System.out.println(list.size());
		
	}
}

