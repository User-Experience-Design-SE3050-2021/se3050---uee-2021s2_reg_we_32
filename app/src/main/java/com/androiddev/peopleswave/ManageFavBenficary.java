package com.androiddev.peopleswave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.androiddev.peopleswave.model.Beneficiary;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ManageFavBenficary extends AppCompatActivity {

    DatabaseReference databaseBeneficiary;
    List<Beneficiary> beneficiaries;
    ListView benListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_fav_benficary);
        beneficiaries = new ArrayList<>();
        databaseBeneficiary = FirebaseDatabase.getInstance().getReference("beneficiary");
        benListView = (ListView) findViewById(R.id.listBen);

        benListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(), "DETAILS",Toast.LENGTH_SHORT);
                Beneficiary selectedBeneficiary =  beneficiaries.get(i);
                Log.d("DESC","RADA");
                Intent intent =  new Intent(getApplicationContext(),ViewBeneficaryDetails.class);
                intent.putExtra("BEN",selectedBeneficiary);
                startActivity(intent);
            }
        });



    }


    @Override
    protected void onStart() {
        super.onStart();
        databaseBeneficiary.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                beneficiaries.clear();
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Log.d("DESC","SOMETHING");
                    Beneficiary beneficiary = dataSnapshot.getValue(Beneficiary.class);
                    beneficiaries.add(beneficiary);
                }

                BeneficiaryList listAdaptr =  new BeneficiaryList(ManageFavBenficary.this,beneficiaries);
                benListView.setAdapter(listAdaptr);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void navigateToAddBeneficiary(View view){
        Intent addBen =  new Intent(this,addBenStep1.class);
        startActivity(addBen);
    }
}