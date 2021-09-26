package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class SignupStep2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_step2);
    }

    //NavigateToStep3
    public void navigateToStep3(View view){
        Intent intentStep3 =  new Intent(this,SignupStep3.class);
        startActivity(intentStep3);
    }
}