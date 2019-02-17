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
import com.example.tatangit.umrota_maker.Config.Model.M_Company_Item;
import com.example.tatangit.umrota_maker.Config.Model.M_Login;
import com.example.tatangit.umrota_maker.Config.Model.M_Login_Item;
import com.example.tatangit.umrota_maker.Config.Model.M_Register;
import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Booking.Activity.Activity_PreBoking;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Umroh;
import com.example.tatangit.umrota_maker.View.SignUp.Model.M_Costumer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Login extends AppCompatActivity {

    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    Intent intent;
    Umrota_Service mUmrotaService;
    M_Costumer m_costumer;

    @BindView(R.id.id_username)
    EditText username;

    @BindView(R.id.id_password)
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mUmrotaService = Api_Utils.getSOService();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Login Apps");
        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);
    }

    @OnClick(R.id.id_Goregister)
    public void goRegister() {
        intent = new Intent(getApplicationContext(), Activity_SiginUp.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_goLogin)
    public void goLogin() {
        mUmrotaService.LoginCostumer(username.getText().toString(), password.getText().toString()).enqueue(new Callback<M_Login>() {
            @Override
            public void onResponse(Call<M_Login> call, Response<M_Login> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Sukses Register", Toast.LENGTH_SHORT).show();
                    final List<M_Login_Item> MCompanyItemList = response.body().getMessage();
                    for (int i = 0; i < MCompanyItemList.size(); i++) {
                        m_costumer = new M_Costumer(
                                MCompanyItemList.get(i).getUsia(),
                                MCompanyItemList.get(i).getNomorCostumer(),
                                MCompanyItemList.get(i).getNomorTlp(),
                                MCompanyItemList.get(i).getUrlPhoto(),
                                MCompanyItemList.get(i).getNomorPassport(),
                                MCompanyItemList.get(i).getNomorNpwp(),
                                MCompanyItemList.get(i).getPassword(),
                                MCompanyItemList.get(i).getAlamatCostumer(),
                                MCompanyItemList.get(i).getNomorKtp(),
                                MCompanyItemList.get(i).getCreateDate(),
                                MCompanyItemList.get(i).getJenisKelamin(),
                                MCompanyItemList.get(i).getNamaCostumer(),
                                MCompanyItemList.get(i).getEmail(),
                                MCompanyItemList.get(i).getNomorKartuKesehatan(),
                                MCompanyItemList.get(i).getUsername(),
                                MCompanyItemList.get(i).getStatus()
                        );
                        UserModelManager.getInstance(getApplicationContext().getApplicationContext()).UserLogin(m_costumer);
                        Intent intent = new Intent(getApplicationContext(), Activity_PreBoking.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getApplicationContext().startActivity(intent);
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Gagal Register", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<M_Login> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal Login", Toast.LENGTH_SHORT).show();
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
