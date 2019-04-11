package com.example.tatangit.umrota_maker.View.Home.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Activity_Fikih_Haji_Detail extends AppCompatActivity {

    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    Intent mIntent;

    String Persiapan_;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persiapan_haji_detail);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);
        Persiapan_ = getIntent().getStringExtra("persiapan_haji");

    }
}
