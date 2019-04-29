package com.example.tatangit.umrota_maker.View.Home.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Hellper.ShareData;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Gallery;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Store;
import com.example.tatangit.umrota_maker.View.Home.Model.MessageItemCompanyStore;
import com.example.tatangit.umrota_maker.View.Home.Model.MessageItemGalleryCompany;
import com.example.tatangit.umrota_maker.View.Home.Model.ModelCompanyStore;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Store;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import mehdi.sakout.dynamicbox.DynamicBox;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Store extends Fragment {


    Intent intent;
    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    View root;

    @BindView(R.id.id_lv_store)
    ListView id_lv_store;

    @BindView(R.id.id_cari_store)
    EditText id_cari_store;

    Adapter_Store adapter_store;
    ArrayList<Model_Store> modelStores;

    Umrota_Service mUmrotaService;


    public Fragment_Store() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_store, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);
        mUmrotaService = Api_Utils.getSOService();


        DynamicBox box = new DynamicBox(getContext(), id_lv_store);
        box.showLoadingLayout();
        DummyData();

        id_cari_store.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter_store.filter(charSequence.toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter_store.filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


        return root;
    }



    private void DummyData() {

        mUmrotaService.gCompanyStore(ShareData.data().value).enqueue(new Callback<ModelCompanyStore>() {
            @Override
            public void onResponse(Call<ModelCompanyStore> call, Response<ModelCompanyStore> response) {

                if (response.isSuccessful()) {

                    final List<MessageItemCompanyStore> messageItemCompanyStores = response.body().getMessage();
                    adapter_store = new Adapter_Store(messageItemCompanyStores, getContext());
                    adapter_store.notifyDataSetChanged();
                    id_lv_store.setAdapter(adapter_store);

                } else {
                    Toast.makeText(getContext(), "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelCompanyStore> call, Throwable t) {
                Toast.makeText(getContext(), "Koneksi Jaringan Error", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
