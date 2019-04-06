package com.example.tatangit.umrota_maker.View.Home.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.CheckOut.Activity.Activity_Checkout;
import com.example.tatangit.umrota_maker.View.Home.Activity.Activity_Persiapan_Haji;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Home_Index extends Fragment {


    Intent mIntent;
    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    View root;
    Umrota_Service mUmrotaService;

    public Fragment_Home_Index() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home_index, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Let's Go Umroh");
        mUmrotaService = Api_Utils.getSOService();
        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);
        return root;
    }

    @OnClick(R.id.id_persiapan_haji)
    public void PersiapanHaji(){
        mIntent = new Intent(getContext(), Activity_Persiapan_Haji.class);
        startActivity(mIntent);
    }

    @OnClick(R.id.id_fikih_haji)
    public void goFikihHaji(){
        mIntent = new Intent(getContext(), Activity_Persiapan_Haji.class);
        startActivity(mIntent);
    }

    @OnClick(R.id.id_fikih_umroh)
    public void gofikihUmroh(){
        mIntent = new Intent(getContext(), Activity_Persiapan_Haji.class);
        startActivity(mIntent);
    }

    @OnClick(R.id.id_dzikir_doa)
    public void goDzikirDoa(){
        mIntent = new Intent(getContext(), Activity_Persiapan_Haji.class);
        startActivity(mIntent);
    }

    @OnClick(R.id.id_tata_Cara_umroh)
    public void goTataCaraUmroh(){
        mIntent = new Intent(getContext(), Activity_Persiapan_Haji.class);
        startActivity(mIntent);
    }

    @OnClick(R.id.id_tata_cara_haji)
    public void goTataCaraHaji(){
        mIntent = new Intent(getContext(), Activity_Persiapan_Haji.class);
        startActivity(mIntent);
    }

    @OnClick(R.id.id_tanya)
    public void goTanya(){
        mIntent = new Intent(getContext(), Activity_Persiapan_Haji.class);
        startActivity(mIntent);
    }

    @OnClick(R.id.id_lokasi_ziaroh)
    public void goZiaroh(){
        mIntent = new Intent(getContext(), Activity_Persiapan_Haji.class);
        startActivity(mIntent);
    }

}
