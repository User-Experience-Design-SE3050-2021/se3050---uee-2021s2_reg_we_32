package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class SignupStep3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_step3);
    }

    //NavigateToLastStep
    public void navigateToLastStep(View view){
        Intent intentLastStep =  new Intent(this,SignupStep4.class);
        startActivity(intentLastStep);
    }
}