package com.example.tatangit.umrota_maker.View.SignUp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.SignUp.Model.M_Costumer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Fragment_MyInfo extends Fragment {

    View root;
    M_Costumer m_costumer;


    @BindView(R.id.id_noktp)
    EditText id_noktp;
    @BindView(R.id.id_fullname)
    EditText id_fullname;
    @BindView(R.id.id_email)
    EditText id_email;
    @BindView(R.id.id_phone)
    EditText id_phone;
    @BindView(R.id.id_alamat)
    EditText id_alamat;
    @BindView(R.id.id_username)
    EditText id_username;
    @BindView(R.id.id_password)
    EditText id_password;
    @BindView(R.id.id_nonpwp)
    EditText id_nonpwp;
    @BindView(R.id.id_nopassport)
    EditText id_nopassport;


    public Fragment_MyInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_profil_info_myinfo, container, false);
        ButterKnife.bind(this, root);
        m_costumer = UserModelManager.getInstance(getContext()).getUser();

        id_fullname.setText(m_costumer.getNamaCostumer());
        id_phone.setText(m_costumer.getNomorTlp());
        id_email.setText(m_costumer.getEmail());
        id_username.setText(m_costumer.getUsername());
        id_password.setText(m_costumer.getPassword());
        id_nonpwp.setText(m_costumer.getNomorNpwp());
        id_nopassport.setText(m_costumer.getNomorPassport());
        id_noktp.setText(m_costumer.getNomorKtp());
        id_alamat.setText(m_costumer.getAlamatCostumer());

        return root;
    }

    @OnClick(R.id.id_myInfo_saving)
    public void getSaving(){

    }
}
