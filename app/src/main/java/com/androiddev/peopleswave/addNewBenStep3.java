package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class addNewBenStep3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_ben_step3);
    }

    public void naviagetToHome(View view){
        Intent homeInt =  new Intent(this,transferServices.class);
        startActivity(homeInt);

    }
}