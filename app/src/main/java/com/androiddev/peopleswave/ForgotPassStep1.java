package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class ForgotPassStep1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass_step1);
    }

    //NavigateToStep2
    public void navigateToForgetStep2(View view){
        Intent intentStep2 =  new Intent(this,ForgotPassStep2.class);
        startActivity(intentStep2);
    }
}