package com.ratna.appyhighuitask.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ratna.appyhighuitask.R;
import com.ratna.appyhighuitask.model.LatestAdded;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by ratna on 15-05-2020.
 */

public class LatestAddAdapter extends RecyclerView.Adapter<LatestAddAdapter.ViewHolder> {
    Context mcontext;
    ArrayList<LatestAdded>latestAddedArrayList;

    public LatestAddAdapter(Context mcontext, ArrayList<LatestAdded> latestAddedArrayList) {
        this.mcontext = mcontext;
        this.latestAddedArrayList = latestAddedArrayList;
    }

    @NonNull
    @Override
    public LatestAddAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item_latestadd, parent, false);
        return new LatestAddAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LatestAdded latestAdded=latestAddedArrayList.get(position);
        holder.txtaddedname.setText(latestAdded.getName());
        holder.txtaddeddirectory.setText(latestAdded.getDirectory());
        Glide.with(mcontext)
                .load(latestAdded.getLatestimageadd())
                .apply(new RequestOptions().placeholder(R.drawable.appyhighlogo).error(R.drawable.appyhighlogo))
                .into(holder.imgAdd);

    }

    @Override
    public int getItemCount() {
        return latestAddedArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAdd;
        TextView txtaddedname,txtaddeddirectory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAdd=itemView.findViewById(R.id.imglatestadd);
            txtaddedname=itemView.findViewById(R.id.txtaddedname);
            txtaddeddirectory=itemView.findViewById(R.id.txtaddeddirectory);
        }
    }
}
