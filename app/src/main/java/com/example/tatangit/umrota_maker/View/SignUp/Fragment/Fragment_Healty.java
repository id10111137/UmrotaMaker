package com.example.tatangit.umrota_maker.View.SignUp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.tatangit.umrota_maker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment_Healty  extends Fragment {

    View root;


    @BindView(R.id.id_wb_healty)
    WebView id_wb_healty;

    public Fragment_Healty() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_profil_info_healty, container, false);
        ButterKnife.bind(this, root);
        id_wb_healty.loadUrl("https://en.wikipedia.org/wiki/Health_information_on_Wikipedia");
        // Enable Javascript
        WebSettings webSettings = id_wb_healty.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        id_wb_healty.setWebViewClient(new WebViewClient());
        return root;
    }


}
