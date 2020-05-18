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
import com.ratna.appyhighuitask.model.Artists;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by ratna on 15-05-2020.
 */

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ViewHolder>{
    Context mcontext;
    ArrayList<Artists>artistsArrayList;

    public ArtistsAdapter(Context mcontext, ArrayList<Artists> artistsArrayList) {
        this.mcontext = mcontext;
        this.artistsArrayList = artistsArrayList;
    }

    @NonNull
    @Override
    public ArtistsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item_topartist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistsAdapter.ViewHolder holder, int position) {
        Artists artists = artistsArrayList.get(position);


        holder.txtArtisttype.setText(artists.getArtisttype());
        holder.txtartistname.setText(artists.getArtistname());
        Glide.with(mcontext)
                .load(artists.getArtistimage())
                .apply(new RequestOptions().placeholder(R.drawable.appyhighlogo).error(R.drawable.appyhighlogo))
                .into(holder.imgartist);
    }

    @Override
    public int getItemCount() {
        return artistsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgartist;
        TextView txtArtisttype,txtartistname;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtArtisttype=itemView.findViewById(R.id.txtArtisttype);
            txtartistname=itemView.findViewById(R.id.txtartistname);
            imgartist=itemView.findViewById(R.id.imgartist);
        }
    }
}
