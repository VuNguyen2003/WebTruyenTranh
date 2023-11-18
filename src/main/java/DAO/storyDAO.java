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
	
	// get storyId tránh lặp khóa
	public int getMaxStoryId() throws SQLException, ClassNotFoundException {
	    int maxStoryId = 0;
	    if(conn == null) {
	        conn = ConnectionClass.initializeDatabase();
	    }
	    String sql = "SELECT MAX(STORYID) AS MAX_ID FROM STORY";
	    preparedStmt = (PreparedStatement) conn.prepareStatement(sql);
	    ResultSet rs = preparedStmt.executeQuery();
	    if (rs.next()) {
	        maxStoryId = rs.getInt("MAX_ID");
	    }
	    return maxStoryId;
	}

	// đưa dữ liệu vào bảng story
	public void inputStory(Story story) throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try
	    {
			Calendar calendar = Calendar.getInstance();
			java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
			
			String sql = "INSERT INTO STORY(STORYID, TITLE, UPLOADDATE, RATING, COVER, FAVORITE, AUTHOR, SUMMARY, STATUS) VALUES (?,?,?,?,?,?,?,?,?)";
			preparedStmt = (PreparedStatement) conn.prepareStatement(sql);
			//thay thế biến thành dữ liệu đầu vào
			preparedStmt.setInt(1,story.getStoryId());
			preparedStmt.setString(2,story.getTitle());
			preparedStmt.setDate(3,date);
			preparedStmt.setFloat(4,story.getRating());
			preparedStmt.setString(5,story.getCover());
			preparedStmt.setInt(6,story.getFavorite());
			preparedStmt.setString(7,story.getAuthor());
			preparedStmt.setString(8,story.getSummary());
			preparedStmt.setString(9,story.getStatus());
			preparedStmt.execute();
			System.out.println(sql);
	    }
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	// đưa dữ liệu vào bảng hashtag
	public void inputFind(Find find) throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try {
			String sql = "INSERT INTO FIND(STORYID, TAGID) VALUES (?,?)";
			preparedStmt = (PreparedStatement) conn.prepareStatement(sql);
			
			preparedStmt.setInt(1,find.getStoryId());
			preparedStmt.setInt(2,find.getTagId());
			
			preparedStmt.execute();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	// tải truyện từ database
	public ArrayList<Story> getStory(int startpage) throws ClassNotFoundException, SQLException {
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
			int favorite = rs.getInt("FAVORITE");
			Story story = new Story();
			story.setStoryId(storyId);
			story.setTitle(title);
			story.setUploadDate(strDate);
			story.setRating(rating);
			story.setCover(cover);
			story.setFavorite(favorite);
			//lưu lớp story vào list story
			list.add(story);
		}
		// trả về list story
		return list;
		
	}
	
	public ArrayList<Story> searchStory(int indexPage, String nameStory) throws ClassNotFoundException, SQLException{
		ArrayList<Story> list = new ArrayList<Story>();
		if(conn == null)
			conn = ConnectionClass.initializeDatabase();
		String sql = "Select * from STORY Where TITLE like ? LIMIT 20 OFFSET ? ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,"%" + nameStory + "%");
		pstm.setInt(2,indexPage);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			int storyId = rs.getInt("STORYID");
			String title = rs.getString("TITLE");
			Date uploadDate = rs.getDate("UPLOADDATE");
			//format lại ngày tháng thành kiểu string "ngày/tháng/năm"
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = dateFormat.format(uploadDate);
			float rating = rs.getFloat("RATING");
			String cover = rs.getString("COVER");
			int favorite = rs.getInt("FAVORITE");
			String author = rs.getString("AUTHOR");
			String summary = rs.getString("SUMMARY");
			String status = rs.getString("STATUS");
			Story story = new Story();
			story.setStoryId(storyId);
			story.setTitle(title);
			story.setUploadDate(strDate);
			story.setRating(rating);
			story.setCover(cover);
			story.setFavorite(favorite);
			story.setAuthor(author);
			story.setSummary(summary);
			story.setStatus(status);
			//lưu lớp story vào list story
			list.add(story);
		}
		return list;
	}
	
	public int CountPage() throws ClassNotFoundException, SQLException {
		if(conn == null)
			conn = ConnectionClass.initializeDatabase();
		int NumbPage = 0;
		String sql = "Select count(*) from STORY";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next())
			NumbPage = rs.getInt(1);
		return NumbPage;
	}
	
	public int CountSearch(String nameStory) throws ClassNotFoundException, SQLException {
		if(conn == null)
			conn = ConnectionClass.initializeDatabase();
		int NumbPage = 0;
		String sql = "Select count(*) from STORY where TITLE like ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1,"%" + nameStory + "%");
		ResultSet rs = pstm.executeQuery();
		while(rs.next())
			NumbPage = rs.getInt(1);
		return NumbPage;
	}
	
    public ArrayList<Story> searchStoriesByTags(int indexPage, String[] tagNames) throws ClassNotFoundException, SQLException {
    	ArrayList<Story> results = new ArrayList<Story>();
    	if(conn == null)
			conn = ConnectionClass.initializeDatabase();
    	StringBuilder query = new StringBuilder();

    	// append the first part of the query
    	query.append("SELECT * FROM STORY WHERE STORYID in (");

    	// append the first subquery
    	query.append("SELECT f1.STORYID FROM FIND f1");

    	// loop through the tag ids
    	for (int i = 0; i < tagNames.length; i++) {
    	  // append the join part for each tag id
    	  query.append(" INNER JOIN FIND f").append(i + 2).append(" ON f1.STORYID = f").append(i + 2).append(".STORYID");
    	}

    	// append the where part
    	query.append(" WHERE ");

    	// loop through the tag ids again
    	for (int i = 0; i < tagNames.length; i++) {
    	  // append the condition for each tag id
    	  query.append("f").append(i + 1).append(".TAGID = ? ");
    	  // append the and operator if not the last tag id
    	  if (i < tagNames.length - 1) {
    	    query.append("AND ");
    	  }
    	}

    	// append the closing parenthesis
    	query.append(")LIMIT 20 OFFSET " + String.valueOf(indexPage));

    	// create a prepared statement object
    	PreparedStatement ps = conn.prepareStatement(query.toString());

    	// loop through the tag ids again
    	for (int i = 0; i < tagNames.length; i++) {
    	  // set the values of the parameters
    	  ps.setInt(i + 1, Integer.parseInt(tagNames[i]));
    	}

    	// execute the query and get the result set
    	ResultSet rs = ps.executeQuery();
        
        try (PreparedStatement statement = conn.prepareStatement(query.toString())) {
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
    			results.add(story);
            }
        }
        
        return results;
    }
    
    
    public int countSearchStoriesByTags(String[] tagNames) throws ClassNotFoundException, SQLException {
    	int countPage = 0;
    	if(conn == null)
			conn = ConnectionClass.initializeDatabase();
    	StringBuilder query = new StringBuilder();

    	// append the first part of the query
    	query.append("SELECT count(*) FROM STORY WHERE STORYID in (");

    	// append the first subquery
    	query.append("SELECT f1.STORYID FROM FIND f1");

    	// loop through the tag ids
    	for (int i = 0; i < tagNames.length; i++) {
    	  // append the join part for each tag id
    	  query.append(" INNER JOIN FIND f").append(i + 2).append(" ON f1.STORYID = f").append(i + 2).append(".STORYID");
    	}

    	// append the where part
    	query.append(" WHERE ");

    	// loop through the tag ids again
    	for (int i = 0; i < tagNames.length; i++) {
    	  // append the condition for each tag id
    	  query.append("f").append(i + 1).append(".TAGID = ? ");
    	  // append the and operator if not the last tag id
    	  if (i < tagNames.length - 1) {
    	    query.append("AND ");
    	  }
    	}

    	// append the closing parenthesis
    	query.append(")");

    	// create a prepared statement object
    	PreparedStatement ps = conn.prepareStatement(query.toString());

    	// loop through the tag ids again
    	for (int i = 0; i < tagNames.length; i++) {
    	  // set the values of the parameters
    	  ps.setInt(i + 1, Integer.parseInt(tagNames[i]));
    	}

    	// execute the query and get the result set
    	ResultSet rs = ps.executeQuery();
        rs.next();
    	countPage = rs.getInt(1);
        return countPage;
    }
    
    public Story introStory(int ID)  throws ClassNotFoundException, SQLException, ParseException{
    	Story story = new Story();
    	if(conn == null)
			conn = ConnectionClass.initializeDatabase();
		String sql = "Select * from STORY where STORYID like ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1,ID);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			int storyId = rs.getInt("STORYID");
			String title = rs.getString("TITLE");
			Date uploadDate = rs.getDate("UPLOADDATE");
			//format lại ngày tháng thành kiểu string "ngày/tháng/năm"
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String strDate = dateFormat.format(uploadDate);
			float rating = rs.getFloat("RATING");
			String cover = rs.getString("COVER");
			String author = rs.getString("AUTHOR");
			String summary = rs.getString("SUMMARY");
			String status = rs.getString("STATUS");
			story.setStoryId(storyId);
			story.setTitle(title);
			story.setUploadDate(strDate);
			story.setRating(rating);
			story.setCover(cover);
			story.setAuthor(author);
			story.setSummary(summary);
			story.setStatus(status);
		}
    	return story;
    }
    
	public static void main(String args[]) throws ClassNotFoundException, SQLException, ParseException {
		ArrayList<Story> results = new ArrayList<Story>();
		storyDAO dao = new storyDAO();
		String[] listtag = {"20","1"};
		results = dao.searchStoriesByTags(0,listtag);
		for (Story e : results) {
            System.out.println(e.getTitle());
        }
		
	}
	
	
}

