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

import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Model.MessageItemCompanyInfo;
import com.example.tatangit.umrota_maker.View.Home.Model.MessageItemGalleryCompany;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter_Gallery extends ArrayAdapter<MessageItemGalleryCompany>{

    private Context context;
    private List<MessageItemGalleryCompany> dataSet;
    private ArrayList<MessageItemGalleryCompany> originDataSet;
    private LayoutInflater inflater;

    public Adapter_Gallery(List<MessageItemGalleryCompany> data, Context mContext) {
        super(mContext, R.layout.fragment_gallery_photo_row, data);
        this.dataSet = data;
        inflater = LayoutInflater.from(mContext);
        this.originDataSet = new ArrayList<>();
        this.originDataSet.addAll(data);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private static class ViewHolder {
        ImageView id_image_gallery;
        TextView id_txt_image_gallery;
    }


    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public MessageItemGalleryCompany getItem(int position) {
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
        final MessageItemGalleryCompany dataModel = getItem(position);
        final ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fragment_gallery_photo_row, parent, false);

            viewHolder.id_image_gallery = convertView.findViewById(R.id.id_image_gallery);
            viewHolder.id_txt_image_gallery = convertView.findViewById(R.id.id_txt_image_gallery);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        assert dataModel != null;
        Picasso.get().load(dataModel.getUrl()).placeholder(R.drawable.ic_noimage).fit().into(viewHolder.id_image_gallery, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {

            }
        });

        viewHolder.id_txt_image_gallery.setText(dataModel.getNomorCompany());

        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        dataSet.clear();
        if (charText.length() == 0) {
            dataSet.addAll(originDataSet);
        } else {
            for (MessageItemGalleryCompany wp : originDataSet) {
                if (wp.getNomorCompanyGallery().toLowerCase(Locale.getDefault())
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