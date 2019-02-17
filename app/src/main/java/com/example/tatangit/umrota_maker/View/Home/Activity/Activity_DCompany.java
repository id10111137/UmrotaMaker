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

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Config.Model.M_Company;
import com.example.tatangit.umrota_maker.Config.Model.M_Company_Item;
import com.example.tatangit.umrota_maker.Config.Model.M_Company_Umroh;
import com.example.tatangit.umrota_maker.Config.Model.M_Company_Umroh_Item;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Booking.Activity.Activity_PreBoking;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_DCompany;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Umroh;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_DCompany;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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

    ArrayList<Model_DCompany> model_dCompanies;
    @BindView(R.id.id_lv_dCompany)
    ListView id_lv_dCompany;
    Adapter_DCompany adapter_dCompany;
    Umrota_Service mUmrotaService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dcompany);
        ButterKnife.bind(this);
        mUmrotaService = Api_Utils.getSOService();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        nomor_company= getIntent().getStringExtra("nomor_company");
        nama_perusahaan = getIntent().getStringExtra("nama_perusahaan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText(nama_perusahaan);
        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(getApplication().getResources().getDrawable(R.drawable.ic_info));
        toolbar_iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Activity_CompanyInfo.class);
                intent.putExtra("nomor_company",nomor_company);
                intent.putExtra("nama_perusahaan", nama_perusahaan);
                startActivity(intent);
                }
        });

        mUmrotaService.getAllUmrohCompany(nomor_company).enqueue(new Callback<M_Company_Umroh>() {
            @Override
            public void onResponse(Call<M_Company_Umroh> call, Response<M_Company_Umroh> response) {
                Log.d("Tampilkan",""+response.message());
                if (response.isSuccessful()){

                    final List<M_Company_Umroh_Item> m_company_umroh_items = response.body().getMessage();
                    adapter_dCompany = new Adapter_DCompany(m_company_umroh_items, getApplicationContext());
                    adapter_dCompany.notifyDataSetChanged();
                    id_lv_dCompany.setAdapter(adapter_dCompany);

                } else {
                    Toast.makeText(getApplicationContext(), "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<M_Company_Umroh> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Koneksi Internet Anda Kurang Bagus", Toast.LENGTH_SHORT).show();
            }
        });

        id_lv_dCompany.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                intent = new Intent(getApplicationContext(), Activity_PreBoking.class);
                intent.putExtra("company_no", adapter_dCompany.getItem(position).getNomorCompany());
                intent.putExtra("nama_perusahaan", adapter_dCompany.getItem(position).getNamaPerusahaan());
                startActivity(intent);
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
