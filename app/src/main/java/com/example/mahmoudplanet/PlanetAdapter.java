package com.example.mahmoudplanet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class planetAdapter extends RecyclerView.Adapter<planetAdapter.MyViewHolder> {
    Context context;
    ArrayList<planet> restList;
    private FirebaseServices fbs;

    public planetAdapter(Context context, ArrayList<planet> restList) {
        this.context = context;
        this.restList = restList;
        this.fbs = FirebaseServices.getInstance();
    }

    @NonNull
    @Override
    public planetAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v= LayoutInflater.from(context).inflate(R.layout.planet,parent,false);
        return  new planetAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull planetAdapter.MyViewHolder holder, int position) {
       planet rest = restList.get(position);
        holder.tvName.setText(planet.getName());
        holder.tvsize.setText(planet.getSize());
        holder.tvorbit.setText(planet.getOrbit());
        holder.tvnumber.setText(planet.getNumber());
    }

    @Override
    public int getItemCount(){
        return restList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvsize,tvorbit,tvnumber;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvNameRestItem);
            tvsize=itemView.findViewById(R.id.sizeRestItem);
            tvorbit=itemView.findViewById(R.id.tvorbitRestItem);
            tvnumber=itemView.findViewById(R.id.tvnumberRestItem);

        }
    }
}
