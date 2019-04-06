package com.example.tatangit.umrota_maker.View.Home.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_DCompany;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_DCompany;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Activity_InfoCompany extends AppCompatActivity {

    Toolbar toolbar;
    public String nameCompany;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    Intent intent;

    ArrayList<Model_DCompany> model_dCompanies;
    @BindView(R.id.id_lv_dCompany)
    ListView id_lv_dCompany;
    Adapter_DCompany adapter_dCompany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_company);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
