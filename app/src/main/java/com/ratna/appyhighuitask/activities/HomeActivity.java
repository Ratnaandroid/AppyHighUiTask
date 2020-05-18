package com.ratna.appyhighuitask.activities;

import android.app.Dialog;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.ratna.appyhighuitask.R;
import com.ratna.appyhighuitask.adapter.AlbumAdapter;
import com.ratna.appyhighuitask.adapter.ArtistsAdapter;
import com.ratna.appyhighuitask.adapter.LatestAddAdapter;
import com.ratna.appyhighuitask.adapter.playlistAdapter;
import com.ratna.appyhighuitask.model.Albums;
import com.ratna.appyhighuitask.model.Artists;
import com.ratna.appyhighuitask.model.LatestAdded;
import com.ratna.appyhighuitask.model.playlist;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerViewartists, recyclerviewalbums, recyclerViewlatest;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Artists> artistsArrayList = new ArrayList<>();
    ArrayList<Albums> albumsArrayList = new ArrayList<>();
    ArrayList<LatestAdded> latestAddedArrayList = new ArrayList<>();
    FloatingActionButton mFAB;
  DrawerLayout mDrawer;
    public NavigationView navigationView;
    LinearLayout mpcutter, addtoplaylist, bassbooster;
  ImageView imgcutter;
    BottomSheetDialog dialog;
    ArrayList<playlist>playlistArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponents();
    }

    private void initComponents() {
        setReferences();
        setClickListeners();
        setAdapter();
    }

    private void setReferences() {
        recyclerViewartists = findViewById(R.id.recyclerviewtopartists);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewartists.setLayoutManager(linearLayoutManager);
        recyclerViewartists.setHasFixedSize(true);
        recyclerviewalbums = findViewById(R.id.recyclerviewtopalbums);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerviewalbums.setLayoutManager(linearLayoutManager);
        recyclerviewalbums.setHasFixedSize(true);
        recyclerViewlatest = findViewById(R.id.recyclerviewlatestadds);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewlatest.setLayoutManager(linearLayoutManager);
        recyclerViewlatest.setHasFixedSize(true);
        mDrawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        mpcutter = navigationView.findViewById(R.id.llcutter);
        addtoplaylist = navigationView.findViewById(R.id.llAddtoplaylist);
        bassbooster = navigationView.findViewById(R.id.llbassbooster);


    }

    private void setClickListeners() {
        mpcutter.setOnClickListener(this);
        addtoplaylist.setOnClickListener(this);
        bassbooster.setOnClickListener(this);

    }

    private void setAdapter() {

        artistsArrayList.add(new Artists("123", "Taylor Swift", R.drawable.taylorswift));
        artistsArrayList.add(new Artists("56", "Drake", R.drawable.camila));
        artistsArrayList.add(new Artists("32", "Eminem", R.drawable.sweetner));
        artistsArrayList.add(new Artists("123", "Taylor Swift", R.drawable.taylorswift));
        ArtistsAdapter artistsAdapter = new ArtistsAdapter(this, artistsArrayList);
        recyclerViewartists.setAdapter(artistsAdapter);


        albumsArrayList.add(new Albums("1035", "Reputation", "Taylor Swift", R.drawable.taylorswift));
        albumsArrayList.add(new Albums("645", "Culture", "Migos", R.drawable.americansystem));
        albumsArrayList.add(new Albums("323", "Wonderful Whale", "The Killers", R.drawable.eatside));
        albumsArrayList.add(new Albums("1035", "Reputation", "Taylor Swift", R.drawable.sweetner));
        AlbumAdapter albumAdapter = new AlbumAdapter(this, albumsArrayList);
        recyclerviewalbums.setAdapter(albumAdapter);


        latestAddedArrayList.add(new LatestAdded("sunflower", "Swae lee,post malone", R.drawable.taylorswift));
        latestAddedArrayList.add(new LatestAdded("sweetner", "Ariana Grande", R.drawable.eatside));
        latestAddedArrayList.add(new LatestAdded("Eatside", "Halsey", R.drawable.workout));
        latestAddedArrayList.add(new LatestAdded("Camila", "Camila cabello", R.drawable.camila));
        latestAddedArrayList.add(new LatestAdded("One Kiss", "Dua lipa", R.drawable.sweetner));

        LatestAddAdapter latestAddAdapter = new LatestAddAdapter(this, latestAddedArrayList);
        recyclerViewlatest.setAdapter(latestAddAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.llcutter:
                mDrawer.closeDrawer(GravityCompat.END);

                Intent cutter=new Intent(this,MpCutterActivity.class);
                startActivity(cutter);
                break;
            case R.id.llAddtoplaylist:
                mDrawer.closeDrawer(GravityCompat.END);
                showPlayistDialog();
                break;
            case R.id.llbassbooster:
                mDrawer.closeDrawer(GravityCompat.END);
                showbassboosterDialog();
                break;
                default:

                    break;
        }

    }

    private void showbassboosterDialog() {
       Dialog dialog = new Dialog(this, R.style.MyDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        dialog.setContentView(R.layout.dialog_bassbooster);

        dialog.setCancelable(true);
        dialog.show();
    }

    private void showPlayistDialog() {
        dialog = new BottomSheetDialog(this, R.style.MyDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        /*   dialog.getWindow().getAttributes().windowAnimations = R.style.AppModalStyle;*/
        //   dialog.getWindow().setBackgroundDrawableResource(R.color.colorPrimary);
        dialog.getWindow().getAttributes().windowAnimations = R.style.AppModalStyle;
        dialog.getWindow().setBackgroundDrawableResource(R.color.transparent);


        dialog.setContentView(R.layout.dialog_addtoplayist);
        dialog.setCancelable(true);
        ImageView imgrect=dialog.findViewById(R.id.rect);
        imgrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        RecyclerView recyclerView=dialog.findViewById(R.id.recyclerviewnewplaylist);
        linearLayoutManager=new LinearLayoutManager(HomeActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        playlistArrayList.add(new playlist("Workout","82 Songs,207 min",R.drawable.workout));
        playlistArrayList.add(new playlist("Sweetener","123 Songs, 135 min",R.drawable.sweetner));
        playlistArrayList.add(new playlist("Eastside","382 Songs, 207 min",R.drawable.eatside));
        playlistArrayList.add(new playlist("Camila","123 Songs, 135 min",R.drawable.camila));
        playlistAdapter playlistAdapter=new playlistAdapter(HomeActivity.this,playlistArrayList);
        recyclerView.setAdapter(playlistAdapter);
        dialog.show();
    }
}
