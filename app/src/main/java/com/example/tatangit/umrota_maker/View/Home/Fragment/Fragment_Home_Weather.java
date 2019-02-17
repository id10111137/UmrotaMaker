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

import com.example.tatangit.umrota_maker.R;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Home_Weather extends Fragment {


    Intent intent;
    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;

    @BindView(R.id.imageSlider)
            SliderLayout sliderLayout;

    View root;
    public Fragment_Home_Weather() {
        // Required empty public constructor Activity_Transaksi_Result
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home_weather, container, false);
        ButterKnife.bind(this, root);

        toolbar = getActivity().findViewById(R.id.toolbar);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Wellcome Umrota_Service Maker");
        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);


        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        setSliderViews();

        return root;
    }

    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            SliderView sliderView = new SliderView(getContext());

            switch (i) {
                case 0:
                    sliderView.setImageUrl("http://stanli.co.id/wp-content/uploads/2014/03/slider-111.png");
                    break;
                case 1:
                    sliderView.setImageUrl("http://stanli.co.id/wp-content/uploads/2015/09/edit-kelapa.png");
                    break;
                case 2:
                    sliderView.setImageUrl("http://stanli.co.id/wp-content/uploads/2014/07/CREAM-CAKE-PANDAN-2-300x212.png");
                    break;
                case 3:
                    sliderView.setImageUrl("http://stanli.co.id/wp-content/uploads/2014/08/family-pack-satuan-cut-resize.png");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setDescription("setDescription " + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(getContext(), "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
}
}
