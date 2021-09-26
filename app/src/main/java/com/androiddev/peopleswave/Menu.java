package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void navigateToTransferService(View view){
        Intent intent = new Intent(this,transferServices.class);
        startActivity(intent);
    }

    public void navigateToCreditCardService(View view){
        Intent intent = new Intent(this,creditcardService.class);
        startActivity(intent);
    }

    public void navigateToOneTimePayment(View view){
        Intent intent = new Intent(this,OneTimePaymentMain.class);
        startActivity(intent);
    }

    public void navigateToMangeBill(View view){
        Intent intent = new Intent(this,addFavoriteBiller.class);
        startActivity(intent);
    }
}