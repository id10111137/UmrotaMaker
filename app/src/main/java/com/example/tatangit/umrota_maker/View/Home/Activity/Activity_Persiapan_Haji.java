package com.example.tatangit.umrota_maker.View.Home.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class Activity_Persiapan_Haji extends AppCompatActivity {

    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    Intent mIntent;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persiapan_haji);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Persiapan Haji");
        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);
    }


    @OnClick(R.id.id_keutaman_haji)
    public void goKeutamaanHaji(){
        mIntent = new Intent(getApplicationContext(), Activity_Persiapan_Haji_Detail.class);
        mIntent.putExtra("persiapan_haji", "keutamaan_haji");
        startActivity(mIntent);
    }


    @OnClick(R.id.id_jangan_berdebat)
    public void goJanganDebat(){
        mIntent = new Intent(getApplicationContext(), Activity_Persiapan_Haji_Detail.class);
        mIntent.putExtra("persiapan_haji", "jangan_debat");
        startActivity(mIntent);
    }

    @OnClick(R.id.id_jangan_maksiat)
    public void goJanganMaksiat(){
        mIntent = new Intent(getApplicationContext(), Activity_Persiapan_Haji_Detail.class);
        mIntent.putExtra("persiapan_haji", "jangan_maksiat");
        startActivity(mIntent);
    }


    @OnClick(R.id.id_berhaji_harta)
    public void goBerhajiHarta(){
        mIntent = new Intent(getApplicationContext(), Activity_Persiapan_Haji_Detail.class);
        mIntent.putExtra("persiapan_haji", "berhaji_harta");
        startActivity(mIntent);
    }


    @OnClick(R.id.id_hakikat_taliyah)
    public void goHakikatTliyah(){
        mIntent = new Intent(getApplicationContext(), Activity_Persiapan_Haji_Detail.class);
        mIntent.putExtra("persiapan_haji", "hakikat_taliyah");
        startActivity(mIntent);
    }


    @OnClick(R.id.id_taubat)
    public void goTaubat(){
        mIntent = new Intent(getApplicationContext(), Activity_Persiapan_Haji_Detail.class);
        mIntent.putExtra("persiapan_haji", "taubat");
        startActivity(mIntent);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
