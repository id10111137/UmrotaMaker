package com.example.tatangit.umrota_maker.View.SignUp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Config.Model.M_PromoItem;
import com.example.tatangit.umrota_maker.Config.Model.M_Register;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Promo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_SiginUp extends AppCompatActivity {

    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    Intent intent;

    @BindView(R.id.id_namacostumer)
    EditText id_namacostumer;

    @BindView(R.id.id_username)
    EditText id_username;

    @BindView(R.id.id_password)
    EditText id_password;

    @BindView(R.id.id_email)
    EditText id_email;

    @BindView(R.id.id_phone)
    EditText id_phone;

    Umrota_Service mUmrotaService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        toolbar = findViewById(R.id.toolbar);
        mUmrotaService = Api_Utils.getSOService();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Register Account Baru");
        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);
    }

    @OnClick(R.id.id_goRegister)
    public void goRegister(){

        mUmrotaService.RegisterCostumer(id_namacostumer.getText().toString(),id_username.getText().toString(),id_password.getText().toString(),id_email.getText().toString(),id_phone.getText().toString()).enqueue(new Callback<M_Register>() {
            @Override
            public void onResponse(Call<M_Register> call, Response<M_Register> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Sukses Register", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                } else {
                    Toast.makeText(getApplicationContext(), "Gagal Register", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<M_Register> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal mengambil Koneksi Internet", Toast.LENGTH_SHORT).show();
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
