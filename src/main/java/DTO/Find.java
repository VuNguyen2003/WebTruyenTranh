package DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Find implements Serializable{
	private int storyId;
    private int tagId;

    public Find() {
    }

    public Find(int storyId, int tagId) {
        this.storyId = storyId;
        this.tagId = tagId;
    }

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }
}
