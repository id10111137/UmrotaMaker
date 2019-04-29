package com.example.tatangit.umrota_maker.View.Home.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Config.Model.M_Company_Umroh;
import com.example.tatangit.umrota_maker.Config.Model.M_Company_Umroh_Item;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.CheckOut.Activity.Activity_Checkout;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_DCompany;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_DCompany extends AppCompatActivity {

    Toolbar toolbar;
    public String nomor_company;
    public String nama_perusahaan;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    Intent intent;

    @BindView(R.id.id_lv_dCompany)
    ListView id_lv_dCompany;
    Adapter_DCompany adapter_dCompany;
    Umrota_Service mUmrotaService;
    List<M_Company_Umroh_Item> m_company_umroh_items;


    @BindView(R.id.id_svd_umroh)
    EditText id_svd_umroh;
    SweetAlertDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcompany);
        ButterKnife.bind(this);
        mUmrotaService = Api_Utils.getSOService();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        nomor_company = getIntent().getStringExtra("nomor_company");
        nama_perusahaan = getIntent().getStringExtra("nama_perusahaan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText(nama_perusahaan);
        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(getApplication().getResources().getDrawable(R.drawable.ic_information));
        toolbar_iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Activity_CompanyInfo.class);
                intent.putExtra("nomor_company", nomor_company);
                intent.putExtra("nama_perusahaan", nama_perusahaan);
                startActivity(intent);
            }
        });


        pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Mohon Menunggu");
        pDialog.setCancelable(false);
        pDialog.show();

        mUmrotaService.getAllUmrohCompany(nomor_company).enqueue(new Callback<M_Company_Umroh>() {
            @Override
            public void onResponse(Call<M_Company_Umroh> call, Response<M_Company_Umroh> response) {
                if (response.isSuccessful()) {
                    pDialog.dismiss();
                    m_company_umroh_items = response.body().getMessage();
                    adapter_dCompany = new Adapter_DCompany(m_company_umroh_items, getApplicationContext());
                    adapter_dCompany.notifyDataSetChanged();
                    id_lv_dCompany.setAdapter(adapter_dCompany);

                } else {
                    pDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Ups, Gagal Sinkron", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<M_Company_Umroh> call, Throwable t) {
                pDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Koneksi Internet Anda Kurang Bagus", Toast.LENGTH_SHORT).show();
            }
        });

        id_lv_dCompany.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                intent = new Intent(getApplicationContext(), Activity_Checkout.class);
                intent.putExtra("no_umroh", adapter_dCompany.getItem(position).getNomorUmroh());
                startActivity(intent);
            }
        });


        id_svd_umroh.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter_dCompany.filter(charSequence.toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter_dCompany.filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

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
