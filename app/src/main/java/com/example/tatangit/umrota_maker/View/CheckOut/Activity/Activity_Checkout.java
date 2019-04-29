package com.example.tatangit.umrota_maker.View.CheckOut.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Activity.Activity_Billing;
import com.example.tatangit.umrota_maker.View.Home.Activity.Activity_Char;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_UmrohByID;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_UmrohByID_Item;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Checkout extends AppCompatActivity {

    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    Intent intent;
    public String nomor_umroh;
    Umrota_Service mUmrotaService;
    List<Model_UmrohByID_Item> model_umrohByID_items;

    @BindView(R.id.id_namecompany)
    TextView id_namecompany;

    @BindView(R.id.id_name_umroh)
    TextView id_name_umroh;

    @BindView(R.id.id_jadwal_keberangkatan)
    TextView id_jadwal_keberangkatan;

    @BindView(R.id.id_jadwal_kepulangan)
    TextView id_jadwal_kepulangan;

    @BindView(R.id.id_harga)
    TextView id_harga;

    @BindView(R.id.id_hotel)
    TextView id_hotel;

    @BindView(R.id.id_promo)
    TextView id_promo;

    @BindView(R.id.id_deskripsi)
    TextView id_deskripsi;

    @BindView(R.id.id_jumlah_ticket)
    EditText id_jumlah_ticket;

    @BindView(R.id.id_img_checkout)
    ImageView id_img_checkout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_pre);
        mUmrotaService = Api_Utils.getSOService();
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nomor_umroh = getIntent().getStringExtra("no_umroh");
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Pengecekan Pesanan");
        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(getResources().getDrawable(R.drawable.ic_shooping));
        toolbar_iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Activity_Char.class);
                startActivity(intent);
            }
        });

        mUmrotaService.getUmrohByID(nomor_umroh.toString()).enqueue(new Callback<Model_UmrohByID>() {
            @Override
            public void onResponse(Call<Model_UmrohByID> call, Response<Model_UmrohByID> response) {
                if (response.isSuccessful()) {
                    model_umrohByID_items = response.body().getMessage();
                    for (int i = 0; i < model_umrohByID_items.size(); i++) {


                        Picasso.get().load(model_umrohByID_items.get(i).getLogo()).placeholder(R.drawable.ic_noimage).fit().into(id_img_checkout, new com.squareup.picasso.Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError(Exception e) {

                            }
                        });
                        id_namecompany.setText(model_umrohByID_items.get(i).getNamaPerusahaan());
                        id_name_umroh.setText(model_umrohByID_items.get(i).getJudulUmroh());
                        id_jadwal_keberangkatan.setText(model_umrohByID_items.get(i).getKeberangkatan());
                        id_jadwal_kepulangan.setText(model_umrohByID_items.get(i).getKepulangan());
                        id_harga.setText(model_umrohByID_items.get(i).getHargaUmroh());
                        id_hotel.setText(model_umrohByID_items.get(i).getHotel());
                        id_promo.setText(model_umrohByID_items.get(i).getDiscountPercent());
                        id_deskripsi.setText(model_umrohByID_items.get(i).getDetailUmroh());

                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Mohon Maaf Gagal Sinkronisasi Silahkan Coba Kembali", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Model_UmrohByID> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Upps,Sepertinya Jaringan Internet anda bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @OnClick(R.id.id_goCheckout)
    public void goCheckOut() {

        intent = new Intent(getApplicationContext(), Activity_Billing.class);
        intent.putExtra("nomor_umroh", nomor_umroh);
        intent.putExtra("qty",id_jumlah_ticket.getText().toString());
        startActivity(intent);

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