package com.example.tatangit.umrota_maker.View.Home.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Gallery;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Company_Gallery;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_GalleryPhoto extends Fragment {


    Intent intent;
    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    View root;
    ArrayList<Model_Company_Gallery> model_company_galleries;
    public String Nomor_Company;


    public Fragment_GalleryPhoto() {
    }

    @BindView(R.id.customgrid)
    GridView gridView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_gallery_photo, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);



        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);
        DummyData();
        gridView.setAdapter(new Adapter_Gallery(model_company_galleries,getContext()));
        return root;
    }

    private void DummyData() {
        model_company_galleries = new ArrayList<>();
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_company_galleries.add(new Model_Company_Gallery("123456789", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));

    }

}
