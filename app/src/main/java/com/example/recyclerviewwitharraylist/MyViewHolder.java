package com.example.recyclerviewwitharraylist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView countryName;
    ImageView flagImage;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        countryName = (TextView) itemView.findViewById(R.id.countryName);
        flagImage=(ImageView)itemView.findViewById(R.id.flagImage);
    }
}