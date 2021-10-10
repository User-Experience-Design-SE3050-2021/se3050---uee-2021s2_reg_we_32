package com.androiddev.peopleswave.model;

import com.google.firebase.database.IgnoreExtraProperties;
import java.io.Serializable;

@IgnoreExtraProperties
public class FavouriteBill implements Serializable {

    private String serviceProvider;
    private String payeeDescription;
    private String billNo;
    private String favBillId;

    //default constructor
    public FavouriteBill() { }

    public FavouriteBill(String serviceProvider, String payeeDescription, String billNo) {
        this.serviceProvider = serviceProvider;
        this.payeeDescription = payeeDescription;
        this.billNo = billNo;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getPayeeDescription() {
        return payeeDescription;
    }

    public void setPayeeDescription(String payeeDescription) {
        this.payeeDescription = payeeDescription;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getFavBillId() {
        return favBillId;
    }

    public void setFavBillId(String favBillId) {
        this.favBillId = favBillId;
    }
}
