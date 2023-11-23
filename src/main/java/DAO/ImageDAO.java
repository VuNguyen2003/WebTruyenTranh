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
        String absPath = replaceBackslash(imgPath);
        String finalPath = trimPath(absPath);
        conn.close();
        
        return finalPath;
    }
	public String replaceBackslash(String str) {
	    return str.replace("\\", "/");
	}
	public String trimPath(String absolutePath) {
	    String relativePath = "Resource/data/user";
	    int index = absolutePath.indexOf(relativePath);
	    if (index != -1) {
	        return absolutePath.substring(index);
	    } else {
	        return absolutePath;
	    }
	}
}