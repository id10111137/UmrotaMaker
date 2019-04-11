package com.example.tatangit.umrota_maker.View.Home.Fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.SignUp.Activity.Activity_Login;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import ir.apend.slider.model.Slide;
import ir.apend.slider.ui.Slider;

public class Fragment_Home_Index extends Fragment {


    Intent mIntent;
    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    View root;
    Umrota_Service mUmrotaService;
    View dialogView;
    AlertDialog alertDialog = null;


//    Slider slider = findViewById(R.id.slider);

    @BindView(R.id.slider)
    Slider slider;


    public Fragment_Home_Index() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home_index, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Ayo Kita Haji~Umroh");
        mUmrotaService = Api_Utils.getSOService();
        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        try {

            if (!UserModelManager.getInstance(getContext()).isLoggedIn()) {
                toolbar_iconView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.login));
                toolbar_iconView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mIntent = new Intent(getContext(), Activity_Login.class);
                        startActivity(mIntent);
                    }
                });
            } else {
                toolbar_iconView.setImageDrawable(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //create list of slides
        List<Slide> slideList = new ArrayList<>();
        slideList.add(new Slide(0, "http://cssslider.com/sliders/demo-20/data1/images/picjumbo.com_img_4635.jpg", getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        slideList.add(new Slide(1, "http://cssslider.com/sliders/demo-12/data1/images/picjumbo.com_hnck1995.jpg", getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        slideList.add(new Slide(2, "http://cssslider.com/sliders/demo-19/data1/images/picjumbo.com_hnck1588.jpg", getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));
        slideList.add(new Slide(3, "http://wowslider.com/sliders/demo-18/data1/images/shanghai.jpg", getResources().getDimensionPixelSize(R.dimen.slider_image_corner)));

        slider.setItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //do what you want
            }
        });

        slider.addSlides(slideList);


        return root;
    }


    @OnClick(R.id.id_persiapan_haji)
    public void PersiapanHaji() {
        selectImage("Persiapan Haji", "iHkKoP-M6Sw");
    }

    @OnClick(R.id.id_fikih_haji)
    public void goFikihHaji() {

        selectImage("Fikih Haji", "88WP5NeRl04");
    }

    @OnClick(R.id.id_fikih_umroh)
    public void gofikihUmroh() {
        selectImage("Fikih Umroh", "3-bWtoxhvuA");
    }

    @OnClick(R.id.id_dzikir_doa)
    public void goDzikirDoa() {
        selectImage("Dzikir ~ Doa", "ZzfqyMqB6FE");
    }

    @OnClick(R.id.id_tata_Cara_umroh)
    public void goTataCaraUmroh() {
        selectImage("Tata Cara Umroh", "XJBibv9_FBI");
    }

    @OnClick(R.id.id_tata_cara_haji)
    public void goTataCaraHaji() {
        selectImage("Tata Cara Haji", "ey5-OFfdRq8");
    }


    @OnClick(R.id.id_lokasi_ziaroh)
    public void goZiaroh() {
        selectImage("Lokasi Ziaroh", "Xy_wE3lJ8hs");
    }


    private void selectImage(String Title, String NoEmbede) {

        //before inflating the custom alert dialog layout, we will get the current activity viewgroup

        dialogView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_index_detail, null);

        //Now we need an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.create().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        //setting the view of the builder to our custom view that we already inflated

        builder.setCancelable(false);
        builder.setView(dialogView);

        //finally creating the alert dialog and displaying it
        alertDialog = builder.create();
        alertDialog.show();

        TextView id_tv_header = dialogView.findViewById(R.id.id_tv_header);
        id_tv_header.setText(Title);

        ImageView id_img_close = dialogView.findViewById(R.id.id_img_close);
        id_img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        WebView webview = dialogView.findViewById(R.id.id_webview);
        webview.setWebViewClient(new WebViewClient());
        webview.setWebChromeClient(new WebChromeClient());
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setPluginState(WebSettings.PluginState.ON);
        webview.getSettings().setDefaultFontSize(18);
        String kodeHTML = "<head></head><body><iframe src=\"https://www.youtube.com/embed/" + NoEmbede + "\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe></body>";
        webview.loadData(kodeHTML, "text/html; charset=utf-8", null);
    }


}
