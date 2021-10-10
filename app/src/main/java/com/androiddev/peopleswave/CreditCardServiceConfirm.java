package com.androiddev.peopleswave;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androiddev.peopleswave.model.CreditCardPayment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class CreditCardServiceConfirm extends AppCompatActivity {

    TextView fromAcc, toAcc,amount,date;
    EditText otp;
    Button confirmBtn, cancelBtn, sendBtn;

    CreditCardPayment creditCardPayment;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_service_confirm);

        fromAcc = (TextView) findViewById(R.id.txtOTFromAccount);
        toAcc = (TextView) findViewById(R.id.txtOTtoAcc);
        amount = (TextView) findViewById(R.id.txtOTAmount);
        date = (TextView) findViewById(R.id.txtOTDate);

        otp = (EditText) findViewById(R.id.edTxtOTP);

        confirmBtn = (Button) findViewById(R.id.btnOTConfirm);

        Intent confirmIntent = getIntent();
        creditCardPayment = (CreditCardPayment) confirmIntent.getSerializableExtra("creditcardpayment");

        Log.d("card","credit"+creditCardPayment.getFromAcc());

        String fromacc = creditCardPayment.getFromAcc();
        String toacc = creditCardPayment.getToAcc();
        String creditcardamount = creditCardPayment.getAmount();
        //String paymentdate = creditCardPayment.getPaymentDate();
        String otpNo = creditCardPayment.getOtp();

        String paymentdate = "2021";

        fromAcc.setText(fromacc);
        toAcc.setText(toacc);
        amount.setText(creditcardamount);
        //date.setText(paymentdate);
        otp.setText(otpNo);


        CreditCardPayment creditCardPayment = new CreditCardPayment(fromacc,toacc,creditcardamount,paymentdate,otpNo);

        databaseReference = FirebaseDatabase.getInstance().getReference("creditcardPayment");
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.push();
                databaseReference.child(otpNo).setValue(creditCardPayment);

                Toast.makeText(CreditCardServiceConfirm.this, "Add Bill success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}