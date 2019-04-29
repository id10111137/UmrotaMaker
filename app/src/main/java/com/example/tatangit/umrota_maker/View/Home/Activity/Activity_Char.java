package com.example.tatangit.umrota_maker.View.Home.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Hellper.Calendars;
import com.example.tatangit.umrota_maker.Hellper.Hellper_Umrota;
import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_UmrohByID_Item;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_UserItem;
import com.riyagayasen.easyaccordion.AccordionView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Activity_Char extends AppCompatActivity {

    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    Intent intent;
    Umrota_Service mUmrotaService;
    List<Model_UmrohByID_Item> model_umrohByID_items;
    Model_UserItem model_userItem;
    Hellper_Umrota hellper_umrota;
    Calendars calendars;
    AccordionView accordionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        mUmrotaService = Api_Utils.getSOService();
        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        hellper_umrota = new Hellper_Umrota();
        accordionView = new AccordionView(getApplicationContext());
        this.calendars = new Calendars();
        model_userItem = UserModelManager.getInstance(getApplicationContext()).getUser();
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("List Chart");
        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);
        toolbar_iconView.setOnClickListener(null);


    }
}
