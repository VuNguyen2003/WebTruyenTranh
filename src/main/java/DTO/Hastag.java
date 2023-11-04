package DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Hastag implements Serializable {
	private int tagId;
    private String tagName;

    public Hastag() {
    }

    public Hastag(int tagId, String tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
