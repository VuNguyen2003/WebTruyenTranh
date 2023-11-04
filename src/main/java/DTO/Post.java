package DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Post implements Serializable{
	private int userId;
    private int storyId;

    public Post() {
    }

    public Post(int userId, int storyId) {
        this.userId = userId;
        this.storyId = storyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }
}
