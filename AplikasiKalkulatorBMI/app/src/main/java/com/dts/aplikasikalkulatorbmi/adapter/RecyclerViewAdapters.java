package com.dts.aplikasikalkulatorbmi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dts.aplikasikalkulatorbmi.R;
import com.dts.aplikasikalkulatorbmi.models.ItemResult;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapters extends RecyclerView.Adapter<RecyclerViewAdapters.MyViewHolder> {

    List<ItemResult> listItemResult;

    public RecyclerViewAdapters(List<ItemResult> listItemResult) {
        this.listItemResult = listItemResult;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_label, parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ItemResult itemResult = listItemResult.get(position);
        holder.label.setText(itemResult.getLabel());
        holder.hasil.setText(itemResult.getHasil());
    }

    @Override
        public int getItemCount() {
        return listItemResult.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView label, hasil;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            label = itemView.findViewById(R.id.Label);
            hasil = itemView.findViewById(R.id.hasilInput);
        }
    }


}
