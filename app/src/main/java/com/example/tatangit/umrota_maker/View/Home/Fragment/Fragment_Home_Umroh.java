package com.example.tatangit.umrota_maker.View.Home.Fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Config.Model.M_Company;
import com.example.tatangit.umrota_maker.Config.Model.M_Company_Item;
import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Activity.Activity_DCompany;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Umroh;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Umroh;
import com.example.tatangit.umrota_maker.View.SignUp.Activity.Activity_Login;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import mehdi.sakout.dynamicbox.DynamicBox;
import retrofit2.Call;
import retrofit2.Callback;

public class Fragment_Home_Umroh extends Fragment {


    Intent intent;
    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    View root;

    @BindView(R.id.id_lv_umroh)
    ListView id_lv_umroh;

    @BindView(R.id.id_sv_umroh)
    SearchView id_sv_umroh;

    Adapter_Umroh adapter_umroh;
    ArrayList<Model_Umroh> model_umroh;
    Umrota_Service mUmrotaService;

    DynamicBox box;

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
        mUmrotaService = Api_Utils.getSOService();
        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);

        try {

            if (!UserModelManager.getInstance(getContext()).isLoggedIn()) {
                toolbar_iconView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.login));
                toolbar_iconView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent = new Intent(getContext(), Activity_Login.class);
                        startActivity(intent);
                    }
                });
            }else{
                toolbar_iconView.setImageDrawable(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        id_lv_umroh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {


                try {
                    if (!UserModelManager.getInstance(getContext()).isLoggedIn()) {
                        toolbar_iconView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.login));
                        intent = new Intent(getContext(), Activity_Login.class);
                        startActivity(intent);
                    }else{
                        intent = new Intent(getContext(), Activity_DCompany.class);
                        intent.putExtra("nomor_company", adapter_umroh.getItem(position).getNomorCompany());
                        intent.putExtra("nama_perusahaan", adapter_umroh.getItem(position).getNamaPerusahaan());
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });




        loadUmroh("", "");
        box = new DynamicBox(getContext(),id_lv_umroh);
        box.showLoadingLayout();

        id_sv_umroh.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                String text = s;
                adapter_umroh.filter(text);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                String text = s;
                adapter_umroh.filter(text);
                return false;
            }
        });


        return root;
    }




    private void loadUmroh(String Nama_Perusahaan, String Alamat_Perusahaan) {
        mUmrotaService.postAllCompany(Nama_Perusahaan, Alamat_Perusahaan).enqueue(new Callback<M_Company>() {
            @Override
            public void onResponse(Call<M_Company> call, retrofit2.Response<M_Company> response) {
                if (response.isSuccessful()) {

                    final List<M_Company_Item> MCompanyItemList = response.body().getMessage();
                    adapter_umroh = new Adapter_Umroh(MCompanyItemList, getContext());
                    adapter_umroh.notifyDataSetChanged();
                    id_lv_umroh.setAdapter(adapter_umroh);
                    id_lv_umroh.invalidate();

                } else {
                    Toast.makeText(getContext(), "Upps, Sepertinya Tidak Dapat Sinkronis Data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<M_Company> call, Throwable t) {
                Log.d("Tampilkan", t.toString());
            }
        });
    }


}