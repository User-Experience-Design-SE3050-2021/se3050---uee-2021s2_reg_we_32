package com.androiddev.peopleswave.model;
import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class Beneficiary  implements Serializable {

    private  String beneficiaryId;
    private String  paymentMethod;
    private  String bank;
    private  String branch;
    private  String accountNumb;
    private  String accountName;
    private  String accountEmail;
    private  String accountMobile;

    public Beneficiary(){

    }


    public Beneficiary(String bank, String branch, String accountNumb, String accountName, String accountEmail, String accountMobile ,String paymentMethod) {
        this.paymentMethod = paymentMethod;
        this.bank = bank;
        this.branch = branch;
        this.accountNumb = accountNumb;
        this.accountName = accountName;
        this.accountEmail = accountEmail;
        this.accountMobile = accountMobile;
    }

    public Beneficiary(String beneficiaryId, String bank, String branch, String accountNumb, String accountName, String accountEmail, String accountMobile,String paymentMethod) {
        this.beneficiaryId = beneficiaryId;
        this.bank = bank;
        this.branch = branch;
        this.accountNumb = accountNumb;
        this.accountName = accountName;
        this.accountEmail = accountEmail;
        this.accountMobile = accountMobile;
        this.paymentMethod = paymentMethod;
    }

    public String getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(String beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccountNumb() {
        return accountNumb;
    }

    public void setAccountNumb(String accountNumb) {
        this.accountNumb = accountNumb;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getAccountMobile() {
        return accountMobile;
    }

    public void setAccountMobile(String accountMobile) {
        this.accountMobile = accountMobile;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
