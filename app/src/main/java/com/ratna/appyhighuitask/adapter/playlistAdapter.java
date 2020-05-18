package com.ratna.appyhighuitask.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ratna.appyhighuitask.R;
import com.ratna.appyhighuitask.model.playlist;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by ratna on 16-05-2020.
 */

public class playlistAdapter extends RecyclerView.Adapter<playlistAdapter.ViewHolder> {
    Context mcontext;
    ArrayList<playlist>playlistArrayList;

    public playlistAdapter(Context mcontext, ArrayList<playlist> playlistArrayList) {
        this.mcontext = mcontext;
        this.playlistArrayList = playlistArrayList;
    }

    @NonNull
    @Override
    public playlistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.item_playlist,parent,false);
        return new playlistAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        playlist playlist=playlistArrayList.get(position);
        holder.name.setText(playlist.getName());
        holder.duration.setText(playlist.getDuration());
        Glide.with(mcontext)
                .load(playlist.getImage())
                .apply(new RequestOptions().placeholder(R.drawable.appyhighlogo).error(R.drawable.appyhighlogo))
                .into(holder.imgimage);


    }

    @Override
    public int getItemCount() {
        return playlistArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgimage;
        TextView name,duration;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgimage=itemView.findViewById(R.id.imgplaylist);
            name=itemView.findViewById(R.id.txtplaylistname);
            duration=itemView.findViewById(R.id.txtTime);
        }
    }
}
