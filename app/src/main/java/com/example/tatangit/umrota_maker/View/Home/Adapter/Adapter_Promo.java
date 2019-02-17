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

import com.example.tatangit.umrota_maker.Config.Model.M_PromoItem;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Activity.Activity_DCompany;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Promo;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter_Promo extends ArrayAdapter<M_PromoItem> {

    private Context context;
    private List<M_PromoItem> dataSet = null;
    private ArrayList<M_PromoItem> originDataSet = null;
    LayoutInflater inflater;
//    ArrayList<String> modeArrays;

    public Adapter_Promo(List<M_PromoItem> data, Context context) {
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
    public M_PromoItem getItem(int position) {
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
        final M_PromoItem dataModel = getItem(position);
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
        Picasso.get().load(dataModel.getLogo()).placeholder(R.drawable.ic_noimage).fit().into(viewHolder.id_img_home, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });


        assert dataModel != null;
        viewHolder.id_nilai_discount.setText("Promo " + dataModel.getHargaUmroh());
        viewHolder.id_perusahaan.setText(dataModel.getNamaPerusahaan());
        viewHolder.id_keberangkatan.setText(dataModel.getKeberangkatan());
        viewHolder.id_harga.setText(dataModel.getDiscountPercent());
        ImageView image = null;
        for (int i = 1; i < 3; i++) {
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
            for (M_PromoItem wp : originDataSet) {
                if (wp.getNamaPerusahaan().toLowerCase(Locale.getDefault())
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
