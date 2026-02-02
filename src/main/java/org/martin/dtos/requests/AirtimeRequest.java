package org.martin.dtos.requests;

public class AirtimeRequest {
    private String sourceAccount;
    private String networkProvider;
    private double amount;
    private String phoneNumber;

    public String getSourceAccount() {
        return sourceAccount;
    }
    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getNetworkProvider() {
        return networkProvider;
    }
    public void setNetworkProvider(String networkProvider) {
        this.networkProvider = networkProvider;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
