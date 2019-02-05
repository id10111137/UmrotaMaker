package com.example.tatangit.umrota_maker.View.SignUp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tatangit.umrota_maker.R;


public class Fragment_MyInfo extends Fragment {

    View root;

    public Fragment_MyInfo() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        root = inflater.inflate(R.layout.fragment_profil_info_myinfo, container, false);
//        ButterKnife.bind(this, root);
//
//        return root;
//    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil_info_myinfo, container, false);
    }
}
