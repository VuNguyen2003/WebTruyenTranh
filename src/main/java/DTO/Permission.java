package DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Permission implements Serializable {
	private int perId;
    private String perName;

    public Permission() {
    }

    public Permission(int perId, String perName) {
        this.perId = perId;
        this.perName = perName;
    }

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }
}
