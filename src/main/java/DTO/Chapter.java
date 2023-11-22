package DTO;

import java.io.Serializable;

@SuppressWarnings("serial")

public class Chapter implements Serializable {
    private String chapterId;
    private int storyId;
    private String chapterName;
    private int chapternumber;

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
    
    public int getChapterNumber() {
    	return chapternumber;
    }
    
    public void setChapterNumber(int chapternumber) {
    	this.chapternumber = chapternumber;
    }
}
