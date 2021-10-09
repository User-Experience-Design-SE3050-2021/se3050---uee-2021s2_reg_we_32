package com.androiddev.peopleswave;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.androiddev.peopleswave.model.Beneficiary;

import org.w3c.dom.Text;

import java.util.List;

public class BeneficiaryList  extends ArrayAdapter<Beneficiary> {

    private  Activity context;
    List<Beneficiary> beneficiaries;

    public BeneficiaryList(Activity context, List<Beneficiary> beneficiaries){
        super(context,R.layout.beneficarylistitem);
        this.context = context;
        this.beneficiaries =  beneficiaries;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.beneficarylistitem, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewBenName);
        TextView textViewAccountNumber = (TextView) listViewItem.findViewById(R.id.textViewBenAccountNumber);
        TextView textViewBank = (TextView) listViewItem.findViewById(R.id.textViewBenBranch);

        Beneficiary beneficiary =  beneficiaries.get(position);
        textViewName.setText(beneficiary.getAccountName());
        textViewAccountNumber.setText(beneficiary.getAccountNumb());
        textViewBank.setText(beneficiary.getBank());


        return listViewItem;
    }
}
