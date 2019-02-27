package com.example.tatangit.umrota_maker.View.SignUp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Config.Model.M_Register;
import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.MainActivity;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_UserItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mUmrotaService = Api_Utils.getSOService();

    }


    @OnClick(R.id.id_goRegister)
    public void mRegister() {
        mUmrotaService.RegisterCostumer(id_namacostumer.getText().toString(), id_username.getText().toString(), id_password.getText().toString(), id_email.getText().toString(), id_phone.getText().toString()).enqueue(new Callback<M_Register>() {
            @Override
            public void onResponse(Call<M_Register> call, Response<M_Register> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Activity_Register.this, "Register Sukses ", Toast.LENGTH_SHORT).show();
                    ResetData();
                } else {
                    Toast.makeText(Activity_Register.this, "Register Gagal ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<M_Register> call, Throwable t) {
                Toast.makeText(Activity_Register.this, "Tidak Ada Koneksi", Toast.LENGTH_SHORT).show();
            }
        });
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
