package com.example.tatangit.umrota_maker.View.Home.Fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Config.Model.M_Company_Item;
import com.example.tatangit.umrota_maker.Config.Model.M_Promo;
import com.example.tatangit.umrota_maker.Config.Model.M_PromoItem;
import com.example.tatangit.umrota_maker.Hellper.Calendars;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.AddChart.Activity.Activity_Chart;
import com.example.tatangit.umrota_maker.View.Booking.Activity.Activity_PreBoking;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Promo;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Umroh;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Promo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Home_Promo extends Fragment {

    Intent intent;
    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    View root;

    @BindView(R.id.id_lv_promo)
    ListView id_lv_promo;
    @BindView(R.id.id_keberangkatan_dates)
            TextView id_keberangkatan_dates;

    @BindView(R.id.id_kedatangan_dates)
    TextView id_kedatangan_dates;

    Adapter_Promo adapter_promo;
    ArrayList<Model_Promo> model_promos;

    Calendars calendars;
    DatePickerDialog datePickerDialog;
    Umrota_Service mUmrotaService;




    public Fragment_Home_Promo() {
        this.calendars = new Calendars();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home_promo, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);

        mUmrotaService = Api_Utils.getSOService();

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


        mUmrotaService.getAllUmrohCompany().enqueue(new Callback<M_Promo>() {
            @Override
            public void onResponse(Call<M_Promo> call, Response<M_Promo> response) {
                if (response.isSuccessful()){

                    final List<M_PromoItem> m_promoItems = response.body().getMessage();
                    adapter_promo = new Adapter_Promo(m_promoItems, getContext());
                    adapter_promo.notifyDataSetChanged();
                    id_lv_promo.setAdapter(adapter_promo);

                } else {
                    Toast.makeText(getContext(), "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<M_Promo> call, Throwable t) {
                Toast.makeText(getContext(), "Koneksi Tidak Bagus", Toast.LENGTH_SHORT).show();
            }
        });

        id_lv_promo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                intent = new Intent(getContext(), Activity_PreBoking.class);
                intent.putExtra("nomor_umroh", adapter_promo.getItem(position).getNomorUmroh());
                startActivity(intent);
            }
        });
        return root;
    }


    @OnClick(R.id.ln_kedatangan)
    public void lnKedatangan(){

        datePickerDialog = new DatePickerDialog(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        id_kedatangan_dates.setText(calendars.getDateMonthYearh(year,monthOfYear,dayOfMonth));

                    }
                }, calendars.getYearh(), calendars.getMonth(), calendars.getDay());

        datePickerDialog.show();
    }

    @OnClick(R.id.ln_keberangkatan)
    public void ln_keberangkatan(){
        datePickerDialog = new DatePickerDialog(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        id_keberangkatan_dates.setText(calendars.getDateMonthYearh(year,monthOfYear,dayOfMonth));
                    }
                }, calendars.getYearh(), calendars.getMonth(), calendars.getDay());

        datePickerDialog.show();
    }


}
