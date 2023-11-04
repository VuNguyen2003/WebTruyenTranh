package DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bankaccount implements Serializable{
	private int accountId;
    private int userId;
    private String accountNumber;
    private String ownerName;

    public Bankaccount() {
    }

    public Bankaccount(int accountId, int userId, String accountNumber, String ownerName) {
        this.accountId = accountId;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
