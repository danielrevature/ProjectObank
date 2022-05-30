package org.example.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transactions {

    private int transactionId;
    private int userId;
    private Timestamp createdOn;
    private long accountNumber;
    private String transactionType;
    private float amount;
    private int createdBy;
    private String description;

    public Transactions(int transactionId, int userId,  long accountNumber, String transactionType, float amount, String description,int createdBy, Timestamp createdOn) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.createdOn = createdOn;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.createdBy = createdBy;
        this.description = description;

    }

    public Transactions(int userId,  long accountNumber, String transactionType, float amount, String description, int createdBy, Timestamp createdOn) {

        this.userId = userId;
        this.createdOn = createdOn;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.createdBy = createdBy;
        this.description = description;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return "Transactions{" +
                "transactionId=" + transactionId +
                ", userId=" + userId +
                ", createdOn=" + createdOn +
                ", accountNumber=" + accountNumber +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                ", createdBy=" + createdBy +
                ", description='" + description + '\'' +
                '}';
    }
}