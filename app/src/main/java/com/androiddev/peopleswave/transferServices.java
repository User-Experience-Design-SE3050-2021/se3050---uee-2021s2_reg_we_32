package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class transferServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tranfer_services);
    }

    public void navigateToInterBank(View view){
        Intent intent = new Intent(this,interbankTransferMenu.class);
        startActivity(intent);

    }


}