package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.androiddev.peopleswave.model.Beneficiary;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditBeneficiary extends AppCompatActivity {


    Beneficiary beneficiary;
    Spinner spinnerPaymentMethod;
    Spinner spinnerBank;
    Spinner spinnerBranch;
    EditText editTextAccountNumber;
    EditText editTextAccountName;
    EditText editTextAccountEmail;
    EditText editTextAccountMobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_beneficiary);
        Intent intent =  getIntent();
        beneficiary = (Beneficiary) intent.getSerializableExtra("BEN");
        spinnerPaymentMethod = (Spinner) findViewById(R.id.paymentMethodSpinner);
        spinnerBank = (Spinner) findViewById(R.id.spinnerBank);
        spinnerBranch = (Spinner) findViewById(R.id.spinnerBranch);
        editTextAccountEmail = (EditText) findViewById(R.id.edBenAccountEmail);
        editTextAccountNumber= (EditText) findViewById(R.id.edBenAccountNumber);
        editTextAccountName = (EditText) findViewById(R.id.edBenAccountName);
        editTextAccountMobile = (EditText) findViewById(R.id.edBenAccountMobile);
    }

    @Override
    protected void onStart() {
        super.onStart();

        spinnerPaymentMethod.setSelection(((ArrayAdapter)spinnerBank.getAdapter()).getPosition(beneficiary.getPaymentMethod()));
        spinnerBank.setSelection(((ArrayAdapter)spinnerBank.getAdapter()).getPosition(beneficiary.getBank()));
        spinnerBranch.setSelection(((ArrayAdapter)spinnerBank.getAdapter()).getPosition(beneficiary.getBranch()));

        editTextAccountNumber.setText(beneficiary.getAccountNumb());
        editTextAccountName.setText(beneficiary.getAccountName());
        editTextAccountEmail.setText(beneficiary.getAccountEmail());
        editTextAccountMobile.setText(beneficiary.getAccountMobile());

    }

    public void onclickEdit(View view){
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("beneficiary").child(beneficiary.getBeneficiaryId());
        beneficiary.setPaymentMethod(spinnerPaymentMethod.getSelectedItem().toString());
        beneficiary.setBank(spinnerBank.getSelectedItem().toString());
        beneficiary.setBranch(spinnerBranch.getSelectedItem().toString());
        beneficiary.setAccountNumb(editTextAccountNumber.getText().toString());
        beneficiary.setAccountName(editTextAccountName.getText().toString());
        beneficiary.setAccountEmail(editTextAccountEmail.getText().toString());
        beneficiary.setAccountMobile(editTextAccountMobile.getText().toString());

        dR.setValue(beneficiary);
        Toast.makeText(this,"Beneficiary Details updated",Toast.LENGTH_LONG).show();
        Intent intent =  new Intent(this,ManageFavBenficary.class);
        startActivity(intent);

    }
}