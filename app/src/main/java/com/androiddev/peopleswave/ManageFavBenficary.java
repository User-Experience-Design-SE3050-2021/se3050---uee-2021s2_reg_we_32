package com.androiddev.peopleswave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ManageFavBenficary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_fav_benficary);


    }

    public void navigateToAddBeneficiary(View view){
        Intent addBen =  new Intent(this,addBenStep1.class);
        startActivity(addBen);
    }
}