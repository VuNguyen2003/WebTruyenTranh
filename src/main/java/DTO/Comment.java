package DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Comment implements Serializable {
	private int commentId;
	private int userId;
	private int storyId;
	private String comment;
	private String username;
	
	public Comment() { }
	public Comment(int userId, int storyId, String comment) {
        this.userId = userId;
        this.storyId = storyId;
        this.comment = comment;
    }
	
	public int getcommentId() {
        return commentId;
    }

	public void setcommentId(int commentId) {
        this.commentId = commentId;
    }
	
	public int getUserID() {
        return userId;
    }

	public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getStoryId() {
        return storyId;
    }
    
    public void setStoryID(int storyId) {
        this.storyId = storyId;
    }
    
    public String getComment() {
    	return comment;
    }
    
    public void setComment(String comment) {
    	this.comment = comment;
    }
    
    public String getUsername() {
    	return username;
    }
    
    public void setUsername(String username) {
    	this.username = username;
    }
}
