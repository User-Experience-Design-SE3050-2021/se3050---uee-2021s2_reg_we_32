package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.androiddev.peopleswave.model.Beneficiary;
import com.google.firebase.database.DatabaseReference;

public class ViewBeneficaryDetails extends AppCompatActivity {

    TextView paymentOption;
    TextView bank;
    TextView branch;
    TextView accountNumber;
    TextView accountName;
    TextView email;
    TextView mobile;
    Beneficiary beneficiary;
    DatabaseReference databaseBeneficiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_beneficary_details);
        Intent intent = getIntent();
        beneficiary = (Beneficiary) intent.getSerializableExtra("BEN");
        paymentOption =  findViewById(R.id.paymentOptionValue);
        bank =  findViewById(R.id.bankValue);
        branch =  findViewById(R.id.branchValue);
        accountNumber =  findViewById(R.id.accountNumberValue);
        accountName =  findViewById(R.id.accountNameValue);
        email =  findViewById(R.id.emailValue);
        mobile =  findViewById(R.id.mobileValue);

    }

    @Override
    protected void onStart() {
        super.onStart();
        paymentOption.setText(beneficiary.getPaymentMethod());
        bank.setText(beneficiary.getBank());
        branch.setText(beneficiary.getBranch());
        accountName.setText(beneficiary.getAccountName());
        accountNumber.setText(beneficiary.getAccountNumb());
        email.setText(beneficiary.getAccountEmail());
        mobile.setText(beneficiary.getAccountMobile());

    }
}