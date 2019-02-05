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
import android.widget.Toast;

import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Home;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Umroh;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter_Umroh extends ArrayAdapter<Model_Umroh> {

    private Context context;
    private List<Model_Umroh> dataSet = null;
    private ArrayList<Model_Umroh> originDataSet = null;
    LayoutInflater inflater;

    public Adapter_Umroh(ArrayList<Model_Umroh> data, Context context) {
        super(context, R.layout.fragment_home_umroh_row, data);
        this.dataSet = data;
        this.context = context;
        inflater = LayoutInflater.from(getContext());
        this.originDataSet = new ArrayList<>();
        this.originDataSet.addAll(data);
    }

    private static class ViewHolder {
        ImageView id_img_umroh;
        TextView id_nama_perusahaan;
        TextView id_alamat;
        TextView id_layanan;
        TextView id_penerbangan;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Model_Umroh getItem(int position) {
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
        final Model_Umroh dataModel = getItem(position);
        final ViewHolder viewHolder;
        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fragment_home_umroh_row, parent, false);

            viewHolder.id_img_umroh = convertView.findViewById(R.id.id_img_umroh);
            viewHolder.id_nama_perusahaan = convertView.findViewById(R.id.id_nama_perusahaan);
            viewHolder.id_alamat = convertView.findViewById(R.id.id_alamat);
            viewHolder.id_layanan = convertView.findViewById(R.id.id_layanan);
            viewHolder.id_penerbangan = convertView.findViewById(R.id.id_penerbangan);


            result = convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        assert dataModel != null;
        Picasso.get().load(dataModel.getUrl_Image()).placeholder(R.drawable.ic_noimage).fit().into(viewHolder.id_img_umroh, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });

        viewHolder.id_nama_perusahaan.setText("Wellcome To "+dataModel.getNama_Perusahaan());
        viewHolder.id_alamat.setText(dataModel.getAlamat());
        viewHolder.id_layanan.setText(dataModel.getLayanan());
        viewHolder.id_penerbangan.setText(dataModel.getTotalPenerbangan());


        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        dataSet.clear();
        if (charText.length() == 0) {
            dataSet.addAll(originDataSet);
        } else {
            for (Model_Umroh wp : originDataSet) {
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
