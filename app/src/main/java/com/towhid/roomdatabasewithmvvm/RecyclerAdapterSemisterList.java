package com.towhid.roomdatabasewithmvvm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterSemisterList extends RecyclerView.Adapter<RecyclerAdapterSemisterList.MyViewHolder> {

    Context mcontext;
    List<Semister> mData; //contact clalss type array list object declare kora hoese just , instantiate kora hoy nai
    MainActivity activity;

    public RecyclerAdapterSemisterList(MainActivity activity, Context mcontext, List<Semister> mData) {
        this.activity = activity;
        this.mcontext = mcontext;
        this.mData = mData;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mcontext).inflate(R.layout.item_semister, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        Semister tempsemister = mData.get(position);
        holder.semistername.setText(tempsemister.getSemisterName());
        holder.semistergpa.setText(tempsemister.getSemiseterGPA() + "");
        holder.semistercredit.setText(tempsemister.getSemisterCredit() + "");

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.onItemClick(tempsemister);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView semistername;
        TextView semistergpa;
        TextView semistercredit;
        CardView card;

        public MyViewHolder(View itemView) {

            super(itemView);

            card = itemView.findViewById(R.id.card);
            semistercredit = itemView.findViewById(R.id.semistercredittv);
            semistergpa = itemView.findViewById(R.id.semistergpatv);
            semistername = itemView.findViewById(R.id.semisterNametv);


        }
    }


}