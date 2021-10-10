package com.androiddev.peopleswave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.androiddev.peopleswave.model.FavouriteBill;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddFavoriteBiller extends AppCompatActivity {

    Spinner serviceProviderSpinner;
    EditText payeeDesEt, billNoEt;
    Button saveBtn, cancelBtn;

    FavouriteBill favouriteBill;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_favorite_biller);

        serviceProviderSpinner = (Spinner) findViewById(R.id.afb_sprovider_dropdown);
        payeeDesEt = (EditText)findViewById(R.id.afb_pdescription_et);
        billNoEt = (EditText) findViewById(R.id.afb_billno_et);
        saveBtn = (Button) findViewById(R.id.afb_savet_btn);
        cancelBtn = (Button) findViewById(R.id.afb_cancel_btn);

        //set items to spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.service_providers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        serviceProviderSpinner.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("favouritebill");

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DB REF", "" + databaseReference);

                String serviceProvider =  serviceProviderSpinner.getSelectedItem().toString();
                String payeeDescription = payeeDesEt.getText().toString();
                String billNo = billNoEt.getText().toString();

                Log.d("bill = ", "bill details" + serviceProvider + payeeDescription + billNo);

                favouriteBill = new FavouriteBill();

                favouriteBill.setServiceProvider(serviceProvider);
                favouriteBill.setPayeeDescription(payeeDescription);
                favouriteBill.setBillNo(billNo);



                //push method generates a unique key for every record
                String billId = databaseReference.push().getKey();
                Log.d("key = ","bill id = "+ billId);
                favouriteBill.setFavBillId(billId);
                databaseReference.child(billId).setValue(favouriteBill);

//                Intent intent = new Intent(AddFavoriteBiller.this, AddBillerMsg.class);
//                startActivity(intent);

                Toast.makeText(AddFavoriteBiller.this, "Add Bill success", Toast.LENGTH_SHORT).show();


//                databaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        // on below line we are setting data in our firebase database.
//                        databaseReference.setValue(favouriteBill);
//                        // displaying a toast message.
//                        // Toast.makeText(AddCourseActivity.this, "Course Added..", Toast.LENGTH_SHORT).show();
//                        // starting a main activity.
//
//                        startActivity(intent);
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//                        // displaying a failure message on below line.
//
//                        //Toast.makeText(AddFavoriteBiller.this, "Fail to add Course..", Toast.LENGTH_SHORT).show();
//                    }
//                });
            }
        });
    }
}