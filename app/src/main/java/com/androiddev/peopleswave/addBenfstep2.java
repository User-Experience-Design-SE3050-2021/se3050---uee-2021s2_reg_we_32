package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class addBenfstep2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_benfstep2);
    }

    public void navigateToStep3(View view){
        Intent intent = new Intent(this,addNewBenStep3.class);
        startActivity(intent);

    }
}