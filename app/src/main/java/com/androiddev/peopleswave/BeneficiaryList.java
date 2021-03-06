package com.androiddev.peopleswave;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.androiddev.peopleswave.model.Beneficiary;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class BeneficiaryList  extends ArrayAdapter<Beneficiary> {

    private  Activity context;
    List<Beneficiary> beneficiaries;
    DatabaseReference databaseBeneficiaries;
    Beneficiary beneficiary;

    public BeneficiaryList(Activity context, List<Beneficiary> beneficiaries){
        super(context,R.layout.beneficarylistitem,beneficiaries);
        this.context = context;
        this.beneficiaries =  beneficiaries;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {


        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.beneficarylistitem, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewBenName);
        TextView textViewAccountNumber = (TextView) listViewItem.findViewById(R.id.textViewBenAccountNumber);
        TextView textViewBank = (TextView) listViewItem.findViewById(R.id.textViewBenBranch);
        Button deleteButton = (Button) listViewItem.findViewById(R.id.buttonDelete);
        Button editButton = (Button) listViewItem.findViewById(R.id.buttonEdit);
        ConstraintLayout buttonContainer = (ConstraintLayout) listViewItem.findViewById(R.id.btnContinaer);

         beneficiary =  beneficiaries.get(position);
        textViewName.setText(beneficiary.getAccountName());
        textViewAccountNumber.setText(beneficiary.getAccountNumb());
        textViewBank.setText(beneficiary.getBank());
        databaseBeneficiaries = FirebaseDatabase.getInstance().getReference("beneficiary").child(beneficiary.getBeneficiaryId());

       deleteButton.setOnClickListener(new  View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(context, "Beneficiary Deleted " , Toast.LENGTH_LONG).show();
               databaseBeneficiaries.removeValue();

           }
       });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(context,EditBeneficiary.class);
                intent.putExtra("BEN",beneficiary);
                context.startActivity(intent);

            }
        });

        return listViewItem;
    }
}
