package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import DTO.Comment;

public class commentDAO {
	Connection conn = null;
	
	public void insertComment(Comment cmt) throws SQLException, ClassNotFoundException {
		if(conn == null) {
	        conn = ConnectionClass.initializeDatabase();
	    }
	    String sql = "insert into comment values(?,?,?,?);";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setInt(4,this.getCount()+1);
	    ps.setInt(1,cmt.getUserID());
	    ps.setInt(2,cmt.getStoryId());
	    ps.setString(3,cmt.getComment());
	    ps.executeUpdate();
	    if(ps.executeUpdate() > 0) {
	    	System.out.println("Insert comment thành công");
	    }
	    else {
	    	System.out.println("Insert comment thất bại");
	    }
	}
	
	public int count = 0;
	
	public ArrayList<Comment> listComments() throws ClassNotFoundException, SQLException {
		if(conn == null) {
	        conn = ConnectionClass.initializeDatabase();
	    }
	    String sql = "select COMMENTID, c.USERID, STORYID, COMMENT, USERNAME from comment c join user u on c.USERID=u.USERID ORDER BY COMMENTID DESC;";
	    PreparedStatement ps = conn.prepareStatement(sql);
	    ResultSet rs = ps.executeQuery();
	    	    
	    ArrayList<Comment> list = new ArrayList<Comment>();
	    while (rs.next()) {
	    	count++;
	    	Comment cmt = new Comment();
	    	cmt.setUserId(rs.getInt("USERID"));
	    	cmt.setStoryID(rs.getInt("STORYID"));
	    	cmt.setComment(rs.getString("COMMENT"));
	    	cmt.setcommentId(rs.getInt("COMMENTID"));
	    	cmt.setUsername(rs.getString("USERNAME"));
	    	list.add(cmt);
	    }
	    return list;
	} 
	
	public int getCount() throws ClassNotFoundException, SQLException {
		return this.listComments().size();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
        commentDAO c = new commentDAO();
        //Comment cmt= new Comment(2,3,"hay lắm");
        for(Comment cm : c.listComments()) {
        	System.out.println(cm.getUsername());
        }
//        System.out.println(c.getCount());
    }
}
