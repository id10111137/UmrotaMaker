package com.example.tatangit.umrota_maker.View.Booking.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.Hellper.ModelManager;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.AddChart.Activity.Activity_Chart;
import com.example.tatangit.umrota_maker.View.SignUp.Activity.Activity_AMyProfil;
import com.example.tatangit.umrota_maker.View.SignUp.Activity.Activity_Login;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Activity_PreBoking extends AppCompatActivity {

    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    Intent intent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_pre);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Booking");
        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(getApplication().getResources().getDrawable(R.drawable.ic_shoping));

        toolbar_iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Activity_Chart.class);
                startActivity(intent);
            }
        });

        try {

            if (!ModelManager.getInstance(getApplicationContext()).isLoggedIn()) {
//                startActivity(new Intent(this, Activity_Login.class));
//                finish();
                startActivity(new Intent(this, Activity_AMyProfil.class));
                finish();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}