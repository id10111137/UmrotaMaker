package com.example.tatangit.umrota_maker.View.Home.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Model.M_Company_Umroh_Item;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_DCompany;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Umroh;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter_DCompany extends ArrayAdapter<M_Company_Umroh_Item> {

    private Context context;
    private List<M_Company_Umroh_Item> dataSet = null;
    private ArrayList<M_Company_Umroh_Item> originDataSet = null;
    LayoutInflater inflater;

    public Adapter_DCompany(List<M_Company_Umroh_Item> data, Context context) {
        super(context, R.layout.activity_dcompany_row, data);
        this.dataSet = data;
        this.context = context;
        inflater = LayoutInflater.from(getContext());
        this.originDataSet = new ArrayList<>();
        this.originDataSet.addAll(data);
    }

    private static class ViewHolder {

        ImageView id_img_dcompany;
        TextView id_subject_company;
        TextView id_name_company;
        TextView id_Ddepart;
        TextView id_Darrival;
        TextView id_qty;
        TextView id_booking;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public M_Company_Umroh_Item getItem(int position) {
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
        final M_Company_Umroh_Item dataModel = getItem(position);
        final ViewHolder viewHolder;
        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_dcompany_row, parent, false);

            viewHolder.id_img_dcompany = convertView.findViewById(R.id.id_img_dcompany);
            viewHolder.id_subject_company = convertView.findViewById(R.id.id_subject_company);
            viewHolder.id_name_company = convertView.findViewById(R.id.id_name_company);
            viewHolder.id_Ddepart = convertView.findViewById(R.id.id_Ddepart);
            viewHolder.id_Darrival = convertView.findViewById(R.id.id_Darrival);
            viewHolder.id_qty = convertView.findViewById(R.id.id_qty);
            viewHolder.id_booking = convertView.findViewById(R.id.id_booking);


            result = convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        assert dataModel != null;
        Picasso.get().load(dataModel.getLogo()).placeholder(R.drawable.ic_noimage).fit().into(viewHolder.id_img_dcompany, new Callback() {

            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });

        viewHolder.id_subject_company.setText(dataModel.getJudulUmroh());
        viewHolder.id_name_company.setText(dataModel.getNamaPerusahaan());
        viewHolder.id_Ddepart.setText("Keberangkatan : " + dataModel.getKeberangkatan());
        viewHolder.id_Darrival.setText("Kedatangan: " + dataModel.getKepulangan());
        viewHolder.id_qty.setText("Jumlah Kursi : " + dataModel.getMaxOrangUmroh());
        viewHolder.id_booking.setText("Sisa Booking: " + ((Integer.parseInt(dataModel.getMaxOrangUmroh()) - Integer.parseInt(dataModel.getMinOrangUmroh()))));


        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        dataSet.clear();
        if (charText.length() == 0) {
            dataSet.addAll(originDataSet);
        } else {
            for (M_Company_Umroh_Item wp : originDataSet) {
                if (wp.getNamaPerusahaan().toLowerCase(Locale.getDefault()).contains(charText)
                        ||
                        wp.getKeberangkatan().toLowerCase(Locale.getDefault()).contains(charText)
                        ||
                        wp.getKepulangan().toLowerCase(Locale.getDefault()).contains(charText)) {
                    dataSet.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
