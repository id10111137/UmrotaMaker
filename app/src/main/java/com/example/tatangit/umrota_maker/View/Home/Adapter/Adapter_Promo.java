package com.example.tatangit.umrota_maker.View.Home.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Activity.Activity_DCompany;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Promo;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter_Promo extends ArrayAdapter<Model_Promo> {

    private Context context;
    private List<Model_Promo> dataSet = null;
    private ArrayList<Model_Promo> originDataSet = null;
    LayoutInflater inflater;
//    ArrayList<String> modeArrays;

    public Adapter_Promo(ArrayList<Model_Promo> data, Context context) {
        super(context, R.layout.fragment_home_promo_row, data);
        this.dataSet = data;
        this.context = context;
        inflater = LayoutInflater.from(getContext());
        this.originDataSet = new ArrayList<>();
        this.originDataSet.addAll(data);
    }

    private static class ViewHolder {
        LinearLayout lyStar;
        ImageView id_img_home;
        TextView id_nilai_discount;
        TextView id_perusahaan;
        TextView id_keberangkatan;
        TextView id_harga;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Model_Promo getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final Model_Promo dataModel = getItem(position);
//        modeArrays = new ArrayList<>();
        final ViewHolder viewHolder;
        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fragment_home_promo_row, parent, false);

            viewHolder.id_img_home = convertView.findViewById(R.id.id_img_home);
            viewHolder.id_nilai_discount = convertView.findViewById(R.id.id_nilai_discount);
            viewHolder.id_perusahaan = convertView.findViewById(R.id.id_perusahaan);
            viewHolder.id_keberangkatan = convertView.findViewById(R.id.id_keberangkatan);
            viewHolder.id_harga = convertView.findViewById(R.id.id_harga);

            viewHolder.lyStar = convertView.findViewById(R.id.id_ly_star);


            result = convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        assert dataModel != null;
        Picasso.get().load(dataModel.getUrlPromo()).placeholder(R.drawable.ic_noimage).fit().into(viewHolder.id_img_home, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });


        assert dataModel != null;
        viewHolder.id_nilai_discount.setText("Promo " + dataModel.getHargaPromo());
        viewHolder.id_perusahaan.setText(dataModel.getNama_Perusahaan());
        viewHolder.id_keberangkatan.setText(dataModel.getTanggalPromo());
        viewHolder.id_harga.setText(dataModel.getHargaPromo());
        ImageView image = null;
        for (int i = 1; i < dataModel.getJmlBintang(); i++) {
             image = new ImageView(getContext());
            image.setImageResource(R.drawable.ic_star);
            image.setLayoutParams(new android.view.ViewGroup.LayoutParams(30, 30));
            image.setMaxHeight(20);
            image.setMaxWidth(20);
        }
        viewHolder.lyStar.addView(image);

        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        dataSet.clear();
        if (charText.length() == 0) {
            dataSet.addAll(originDataSet);
        } else {
            for (Model_Promo wp : originDataSet) {
                if (wp.getNama_Perusahaan().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    dataSet.add(wp);
                } else {

                    Toast.makeText(context, "Data Tidak Ada", Toast.LENGTH_SHORT).show();
                }
            }
        }
        notifyDataSetChanged();
    }
}
