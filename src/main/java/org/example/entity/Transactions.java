package org.example.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transactions {
    private int userid;
    private Timestamp createdOn;
    private long accountNumber;
    private String transactionType;
    private BigDecimal amount;
    private int createdBy;
    private String description;

    public Transactions(int userid, long accountNumber, String TransactionType, BigDecimal amount,  String description,Timestamp createdOn) {
        this.userid = userid;
        this.createdOn = createdOn;
        this.accountNumber = accountNumber;
        this.amount = amount;
//        this.createdBy = createdBy;
        this.description = description;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "transactions{" +
                "userid=" + userid +
                ", accountNumber=" + accountNumber +
                ", transactionType=" + transactionType +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                // ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                '}';
    }
}
