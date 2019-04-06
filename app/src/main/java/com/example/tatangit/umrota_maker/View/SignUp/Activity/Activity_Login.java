package com.example.tatangit.umrota_maker.View.SignUp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.MainActivity;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_User;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_UserItem;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Login extends AppCompatActivity {


    Intent mIntent;
    Umrota_Service mUmrotaService;

    @BindView(R.id.id_username)
    EditText id_username;
    @BindView(R.id.id_password)
    EditText id_password;
    Model_UserItem model_userItem;

    KProgressHUD hud;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mUmrotaService = Api_Utils.getSOService();


        hud = KProgressHUD.create(this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setDetailsLabel("Downloading data")
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);





         /*
            Start Slider Into
            No Izin Travel
            Checkout // booking seat
            No Kartu kesehatan // delete
            akte / delete
           1.  passpoert
           2. mengitis
           3. Fvs
         */

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SharedPreferences sharedPreferences = getSharedPreferences(Config.FLAG, Context.MODE_PRIVATE);
//                if (sharedPreferences.getBoolean(Config.FLAG, true)) {
//                    startActivity(new Intent(Activity_Login.this, DefaultIntro.class));
//                    SharedPreferences.Editor e = sharedPreferences.edit();
//                    e.putBoolean(Config.FLAG, false);
//                    e.apply();
//                }
//            }
//        });
//        t.start();

        if (UserModelManager.getInstance(getApplicationContext()).isLoggedIn()) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

         /*
          End Start Slider Into
         */
    }

    @OnClick(R.id.id_goLogin)
    public void goLogin() {

        hud.show();
        if(id_username.getText().toString().isEmpty()){
            id_username.setError("Field Username Belum Di Isi");
        }else if(id_password.getText().toString().isEmpty()){
            id_password.setError("Field Password Belum Di Isi");
        }else {

            mUmrotaService.LoginCostumer(id_username.getText().toString(), id_password.getText().toString()).enqueue(new Callback<Model_User>() {
                @Override
                public void onResponse(Call<Model_User> call, Response<Model_User> response) {
                    if (response.isSuccessful()) {
                        final List<Model_UserItem> lLogin = response.body().getMessage();
                        for (int i = 0; i < lLogin.size(); i++) {
                            model_userItem = new Model_UserItem(
                                    lLogin.get(i).getUsia(), lLogin.get(i).getNomorCostumer(),
                                    lLogin.get(i).getNomorTlp(), lLogin.get(i).getUrlPhoto(),
                                    lLogin.get(i).getNomorPassport(), lLogin.get(i).getNomorNpwp(),
                                    lLogin.get(i).getPassword(), lLogin.get(i).getAlamatCostumer(), lLogin.get(i).getNomorKtp(),
                                    lLogin.get(i).getCreateDate(), lLogin.get(i).getJenisKelamin(), lLogin.get(i).getNamaCostumer(),
                                    lLogin.get(i).getEmail(), lLogin.get(i).getNomorKartuKesehatan(), lLogin.get(i).getUsername(),
                                    lLogin.get(i).getStatus());
                        }



                        UserModelManager.getInstance(getApplicationContext()).UserLogin(model_userItem);
                        mIntent = new Intent(getApplicationContext(), MainActivity.class);
                        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(mIntent);

                    } else {

                        Toast.makeText(getApplicationContext(), "Gagal Untuk Menghubungkan Ke Server", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Model_User> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Silahkan Periksa Username atau Password", Toast.LENGTH_SHORT).show();
                    hud.dismiss();
                }
            });
        }
    }

    @OnClick(R.id.id_Goregister)
    public void GoRegister() {
        mIntent = new Intent(getApplicationContext(), Activity_Register.class);
        startActivity(mIntent);
    }
}
