package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddBillerMsg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_biller_msg);
    }

    public void navigateToAddBillerMsg(View view){
        Intent intent =  new Intent(this,AddBillerMsg.class);
        startActivity(intent);
    }

}