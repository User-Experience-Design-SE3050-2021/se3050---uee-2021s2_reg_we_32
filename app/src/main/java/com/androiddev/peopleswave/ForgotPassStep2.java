package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class ForgotPassStep2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass_step2);
    }

    //NavigateToStep3
    public void navigateToFPStep3(View view){
        Intent intentStepFP3 =  new Intent(this,ForgotPassStep3.class);
        startActivity(intentStepFP3);
    }
}