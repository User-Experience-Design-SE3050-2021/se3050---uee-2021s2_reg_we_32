package com.androiddev.peopleswave.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androiddev.peopleswave.R;
import com.androiddev.peopleswave.model.FavouriteBill;

import java.util.ArrayList;

public class FavBillRecyclerViewAdapter extends RecyclerView.Adapter<FavBillRecyclerViewAdapter.ViewHolder> {

    Context mycontext;
    private ArrayList<FavouriteBill> favouriteBillArrayList;

    public  FavBillRecyclerViewAdapter(Context mycontext, ArrayList<FavouriteBill> favouriteBillArrayList) {
        this.favouriteBillArrayList = favouriteBillArrayList;
        this.mycontext = mycontext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_bill_card_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final String sProvider = favouriteBillArrayList.get(position).getServiceProvider();
        final String pDescription = favouriteBillArrayList.get((position)).getPayeeDescription();
        final String billNo = favouriteBillArrayList.get(position).getBillNo();

//        holder.serviceProvider.setText(sProvider);
//        holder.payeeDescription.setText(pDescription);
//        holder.billNo.setText(billNo);


    }

    @Override
    public int getItemCount() {
        return favouriteBillArrayList.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {

        String serviceProvider;
        String payeeDescription;
        Number billNo;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

//        serviceProvider = itemView.findViewById(R.id.mfb_sprovider_display_tv);
//        payeeDescription = itemView.findViewById(R.id.mfb_pdescription_displat_tv);
//        billNo = itemView.findViewById(R.id.mfb_billno_display_tv);


    }
}

}
