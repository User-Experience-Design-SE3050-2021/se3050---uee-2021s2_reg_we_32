package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /*
     Navigate to menu page
    * */

    public void navigateToMenu(View view){
        Intent intent =  new Intent(this,Menu.class);
        startActivity(intent);

    }

    //navigate to forget password
    public void navigateToForgetPass(View view){
        Intent intentFP =  new Intent(this,ForgotPassStep1.class);
        startActivity(intentFP);

    }

    //navigate to signup
    public void navigateToSignup(View view){
        Intent intentSignup =  new Intent(this,SignupStep1.class);
        startActivity(intentSignup);
    }
}