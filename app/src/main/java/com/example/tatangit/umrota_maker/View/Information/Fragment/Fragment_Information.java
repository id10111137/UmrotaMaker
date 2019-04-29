package com.example.tatangit.umrota_maker.View.Information.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.R;

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



}
