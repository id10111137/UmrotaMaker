package com.example.tatangit.umrota_maker.View.Lisence;

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
import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Lisence extends Fragment {

    Intent intent;
    Toolbar toolbar;
    TextView mTitle;
    View root;
    CircleImageView toolbar_iconView;

    public Fragment_Lisence() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_lisensi, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Lisence Apps");

        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);

        return root;
    }

}
