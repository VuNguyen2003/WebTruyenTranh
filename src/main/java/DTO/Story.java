package DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Story implements Serializable{
	private int storyId;
    private String title;
    private String uploadDate;
    private float rating;
    private String cover;
    private int favorite;
    private String author;
    private String summary;
    private String status;
    public Story() {
    }

    public Story(int storyId, String title, String uploadDate, float rating, String cover, int favorite, String author, String summary, String status) {
        this.storyId = storyId;
        this.title = title;
        this.uploadDate = uploadDate;
        this.rating = rating;
        this.cover = cover;
        this.favorite = favorite;
        this.author = author;
        this.summary = summary;
        this.status = status;
    }

    
    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String strDate) {
        this.uploadDate = strDate;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    
    public int getFavorite() {
    	return favorite;
    }
    
    public void setFavorite(int favorite) {
    	this.favorite = favorite;
    }
    
    public String getAuthor() {
    	return author;
    }
    
    public void setAuthor(String author) {
    	this.author = author;
    }
    
    public String getSummary() {
    	return summary;
    }
    
    public void setSummary(String summary) {
    	this.summary = summary;
    }
    
    public String getStatus() {
    	return status;
    }
    
    public void setStatus(String status) {
    	this.status = status;
    }
}
