package com.example.tatangit.umrota_maker.View.Home.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Hellper.Hellper_Umrota;
import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_UserItem;
import com.riyagayasen.easyaccordion.AccordionView;

import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Activity_Payment extends AppCompatActivity {


    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    Intent intent;
    Umrota_Service mUmrotaService;
    public String nomor_umroh;
    public String qty;

    Model_UserItem model_userItem;

    Hellper_Umrota hellper_umrota;
    AccordionView accordionView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
        mUmrotaService = Api_Utils.getSOService();
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        hellper_umrota = new Hellper_Umrota();
        nomor_umroh = getIntent().getStringExtra("nomor_umroh");
        qty = getIntent().getStringExtra("qty");
        accordionView = new AccordionView(getApplicationContext());


        model_userItem = UserModelManager.getInstance(getApplicationContext()).getUser();
//        id_myaccount.setText(model_userItem.getNamaCostumer());
        //      id_total_booking.setText(qty);

        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Billing Pembayaran");
        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(getApplication().getResources().getDrawable(R.drawable.ic_info));
        toolbar_iconView.setOnClickListener(null);


    }

}
