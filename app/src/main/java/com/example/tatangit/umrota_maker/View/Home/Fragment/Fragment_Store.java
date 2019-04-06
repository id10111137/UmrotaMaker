package com.example.tatangit.umrota_maker.View.Home.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Store;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Store;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import mehdi.sakout.dynamicbox.DynamicBox;

public class Fragment_Store extends Fragment {


    Intent intent;
    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    View root;

    @BindView(R.id.id_lv_store)
    ListView id_lv_store;

    Adapter_Store adapter_store;
    ArrayList<Model_Store> modelStores;

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

        DummyData();
        adapter_store = new Adapter_Store(modelStores, getContext());
        id_lv_store.setAdapter(adapter_store);

        DynamicBox box = new DynamicBox(getContext(),id_lv_store);
        box.showLoadingLayout();

        return root;
    }

    private void DummyData() {
        modelStores = new ArrayList<>();
        modelStores.add(new Model_Store("st001","Agent Bagus Jaya","Jl. Barokah Hijau Murni Berkilau","2839028092","Buka Toko Jam, 08:00-10:00","http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg"));
        modelStores.add(new Model_Store("st002","Agent Suganteng Karya","Jl. Mangga Aromanis","2839028092","Buka Toko Jam, 08:00-10:00","http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg"));
        modelStores.add(new Model_Store("st003","Agent Maknyos rambut","Jl. Suratami","2839028092","Buka Toko Jam, 08:00-10:00","http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg"));
        modelStores.add(new Model_Store("st004","Agent Rambo Maknyus","Jl. Barokah Hijau Murni Berkilau","2839028092","Buka Toko Jam, 08:00-10:00","http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg"));
        modelStores.add(new Model_Store("st005","Agent Toko Mambo","Jl. Barokah Hijau Murni Berkilau","2839028092","Buka Toko Jam, 08:00-10:00","http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg"));
        modelStores.add(new Model_Store("st006","Agent Rambu Lalu Lintas","Jl. Barokah Hijau Murni Berkilau","2839028092","Buka Toko Jam, 08:00-10:00","http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg"));
        modelStores.add(new Model_Store("st007","Bambu Kuning","Jl. Barokah Hijau Murni Berkilau","2839028092","Buka Toko Jam, 08:00-10:00","http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg"));
        modelStores.add(new Model_Store("st008","Bambu Hijau","Jl. Barokah Hijau Murni Berkilau","2839028092","Buka Toko Jam, 08:00-10:00","http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg"));
        modelStores.add(new Model_Store("st009","Kungi Hijau","Jl. Barokah Hijau Murni Berkilau","2839028092","Buka Toko Jam, 08:00-10:00","http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg"));
        modelStores.add(new Model_Store("st010","Cemanggi Hijau","Jl. Barokah Hijau Murni Berkilau","2839028092","Buka Toko Jam, 08:00-10:00","http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg"));
    }

}
