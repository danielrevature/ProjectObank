package org.example.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class MainAccount {

   private int userId;
   private long accountNumber;
   private String accountType;
   private BigDecimal balance;
   private Timestamp lastUpdated;

    public MainAccount(int userId, long accountNumber, String accountType, BigDecimal balance, Timestamp lastUpdated) {
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.lastUpdated = lastUpdated;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "MainAccount{" +
                "userId=" + userId +
                ", accountNumber=" + accountNumber +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
