package com.example.tatangit.umrota_maker.View.SignUp.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Config.Model.M_Register;
import com.example.tatangit.umrota_maker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Register extends AppCompatActivity {

    Intent mIntent;
    Umrota_Service mUmrotaService;


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

    SweetAlertDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mUmrotaService = Api_Utils.getSOService();

        pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Mohon Menunggu");
        pDialog.setCancelable(false);

    }


    @OnClick(R.id.id_goRegister)
    public void mRegister() {

        if (id_namacostumer.getText().toString().isEmpty()) {
            id_namacostumer.setError("Field Full Name Sepertinya Belum Terisi");
        } else if (id_username.getText().toString().isEmpty()) {
            id_username.setError("Field Username Sepertinya Belum Terisi");
        } else if (id_password.getText().toString().isEmpty()) {
            id_password.setError("Field Password Sepertinya Belum Terisi");
        } else if (id_email.getText().toString().isEmpty()) {
            id_email.setError("Field Email Sepertinya Belum Terisi");
        }  else {
            pDialog.show();
            mUmrotaService.RegisterCostumer(id_namacostumer.getText().toString(), id_username.getText().toString(), id_password.getText().toString(), id_email.getText().toString(), id_phone.getText().toString()).enqueue(new Callback<M_Register>() {
                @Override
                public void onResponse(Call<M_Register> call, Response<M_Register> response) {
                    if (response.isSuccessful()) {
                        pDialog.dismiss();
                        Toast.makeText(Activity_Register.this, "Terima Kasih Pendaftaran Sudah Berhasil, Silahkan Login ", Toast.LENGTH_SHORT).show();
                        ResetData();
                    } else {
                        pDialog.dismiss();
                        Toast.makeText(Activity_Register.this, "Mohon Maaf, Registrasi Anda Gagal. Mohon Coba Lain Kali ", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<M_Register> call, Throwable t) {
                    pDialog.dismiss();
                    Toast.makeText(Activity_Register.this, "Upps,Sepertinya Jaringan Internet anda bermasalah", Toast.LENGTH_SHORT).show();

                }
            });
        }
    }


    private void ResetData() {
        id_namacostumer.setText("");
        id_username.setText("");
        id_password.setText("");
        id_email.setText("");
        id_phone.setText("");
    }

    @OnClick(R.id.id_goLogin)
    public void goLogin() {
        mIntent = new Intent(getApplicationContext(), Activity_Login.class);
        startActivity(mIntent);

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
