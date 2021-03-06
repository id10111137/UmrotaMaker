package com.example.tatangit.umrota_maker.View.Home.Fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Config.Model.M_Promo;
import com.example.tatangit.umrota_maker.Config.Model.M_PromoItem;
import com.example.tatangit.umrota_maker.Hellper.Calendars;
import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.AddChart.Activity.Activity_Chart;
import com.example.tatangit.umrota_maker.View.CheckOut.Activity.Activity_Checkout;
import com.example.tatangit.umrota_maker.View.Home.Activity.Activity_Char;
import com.example.tatangit.umrota_maker.View.Home.Activity.Activity_DCompany;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Promo;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Promo;
import com.example.tatangit.umrota_maker.View.SignUp.Activity.Activity_Login;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import mehdi.sakout.dynamicbox.DynamicBox;
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


    @BindView(R.id.id_sv_promo)
    EditText id_sv_promo;

    Adapter_Promo adapter_promo;

    Calendars calendars;
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
        try {
            if (!UserModelManager.getInstance(getContext()).isLoggedIn()) {
                toolbar_iconView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ic_login));
                toolbar_iconView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent = new Intent(getContext(), Activity_Login.class);
                        startActivity(intent);
                    }
                });
            }else{
                toolbar_iconView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ic_shooping));
                toolbar_iconView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent = new Intent(getContext(), Activity_Char.class);
                        startActivity(intent);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        DynamicBox box = new DynamicBox(getContext(),id_lv_promo);
        box.showLoadingLayout();

        mUmrotaService.getAllUmrohCompany().enqueue(new Callback<M_Promo>() {
            @Override
            public void onResponse(Call<M_Promo> call, Response<M_Promo> response) {
                if (response.isSuccessful()){

                    final List<M_PromoItem> m_promoItems = response.body().getMessage();
                    adapter_promo = new Adapter_Promo(m_promoItems, getContext());
                    adapter_promo.notifyDataSetChanged();
                    id_lv_promo.setAdapter(adapter_promo);

                } else {
                    Toast.makeText(getContext(), "Gagal Mengambil Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<M_Promo> call, Throwable t) {
                Toast.makeText(getContext(), "Internet Anda Kurang Bagus", Toast.LENGTH_SHORT).show();
            }
        });

        id_lv_promo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {

                try {

                    if (!UserModelManager.getInstance(getContext()).isLoggedIn()) {
                        toolbar_iconView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.login));
                        intent = new Intent(getContext(), Activity_Login.class);
                        startActivity(intent);
                    }else{
                        intent = new Intent(getContext(), Activity_Checkout.class);
                        intent.putExtra("no_umroh", adapter_promo.getItem(position).getNomorUmroh());
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        id_sv_promo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter_promo.filter(charSequence.toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                adapter_promo.filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return root;
    }
}
