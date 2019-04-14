package com.example.tatangit.umrota_maker.View.Information.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Dokumentasi extends Fragment {



    Intent mIntent;
    Toolbar toolbar;
    TextView mTitle;;
    View root;
    CircleImageView toolbar_iconView;

    @BindView(R.id.id_wb_document)
    WebView id_wb_document;


    public Fragment_Dokumentasi() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_information_document, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Document Information");
        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);

        id_wb_document.loadUrl("http://www.tutorialspoint.com");

        return root;
    }



}
