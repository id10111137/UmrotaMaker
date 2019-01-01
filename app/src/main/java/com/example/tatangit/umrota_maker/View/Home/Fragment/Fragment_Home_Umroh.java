package com.example.tatangit.umrota_maker.View.Home.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.AddChart.Activity.Activity_Chart;
import com.example.tatangit.umrota_maker.View.Home.Activity.Activity_DCompany;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Umroh;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Umroh;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Home_Umroh extends Fragment {


    Intent intent;
    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    View root;

    @BindView(R.id.id_cari)
    EditText id_cari;

    @BindView(R.id.id_lv_umroh)
    ListView id_lv_umroh;

    Adapter_Umroh adapter_umroh;
    ArrayList<Model_Umroh> model_umroh;

    public Fragment_Home_Umroh() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home_umroh, container, false);
        ButterKnife.bind(this, root);

        toolbar = getActivity().findViewById(R.id.toolbar);


        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("UMROH");
        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_shoping));
        toolbar_iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), Activity_Chart.class);
                startActivity(intent);
            }
        });

        DummyData();
        adapter_umroh = new Adapter_Umroh(model_umroh, getContext());
        id_lv_umroh.setAdapter(adapter_umroh);

        id_lv_umroh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                intent = new Intent(getContext(), Activity_DCompany.class);
                intent.putExtra("name_company", adapter_umroh.getItem(position).getNama_Perusahaan());
                startActivity(intent);
            }
        });

        return root;
    }


    private void DummyData() {
        model_umroh = new ArrayList<>();
        model_umroh.add(new Model_Umroh("http://1.bp.blogspot.com/-xpZkyLTrBak/VfZOfgEHn9I/AAAAAAAAEIg/Mr_XSNjxsl4/s1600/haji.jpg","Pt. Rusanawa","Jl. Padjajaran","Hajji Dan Umroh","10/minggu"));
        model_umroh.add(new Model_Umroh("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg","Pt. Lama TakJumpa","Jl. Setiabudhi","Hajji Dan Umroh","10/minggu"));
        model_umroh.add(new Model_Umroh("http://1.bp.blogspot.com/-xpZkyLTrBak/VfZOfgEHn9I/AAAAAAAAEIg/Mr_XSNjxsl4/s1600/haji.jpg","Pt. Sanbe","Jl. Mercubuana","Hajji Dan Umroh","10/minggu"));
        model_umroh.add(new Model_Umroh("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg","Pt. Umbro","Jl. Unikom","Hajji Dan Umroh","10/minggu"));
        model_umroh.add(new Model_Umroh("http://1.bp.blogspot.com/-xpZkyLTrBak/VfZOfgEHn9I/AAAAAAAAEIg/Mr_XSNjxsl4/s1600/haji.jpg","Cv. Rakutak","Jl. Salatiga","Hajji Dan Umroh","10/minggu"));
        model_umroh.add(new Model_Umroh("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg","Pt. RockStart","Jl. Sangubuana","Hajji Dan Umroh","10/minggu"));
        model_umroh.add(new Model_Umroh("http://1.bp.blogspot.com/-xpZkyLTrBak/VfZOfgEHn9I/AAAAAAAAEIg/Mr_XSNjxsl4/s1600/haji.jpg","Pt. LongbeSong","Jl. Ragaji Mesin","Hajji Dan Umroh","10/minggu"));
        model_umroh.add(new Model_Umroh("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg","Pt. Rgaji","Jl. Brhamanuksi","Hajji Dan Umroh","10/minggu"));
        model_umroh.add(new Model_Umroh("http://1.bp.blogspot.com/-xpZkyLTrBak/VfZOfgEHn9I/AAAAAAAAEIg/Mr_XSNjxsl4/s1600/haji.jpg","Pt. Sokume","Jl. Citarum","Hajji Dan Umroh","10/minggu"));
    }
}