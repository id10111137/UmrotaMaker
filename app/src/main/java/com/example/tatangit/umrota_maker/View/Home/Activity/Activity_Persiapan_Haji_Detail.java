package com.example.tatangit.umrota_maker.View.Home.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Activity_Persiapan_Haji_Detail extends AppCompatActivity {

    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    Intent mIntent;

    String Persiapan_;

    @BindView(R.id.id_wb)
    WebView webview;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persiapan_haji_detail);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);

        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);

        Persiapan_ = getIntent().getStringExtra("persiapan_haji");

        // setting
        webview.setWebViewClient(new WebViewClient());
        webview.setWebChromeClient(new WebChromeClient());
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setPluginState(WebSettings.PluginState.ON);
        webview.getSettings().setDefaultFontSize(18);



        if (Persiapan_.equals("keutamaan_haji")){
            muatVideo();
            mTitle.setText("Keutamaan Haji");
        }else if(Persiapan_.equals("taubat")){
            webview.loadUrl("http://www.tutorialspoint.com");
            mTitle.setText("Bertaubat Sebelum Haji");
        }else if(Persiapan_.equals("hakikat_taliyah")){
            webview.loadUrl("http://www.tutorialspoint.com");
            mTitle.setText("Keutamaan Taliyah");
        }else if(Persiapan_.equals("berhaji_harta")){
            webview.loadUrl("http://www.tutorialspoint.com");
            mTitle.setText("Berhaji Harta");
        }else if(Persiapan_.equals("jangan_maksiat")){
            webview.loadUrl("http://www.tutorialspoint.com");
            mTitle.setText("Dilarang Maksiat");
        }else if(Persiapan_.equals("jangan_debat")){
            webview.loadUrl("http://www.tutorialspoint.com");
            mTitle.setText("Dilarang Berdebat");
        }

    }


    private void muatVideo() {
        String kodeHTML = "<head></head><body><iframe width=\"560\" height=\"300\"  " +
                "src=\"https://www.youtube.com/embed/29cOJq5HNc4\" " +
                "frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe></body>";
        webview.loadData(kodeHTML,"text/html; charset=utf-8",null);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
