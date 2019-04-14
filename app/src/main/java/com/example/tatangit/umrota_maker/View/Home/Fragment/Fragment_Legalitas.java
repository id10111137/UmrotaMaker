package com.example.tatangit.umrota_maker.View.Home.Fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Hellper.ShareData;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Activity.Activity_CompanyInfo;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Gallery;
import com.example.tatangit.umrota_maker.View.Home.Model.MessageItemCompanyInfo;
import com.example.tatangit.umrota_maker.View.Home.Model.MessageItemGalleryCompany;
import com.example.tatangit.umrota_maker.View.Home.Model.ModelCompanyInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Legalitas extends Fragment {


    Intent intent;
    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    View root;
    public String nCompany;
    Umrota_Service mUmrotaService;


    @BindView(R.id.id_nama_perusahaan)
    TextView id_nama_perusahaan;

    @BindView(R.id.id_alamat_perusahaan)
    TextView id_alamat_perusahaan;

    @BindView(R.id.id_nosiup)
    TextView id_nosiup;

    @BindView(R.id.id_owner)
    TextView id_owner;

    @BindView(R.id.id_notlp)
    TextView id_notlp;

    @BindView(R.id.id_email)
    TextView id_email;

    @BindView(R.id.id_tanggalpengesahan)
    TextView id_tanggalpengesahan;

    public Fragment_Legalitas() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_lisensi, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);

        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);

        mUmrotaService = Api_Utils.getSOService();
        getInfoCompany();
        return root;
    }


    private void getInfoCompany() {

        mUmrotaService.gCompanyInfo(ShareData.data().value).enqueue(new Callback<ModelCompanyInfo>() {
            @Override
            public void onResponse(Call<ModelCompanyInfo> call, Response<ModelCompanyInfo> response) {
                if (response.isSuccessful()) {

                    final List<MessageItemCompanyInfo> messageItemCompanyInfos = response.body().getMessage();

                    id_nama_perusahaan.setText(messageItemCompanyInfos.get(0).getNamaPerusahaan());
                    id_alamat_perusahaan.setText(messageItemCompanyInfos.get(0).getAlamatPerusahaan());
                    id_nosiup.setText(String.valueOf(messageItemCompanyInfos.get(0).getNoSiup()));
                    id_owner.setText(String.valueOf(messageItemCompanyInfos.get(0).getNoNpwp()));
                    id_notlp.setText(messageItemCompanyInfos.get(0).getMobileTlp());
                    id_email.setText(messageItemCompanyInfos.get(0).getEmail());
                    id_tanggalpengesahan.setText(messageItemCompanyInfos.get(0).getStatusPerusahaan());


                } else {
                    Toast.makeText(getContext(), "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelCompanyInfo> call, Throwable t) {

            }
        });
    }

}
