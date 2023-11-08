package DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Comment implements Serializable {
	private int userId;
	private int storyId;
	private String comment;
	
	public Comment() { }
	public Comment(int userId, int storyId, String comment) {
        this.userId = userId;
        this.storyId = storyId;
        this.comment = comment;
    }
	
	public int getUserID() {
        return userId;
    }

	public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getUserId() {
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
}
