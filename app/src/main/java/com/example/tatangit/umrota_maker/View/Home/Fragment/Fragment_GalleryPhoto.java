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
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Hellper.ShareData;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Gallery;
import com.example.tatangit.umrota_maker.View.Home.Model.MessageItemCompanyInfo;
import com.example.tatangit.umrota_maker.View.Home.Model.MessageItemGalleryCompany;
import com.example.tatangit.umrota_maker.View.Home.Model.ModelGalleryCompany;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Company_Gallery;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import mehdi.sakout.dynamicbox.DynamicBox;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_GalleryPhoto extends Fragment {


    Intent mIntent;
    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    View root;
    ArrayList<Model_Company_Gallery> model_company_galleries;
    Umrota_Service mUmrotaService;
    Adapter_Gallery adapter_gallery;

    @BindView(R.id.customgrid)
    GridView gridView;
    DynamicBox box;


    public Fragment_GalleryPhoto() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_gallery_photo, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);
        mUmrotaService = Api_Utils.getSOService();
        DummyData();
        box = new DynamicBox(getContext(),gridView);
        box.showLoadingLayout();
        return root;
    }

    private void DummyData() {
        mUmrotaService.gGallery(ShareData.data().value).enqueue(new Callback<ModelGalleryCompany>() {
            @Override
            public void onResponse(Call<ModelGalleryCompany> call, Response<ModelGalleryCompany> response) {
                if (response.isSuccessful()){

                    final List<MessageItemGalleryCompany> messageItemGalleryCompanies = response.body().getMessage();
                    adapter_gallery = new Adapter_Gallery(messageItemGalleryCompanies, getContext());
                    adapter_gallery.notifyDataSetChanged();
                    gridView.setAdapter(adapter_gallery);

                } else {
                    Toast.makeText(getContext(), "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelGalleryCompany> call, Throwable t) {
                Toast.makeText(getContext(), "Check Koneksi", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
