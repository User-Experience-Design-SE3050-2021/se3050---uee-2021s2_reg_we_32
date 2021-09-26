package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class ForgotPassStep3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass_step3);
    }

    //NavigateToStep4
    public void navigateToForgetStep4(View view){
        Intent intentStepFP4 =  new Intent(this,ForgotPassStep4.class);
        startActivity(intentStepFP4);
    }
}