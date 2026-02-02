package org.martin.dtos.responses;

public class TransactionResponse {
    private String message;
    private double originalAmount;
    private double discountAmount;
    private String transactionId;


    public  String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }
    public void setOriginalAmount(double originalAmount) {
        this.originalAmount =  originalAmount;
    }
    public double getDiscountAmount() {
        return discountAmount;
    }
    public void setDiscountAmount(double discountAmount) {
        this.discountAmount =  discountAmount;
    }
    public String getTransactionId(){
        return transactionId;
    }
    public void setTransactionId(String transactionId){
        this.transactionId = transactionId;
    }



}
