package org.martin.data.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
public class Account {
    @Id
    private String accountNumber;
    private String customerId;
    private double balance;

    public Account(){};


    public String getAccoutNumber() {
        return accountNumber;
    }
    public void setAccoutNumber(String accoutNumber) {
        this.accountNumber = accoutNumber;
    }
    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
