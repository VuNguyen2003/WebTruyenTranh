package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import DTO.User;

public class favoriteDAO {
	
	Connection conn = null;
	PreparedStatement preparedStmt = null;
	
	public void setFavorite(int UserID, int StoryID) throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try
	    {
			String sql = "INSERT INTO FAVORITE(USERID, STORYID) VALUES (?,?)";
			preparedStmt = (PreparedStatement) conn.prepareStatement(sql);
			//thay thế biến thành dữ liệu đầu vào
			preparedStmt.setInt(1,UserID);
			preparedStmt.setInt(2,StoryID);
			preparedStmt.execute();
	    }
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void updateFavoritePlus(int userid, User ud) throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try {
			String sql = "UPDATE STORY SET FAVORITE = FAVORITE + 1;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("UPDATE thành công!");
		}catch(Exception e) {
			System.out.println("UPDATE thất bại!");
		}
	}
	
	public void updateFavoriteApart(int userid, User ud) throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try {
			String sql = "UPDATE STORY SET FAVORITE = FAVORITE - 1;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("UPDATE thành công!");
		}catch(Exception e) {
			System.out.println("UPDATE thất bại!");
		}
	}
}
