package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class SignupStep1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_step1);
    }

    //NavigateToStep2
    public void navigateToStep2(View view){
        Intent intentStep2 =  new Intent(this,SignupStep2.class);
        startActivity(intentStep2);
    }
}