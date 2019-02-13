package com.example.nihal.retro;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nihal.retro.pojo.DataClass;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.holder> {


    private Context context;
    private ArrayList<DataClass> dataClassArrayList;

    public CustomAdapter(Context context, ArrayList<DataClass> dataClassArrayList) {
        this.context = context;
        this.dataClassArrayList = dataClassArrayList;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row,viewGroup,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int i) {

        DataClass dataClass = dataClassArrayList.get(i);
        holder.tvName.setText(dataClassArrayList.get(i).getGameName());
        holder.tvDate.setText(dataClassArrayList.get(i).getGameDate());
        holder.tvFee.setText(dataClassArrayList.get(i).getGameFee());
        Picasso.with(context).load(dataClass.getGamePoster()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return dataClassArrayList.size();
    }

    class holder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView tvName,tvDate,tvFee;

        public holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvFee = itemView.findViewById(R.id.tvFee);
        }
    }
}
