package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.androiddev.peopleswave.model.Beneficiary;

public class addBenStep1 extends AppCompatActivity {

    Spinner spinnerPaymentMethod;
    Spinner spinnerBank;
    Spinner spinnerBranch;
    EditText editTextAccountNumber;
    EditText editTextAccountName;
    EditText editTextAccountEmail;
    EditText editTextAccountMobile;
    Beneficiary beneficiary;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ben_step1);
        spinnerPaymentMethod = (Spinner) findViewById(R.id.paymentMethodSpinner);
        spinnerBank = (Spinner) findViewById(R.id.spinnerBank);
        spinnerBranch = (Spinner) findViewById(R.id.spinnerBranch);
        editTextAccountEmail = (EditText) findViewById(R.id.edBenAccountEmail);
        editTextAccountNumber= (EditText) findViewById(R.id.edBenAccountNumber);
        editTextAccountName = (EditText) findViewById(R.id.edBenAccountName);
        editTextAccountMobile = (EditText) findViewById(R.id.edBenAccountMobile);





    }

    public void  navigateToStep2(View view){
        beneficiary =  new Beneficiary();
        beneficiary.setPaymentMethod(spinnerPaymentMethod.getSelectedItem().toString());
        beneficiary.setBank(spinnerBank.getSelectedItem().toString());
        beneficiary.setBranch(spinnerBranch.getSelectedItem().toString());
        beneficiary.setAccountNumb(editTextAccountNumber.getText().toString());
        beneficiary.setAccountName(editTextAccountName.getText().toString());
        beneficiary.setAccountEmail(editTextAccountEmail.getText().toString());
        beneficiary.setAccountMobile(editTextAccountMobile.getText().toString());



        Intent step2 =  new Intent(this,addBenfstep2.class);
        step2.putExtra("BEN",beneficiary);
        startActivity(step2);

    }
}