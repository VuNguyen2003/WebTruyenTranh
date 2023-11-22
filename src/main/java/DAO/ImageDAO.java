package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageDAO {
	Connection conn = null;
	PreparedStatement preparedStmt = null;
	
	public String getImagePath(int storyId) throws SQLException, ClassNotFoundException {
        String imgPath = "";
        if(conn == null) {
	        conn = ConnectionClass.initializeDatabase();
	    }
        String sql = "SELECT COVER FROM STORY WHERE STORYID = " + storyId;
        preparedStmt = (PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs = preparedStmt.executeQuery();
        if(rs.next()){
            imgPath = rs.getString("COVER");
        }
        conn.close();
        
        return imgPath;
    }
}