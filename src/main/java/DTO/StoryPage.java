package DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StoryPage implements Serializable{
	private String pageId;
    private int storyId;
    private String pageContent;
    private String chapter;

    public StoryPage() {
    }

    public StoryPage(String pageId, int storyId, String pageContent, String chapter) {
        this.pageId = pageId;
        this.storyId = storyId;
        this.pageContent = pageContent;
        this.chapter = chapter;
    }

    
    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
}
