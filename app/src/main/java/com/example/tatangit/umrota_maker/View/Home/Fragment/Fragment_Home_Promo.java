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
import com.example.tatangit.umrota_maker.View.Booking.Activity.Activity_Booking;
import com.example.tatangit.umrota_maker.View.Home.Activity.Activity_DCompany;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Promo;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Umroh;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Promo;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Umroh;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Home_Promo extends Fragment {

    Intent intent;
    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    View root;


    @BindView(R.id.id_lv_promo)
    ListView id_lv_promo;

    Adapter_Promo adapter_promo;
    ArrayList<Model_Promo> model_promos;


    public Fragment_Home_Promo() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home_promo, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);


        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("UMROH PROMO");
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
        adapter_promo = new Adapter_Promo(model_promos, getContext());
        id_lv_promo.setAdapter(adapter_promo);

        id_lv_promo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                intent = new Intent(getContext(), Activity_Booking.class);
                intent.putExtra("company_no", adapter_promo.getItem(position).getNama_Perusahaan());
                startActivity(intent);
            }
        });
        return root;
    }

    private void DummyData() {
        model_promos = new ArrayList<>();
        model_promos.add(new Model_Promo("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg", "10%", "Pt. Samurco", "2018/10/2018", "300k", "Bansung", 3));
        model_promos.add(new Model_Promo("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg", "20%", "Pt. Gugu", "2018/10/2018", "200k", "Jakarta", 4));
        model_promos.add(new Model_Promo("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg", "5%", "Pt. Anday", "2018/10/2018", "100K", "Jakarta", 5));
        model_promos.add(new Model_Promo("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg", "7%", "Pt. Ramus", "2018/10/2018", "250K", "Jakarta", 4));
        model_promos.add(new Model_Promo("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg", "10%", "Pt. Turu", "2018/10/2018", "230k", "Jakarta", 2));
        model_promos.add(new Model_Promo("https://apaperbedaan.com/wp-content/uploads/2016/08/HajiUmroh-730x350.jpg", "5%", "Pt. Solusi", "2018/10/2018", "100k", "Ciamis", 3));

    }

}
