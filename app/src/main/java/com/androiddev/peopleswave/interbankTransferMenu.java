package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class interbankTransferMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interbank_transfer_menu);
    }

    public void navigateToManageBeneficiary(View view){
        Intent intent = new Intent(this,ManageFavBenficary.class);
        startActivity(intent);

    }
}