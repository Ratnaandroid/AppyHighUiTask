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
import com.ratna.appyhighuitask.model.Albums;
import com.ratna.appyhighuitask.model.Artists;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by ratna on 15-05-2020.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{
    Context mcontext;
    ArrayList<Albums>albumsArrayList;

    public AlbumAdapter(Context mcontext, ArrayList<Albums> albumsArrayList) {
        this.mcontext = mcontext;
        this.albumsArrayList = albumsArrayList;
    }

    @NonNull
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item_topalbum, parent, false);
        return new AlbumAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.ViewHolder holder, int position) {
        Albums albums = albumsArrayList.get(position);


        holder.txtsongname.setText(albums.getSongname());
        holder.txtalbumname.setText(albums.getAlbumname());
        holder.txtalbumartistname.setText(albums.getAlbumartistname());
        Glide.with(mcontext)
                .load(albums.getAlbum())
                .apply(new RequestOptions().placeholder(R.drawable.appyhighlogo).error(R.drawable.appyhighlogo))
                .into(holder.imgAlbum);
    }

    @Override
    public int getItemCount() {
        return albumsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAlbum;
        TextView txtsongname,txtalbumname,txtalbumartistname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAlbum=itemView.findViewById(R.id.imgalbum);
            txtsongname=itemView.findViewById(R.id.txtsongname);
            txtalbumname=itemView.findViewById(R.id.txtalbumname);
            txtalbumartistname=itemView.findViewById(R.id.txtalbumartistname);
        }
    }
}
