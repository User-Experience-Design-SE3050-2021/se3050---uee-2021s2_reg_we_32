package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OneTimePaymentMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_time_payment_main);
    }

    public void navigateToPaymentConfirmation(View view){
        Intent intent =  new Intent(this,OneTimePaymentConfirmation.class);
        startActivity(intent);
    }
}