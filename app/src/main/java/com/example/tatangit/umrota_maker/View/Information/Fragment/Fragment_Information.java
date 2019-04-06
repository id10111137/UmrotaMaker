package com.example.tatangit.umrota_maker.View.Information.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.AddChart.Activity.Activity_Chart;
import com.example.tatangit.umrota_maker.View.Home.Activity.Activity_InfoCompany;
import com.example.tatangit.umrota_maker.View.Information.Activity.Activity_Info_Agent;
import com.example.tatangit.umrota_maker.View.Information.Activity.Activity_Info_Corpo;
import com.example.tatangit.umrota_maker.View.Information.Activity.Activity_Info_Document;
import com.example.tatangit.umrota_maker.View.Information.Activity.Activity_Info_Fasiltas;
import com.example.tatangit.umrota_maker.View.Information.Activity.Activity_Info_Manasik;
import com.example.tatangit.umrota_maker.View.Information.Activity.Activity_Info_Promo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Information extends Fragment {

    Intent intent;
    Toolbar toolbar;
    TextView mTitle;;
    View root;
    CircleImageView toolbar_iconView;

    public Fragment_Information() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_information, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Information");

        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);

        return root;
    }

    @OnClick(R.id.id_promo)
    public void goPromo(){
        intent = new Intent(getContext(), Activity_Info_Promo.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_falisitas)
    public void goFasilitas(){
        intent = new Intent(getContext(), Activity_Info_Fasiltas.class);
        startActivity(intent);
    }


    @OnClick(R.id.id_corpo)
    public void goCorpo(){
        intent = new Intent(getContext(), Activity_Info_Corpo.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_document)
    public void goDoc(){
        intent = new Intent(getContext(), Activity_Info_Document.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_agency)
    public void goAgency(){
        intent = new Intent(getContext(), Activity_Info_Agent.class);
        startActivity(intent);
    }

    @OnClick(R.id.id_manasik)
    public void goManasik(){
        intent = new Intent(getContext(), Activity_Info_Manasik.class);
        startActivity(intent);
    }


}
