package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androiddev.peopleswave.model.Beneficiary;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class addBenfstep2 extends AppCompatActivity {

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
        setContentView(R.layout.activity_add_benfstep2);
        databaseBeneficiary =  FirebaseDatabase.getInstance().getReference("beneficiary");
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
        accountNumber.setText(beneficiary.getAccountNumb());
        accountName.setText(beneficiary.getAccountName());
        email.setText(beneficiary.getAccountEmail());
        mobile.setText(beneficiary.getAccountMobile());

    }

    public void navigateToStep3(View view){

        addBeneficiary();

//        Intent intent = new Intent(this,addNewBenStep3.class);
//        startActivity(intent);

    }

    public void addBeneficiary(){

        String id = databaseBeneficiary.push().getKey();

        beneficiary.setBeneficiaryId(id);
        databaseBeneficiary.child(id).setValue(beneficiary);
        Toast.makeText(this, "Beneficiary Added Successfully ", Toast.LENGTH_LONG).show();


    }
}