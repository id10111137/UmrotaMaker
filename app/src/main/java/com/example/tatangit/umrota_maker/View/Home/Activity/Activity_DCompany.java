package com.example.tatangit.umrota_maker.View.Home.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.AddChart.Activity.Activity_Chart;
import com.example.tatangit.umrota_maker.View.Booking.Activity.Activity_Booking;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_DCompany;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Umroh;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_DCompany;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Umroh;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Activity_DCompany extends AppCompatActivity {

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
        setContentView(R.layout.activity_dcompany);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        nameCompany= getIntent().getStringExtra("name_company");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText(nameCompany);
        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(getApplication().getResources().getDrawable(R.drawable.ic_info));
        toolbar_iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                intent = new Intent(getApplicationContext(), Activity_InfoCompany.class);
////                intent.putExtra("name_company",nameCompany);
//                startActivity(intent);
                }
        });

        DummyData();
        adapter_dCompany = new Adapter_DCompany(model_dCompanies, getApplicationContext());
        id_lv_dCompany.setAdapter(adapter_dCompany);

        id_lv_dCompany.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                intent = new Intent(getApplicationContext(), Activity_Booking.class);
                intent.putExtra("company_no", adapter_dCompany.getItem(position).getCompanyNamber());
                startActivity(intent);
            }
        });
    }


    private void DummyData(){

        model_dCompanies = new ArrayList<>();
        model_dCompanies.add(new Model_DCompany("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg",10001,nameCompany,"Umroh Bulan January","2018/01/01","2018/01/20",20,10));
        model_dCompanies.add(new Model_DCompany("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg",10002,nameCompany,"Umroh Bulan Febuary","2018/02/02","2018/02/10",20,10));
        model_dCompanies.add(new Model_DCompany("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg",10003,nameCompany,"Umroh Bulan Maret","2018/03/03","2018/03/10",20,10));
        model_dCompanies.add(new Model_DCompany("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg",10004,nameCompany,"Umroh Bulan April","2018/04/04","2018/04/08",20,10));
        model_dCompanies.add(new Model_DCompany("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg",10005,nameCompany,"Umroh Bulan Mei","2018/05/05","2018/05/10",20,10));
        model_dCompanies.add(new Model_DCompany("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg",10006,nameCompany,"Umroh Bulan Juni","2018/06/06","2018/06/12",20,10));
        model_dCompanies.add(new Model_DCompany("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg",10007,nameCompany,"Umroh Bulan July","2018/07/07","2018/07/14",20,10));
        model_dCompanies.add(new Model_DCompany("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg",10008,nameCompany,"Umroh Bulan Agustus","2018/08/08","2018/08/16",20,10));
        model_dCompanies.add(new Model_DCompany("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg",10009,nameCompany,"Umroh Bulan September","2018/09/09","2018/09/18",20,10));
        model_dCompanies.add(new Model_DCompany("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg",10010,nameCompany,"Umroh Bulan Oktober","2018/10/10","2018/10/20",20,10));

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
