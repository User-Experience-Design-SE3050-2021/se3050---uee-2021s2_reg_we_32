package com.androiddev.peopleswave.model;

import java.io.Serializable;

public class CreditCardPayment implements Serializable {

    private String fromAcc;
    private String toAcc;
    private String amount;
    private String paymentDate;
    private String otp;
    private String paymentID;

    public CreditCardPayment(){}

    public CreditCardPayment(String fromAcc, String toAcc, String amount, String paymentDate) {
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
        this.amount = amount;
        this.paymentDate = paymentDate;

    }

    public CreditCardPayment(String fromAcc, String toAcc, String amount, String paymentDate, String otp) {
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.otp = otp;
    }

    public String getFromAcc() {
        return fromAcc;
    }

    public void setFromAcc(String fromAcc) {
        this.fromAcc = fromAcc;
    }

    public String getToAcc() {
        return toAcc;
    }

    public void setToAcc(String toAcc) {
        this.toAcc = toAcc;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }
}
