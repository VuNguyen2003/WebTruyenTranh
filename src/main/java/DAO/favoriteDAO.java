package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import DTO.Favorite;

public class favoriteDAO {
	Connection conn = null;

	//insert data
	public void insert(Favorite fav) throws ClassNotFoundException, SQLException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try
	    {
			String sql = "INSERT INTO favorite VALUES(?,?); ";
					
			PreparedStatement ps = conn.prepareStatement(sql);
			//thay thế biến thành dữ liệu đầu vào
			ps.setInt(1,fav.getUSERID());
			ps.setInt(2,fav.getSTORYID());
			
			ps.executeUpdate();
			this.updateFavoritePlus(fav.getSTORYID());
			if(ps.executeUpdate() > 0) {
				System.out.println("User đã thêm truyện vào mục yêu thích");
			}
	    }catch (Exception e){
			
		}
	}
	
	public void remove(Favorite fav) throws ClassNotFoundException, SQLException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try
	    {
			String sql = "DELETE FROM favorite WHERE USERID=? AND STORYID=?; ";
					
			PreparedStatement ps = conn.prepareStatement(sql);
			//thay thế biến thành dữ liệu đầu vào
			ps.setInt(1,fav.getUSERID());
			ps.setInt(2,fav.getSTORYID());
			
			ps.executeUpdate();
			this.updateFavoriteApart(fav.getSTORYID());
			if(ps.executeUpdate() > 0) {
				System.out.println("Xóa favorite thành công");
			}
	    }catch (Exception e){
			
		}
	}
	
	public void updateFavoritePlus(int storyid) throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try {
			String sql = "UPDATE STORY SET FAVORITE = FAVORITE + 1 WHERE STORYID = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storyid);
			ps.executeUpdate();
			System.out.println("UPDATE FavoritePlus thành công!");
		}catch(Exception e) {
			System.out.println("UPDATE FavoritePlus thất bại!");
		}
	}
	
	public void updateFavoriteApart(int storyid) throws ClassNotFoundException, SQLException, ParseException {
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		try {
			String sql = "UPDATE STORY SET FAVORITE = FAVORITE - 1 WHERE STORYID = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, storyid);
			ps.executeUpdate();
			System.out.println("update favorite trong story thành công!");
		}catch(Exception e) {
			System.out.println("update favorite trong story thất bại");
		}
	}
	
	public int checkfavorite (Favorite fav) throws ClassNotFoundException, SQLException, ParseException {
		
		if(conn == null) {
			conn = ConnectionClass.initializeDatabase();
		}
		String sql = "select count(*) from FAVORITE where USERID  = ? and STORYID = ?;";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		//thay thế biến thành dữ liệu đầu vào
		ps.setInt(1,fav.getUSERID());
		ps.setInt(2,fav.getSTORYID());
		ResultSet rs = ps.executeQuery();
		rs.next();
		int c = rs.getInt(1);
		return c;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        favoriteDAO fdao = new favoriteDAO();
        Favorite fav = new Favorite(2,4); 
        //fdao.remove(fav);
        
        System.out.println(fdao.checkfavorite(fav));
    }
	
	
		
}
