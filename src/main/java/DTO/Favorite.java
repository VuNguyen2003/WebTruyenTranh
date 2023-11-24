package DTO;

public class Favorite {
    private int USERID;
    private int STORYID;
    
    public Favorite() {}
    
    public Favorite(int USERID, int STORYID) {
        this.USERID = USERID;
        this.STORYID = STORYID;
    }

    public int getUSERID() {
        return USERID;
    }

    public void setUSERID(int USERID) {
        this.USERID = USERID;
    }

    public int getSTORYID() {
        return STORYID;
    }

    public void setSTORYID(int STORYID) {
        this.STORYID = STORYID;
    }
}

