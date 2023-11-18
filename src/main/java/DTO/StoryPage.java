package DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StoryPage implements Serializable{
	private String pageId;
    private String chapterId;
    private String pageContent;
    private int pageNumber;

    public StoryPage() {
    }

    public StoryPage(String pageId, String chapterId, String pageContent, int pageNumber) {
        this.pageId = pageId;
        this.chapterId = chapterId;
        this.pageContent = pageContent;
        this.pageNumber = pageNumber;
    }
    
    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }
    
    public int getPageNumber() {
    	return pageNumber;
    }
    
    public void setPageNumber(int pageNumber) {
    	this.pageNumber = pageNumber;
    }
}
