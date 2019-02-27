package com.example.tatangit.umrota_maker.View.SignUp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.MainActivity;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_User;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_UserItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class Fragment_MyProfil extends Fragment {


    Intent intent;
    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    View root;

    Model_UserItem model_userItem;

    @BindView(R.id.id_nama)
    EditText id_nama;
    @BindView(R.id.id_alamat)
    EditText id_alamat;
    @BindView(R.id.id_notlp)
    EditText id_notlp;
    @BindView(R.id.id_nonpwp)
    EditText id_nonpwp;
    @BindView(R.id.id_nopassport)
    EditText id_nopassport;
    @BindView(R.id.id_nomor_ktp)
    EditText id_nomor_ktp;
    @BindView(R.id.id_email)
    EditText id_email;
    @BindView(R.id.id_usia)
    EditText id_usia;
    @BindView(R.id.id_jk)
    EditText id_jk;
    @BindView(R.id.id_nokartukesehatan)
    EditText id_nokartukesehatan;
    @BindView(R.id.id_username)
    EditText id_username;
    @BindView(R.id.id_password)
    EditText id_password;

    Umrota_Service mUmrotaService;

    public Fragment_MyProfil() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_myprofil, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);
        model_userItem = UserModelManager.getInstance(getContext()).getUser();
        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);

        mUmrotaService = Api_Utils.getSOService();

        setProfil();
        return root;
    }

    private void setProfil() {
        id_nama.setText(model_userItem.getNamaCostumer());
        id_alamat.setText(model_userItem.getAlamatCostumer());
        id_notlp.setText(model_userItem.getNomorTlp());
        id_nonpwp.setText(model_userItem.getNomorNpwp());
        id_nopassport.setText(model_userItem.getNomorPassport());
        id_nomor_ktp.setText(model_userItem.getNomorKtp());
        id_email.setText(model_userItem.getEmail());
        id_usia.setText(model_userItem.getUsia());
        id_jk.setText(model_userItem.getJenisKelamin());
        id_nokartukesehatan.setText(model_userItem.getNomorKartuKesehatan());
        id_username.setText(model_userItem.getUsername());
        id_password.setText(model_userItem.getPassword());
    }

    @OnClick(R.id.id_goSimpan)
    public void goSimpan() {

        mUmrotaService.cProfil(model_userItem.getNomorCostumer(), id_nama.getText().toString(), id_alamat.getText().toString(),
                id_notlp.getText().toString(),
                id_nonpwp.getText().toString(),
                id_nopassport.getText().toString(),
                id_nomor_ktp.getText().toString(),
                id_email.getText().toString(),
                id_usia.getText().toString(),
                id_jk.getText().toString(),
                id_nokartukesehatan.getText().toString(),
                id_username.getText().toString(),
                id_password.getText().toString()).enqueue(new Callback<Model_User>() {
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

                    UserModelManager.getInstance(getContext()).UserLogin(model_userItem);

                } else {
                    Toast.makeText(getContext(), "Gagal Mengambil Data"+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Model_User> call, Throwable t) {

            }
        });


    }

}
