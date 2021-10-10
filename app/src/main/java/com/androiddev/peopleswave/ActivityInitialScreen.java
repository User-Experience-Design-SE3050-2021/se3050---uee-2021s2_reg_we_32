package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class ActivityInitialScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_screen);
    }

    //navigate to login
    public void navigateToLogin(View view){
        Intent intentLogin =  new Intent(this,MainActivity.class);
        startActivity(intentLogin);
    }

    //navigate to signup
    public void navigateToSignup(View view){
        Intent intentSignup =  new Intent(this,SignupStep1.class);
        startActivity(intentSignup);
    }

}