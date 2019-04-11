package com.example.tatangit.umrota_maker.View.Home.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Hellper.Hellper_Umrota;
import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_UmrohByID;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_UmrohByID_Item;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_UserItem;
import com.riyagayasen.easyaccordion.AccordionView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Billing extends AppCompatActivity {

    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    Intent intent;

    Umrota_Service mUmrotaService;
    List<Model_UmrohByID_Item> model_umrohByID_items;


    @BindView(R.id.id_total_harga)
    TextView id_total_harga;
    @BindView(R.id.id_name_umroh)
    TextView id_name_umroh;
    @BindView(R.id.id_myaccount)
    TextView id_myaccount;
    @BindView(R.id.id_total_booking)
    TextView id_total_booking;
    @BindView(R.id.id_tHarga)
    TextView id_tHarga;
    @BindView(R.id.id_namecompany)
    TextView id_namecompany;
    @BindView(R.id.id_jadwalkeberangkatan)
    TextView id_jadwalkeberangkatan;
    @BindView(R.id.id_promo)
    TextView id_promo;
    @BindView(R.id.id_jadwalkepulangan)
    TextView id_jadwalkepulangan;


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
        id_myaccount.setText(model_userItem.getNamaCostumer());
        id_total_booking.setText(qty);

        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Billing Pembayaran");
        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(getApplication().getResources().getDrawable(R.drawable.ic_info));
        toolbar_iconView.setOnClickListener(null);



        mUmrotaService.getUmrohByID(nomor_umroh).enqueue(new Callback<Model_UmrohByID>() {
            @Override
            public void onResponse(Call<Model_UmrohByID> call, Response<Model_UmrohByID> response) {
                if (response.isSuccessful()) {
                    model_umrohByID_items = response.body().getMessage();
                    for (int i = 0; i < model_umrohByID_items.size(); i++) {
                        id_namecompany.setText(model_umrohByID_items.get(i).getNamaPerusahaan());
                        id_name_umroh.setText(model_umrohByID_items.get(i).getJudulUmroh());
                        id_tHarga.setText(model_umrohByID_items.get(i).getHargaUmroh());
                        id_total_harga.setText("Rp."+hellper_umrota.KalkulasiTotalHarga(qty,model_umrohByID_items.get(i).getHargaUmroh()));
                        id_jadwalkeberangkatan.setText(model_umrohByID_items.get(i).getKeberangkatan());
                        id_promo.setText(model_umrohByID_items.get(i).getDiscountPercent());
                        id_jadwalkepulangan.setText(model_umrohByID_items.get(i).getKepulangan());
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Data Belum Ditemukan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Model_UmrohByID> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Silahkan Periksa Internet Anda", Toast.LENGTH_SHORT).show();
            }
        });


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