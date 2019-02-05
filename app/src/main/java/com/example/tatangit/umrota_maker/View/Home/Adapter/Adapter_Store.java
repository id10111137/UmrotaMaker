package com.example.tatangit.umrota_maker.View.Home.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Store;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter_Store extends ArrayAdapter<Model_Store> {

    private Context context;
    private List<Model_Store> dataSet = null;
    private ArrayList<Model_Store> originDataSet = null;
    LayoutInflater inflater;

    public Adapter_Store(ArrayList<Model_Store> data, Context context) {
        super(context, R.layout.fragment_store_row, data);
        this.dataSet = data;
        this.context = context;
        inflater = LayoutInflater.from(getContext());
        this.originDataSet = new ArrayList<>();
        this.originDataSet.addAll(data);
    }

    private static class ViewHolder {

        ImageView id_image_store;
        TextView id_nama_toko;
        TextView id_store_alamat;
        TextView id_store_jam_oprasional;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Model_Store getItem(int position) {
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
        final Model_Store dataModel = getItem(position);
        final ViewHolder viewHolder;
        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fragment_store_row, parent, false);

            viewHolder.id_image_store = convertView.findViewById(R.id.id_image_store);
            viewHolder.id_nama_toko = convertView.findViewById(R.id.id_nama_toko);
            viewHolder.id_store_alamat = convertView.findViewById(R.id.id_store_alamat);
            viewHolder.id_store_jam_oprasional = convertView.findViewById(R.id.id_store_jam_oprasional);

            result = convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        assert dataModel != null;
        Picasso.get().load(dataModel.getUrl_ImageToko()).placeholder(R.drawable.ic_noimage).fit().into(viewHolder.id_image_store, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });

        viewHolder.id_nama_toko.setText(dataModel.getNama_store());
        viewHolder.id_store_alamat.setText("Alamat Kami, " + dataModel.getAlamat_store());
        viewHolder.id_store_jam_oprasional.setText("Jam Oprasional Mulai " + dataModel.getOpen_toko());

        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        dataSet.clear();
        if (charText.length() == 0) {
            dataSet.addAll(originDataSet);
        } else {
            for (Model_Store wp : originDataSet) {
                if (wp.getAlamat_store().toLowerCase(Locale.getDefault())
                        .contains(charText)) {
                    dataSet.add(wp);
                } else {

                    Log.d("Data :", "Data Tidak Ditemukan");
                }
            }
        }
        notifyDataSetChanged();
    }

}