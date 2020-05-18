package com.ratna.appyhighuitask.activities;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ratna.appyhighuitask.R;

import androidx.appcompat.app.AppCompatActivity;

public class MpCutterActivity extends AppCompatActivity implements View.OnClickListener{
ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_cutter);
        initComponents();

    }

    private void initComponents() {
        setReferences();
        setClickListeners();
    }

    private void setReferences() {
        imgBack=findViewById(R.id.imgBack);
    }

    private void setClickListeners() {
        imgBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBack:
                Intent back=new Intent(this,HomeActivity.class);
                startActivity(back);
                break;
                default:
                    break;
        }
    }
}
