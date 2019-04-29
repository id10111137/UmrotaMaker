package com.example.tatangit.umrota_maker.View.SignUp.Fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Config.Model.M_PromoItem;
import com.example.tatangit.umrota_maker.Hellper.Calendars;
import com.example.tatangit.umrota_maker.Hellper.Hellper_Umrota;
import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.Home.Adapter.Adapter_Promo;
import com.example.tatangit.umrota_maker.View.SignUp.Adapter.Adapter_MyDoc;
import com.example.tatangit.umrota_maker.View.SignUp.Model.MessageItem;
import com.example.tatangit.umrota_maker.View.SignUp.Model.ModelUploadDoc;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_MyDoc;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_UserItem;
import com.example.tatangit.umrota_maker.View.SignUp.Model.RUploadImage;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mehdi.sakout.dynamicbox.DynamicBox;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_MyDoc extends Fragment {


    Intent intent;
    Bitmap bitmap;
    String ImageName;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    View root;
    private static final int PERMISSION_STORAGE = 2;

    @BindView(R.id.id_gd_doc)
    GridView id_gd_doc;

    AlertDialog alertDialog = null;
    View dialogView;
    DynamicBox box;

    Umrota_Service mUmrotaService;
    Calendars calendars;

    Model_UserItem model_userItem;
    Adapter_MyDoc adapter_myDoc;

    public Fragment_MyDoc() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_mydoc, container, false);
        ButterKnife.bind(this, root);

        model_userItem = UserModelManager.getInstance(getContext()).getUser();
        mUmrotaService = Api_Utils.getSOService();
        box = new DynamicBox(getContext(), id_gd_doc);
        box.showLoadingLayout();
        calendars = new Calendars();
        DummyData();

        return root;
    }


    @OnClick({R.id.id_ktp})
    public void goUploadKtp() {
        selectImage("Upload KTP");
    }

    @OnClick({R.id.id_kk})
    public void goUploadKK() {
        selectImage("Upload Kartu Keluarga");
    }

    @OnClick({R.id.id_suratnikah})
    public void goUploadSuratNikah() {
        selectImage("Upload Surat Nikah");
    }

    @OnClick({R.id.id_kKesehatan})
    public void goUploadSKesehatan() {
        selectImage("Upload Kartu Sehat");
    }

    private void selectImage(String NameActivity) {


        dialogView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_mydoc_upload, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.create().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        builder.setCancelable(false);
        builder.setView(dialogView);

        alertDialog = builder.create();
        alertDialog.show();

        TextView id_tv_header = dialogView.findViewById(R.id.id_tv_header);
        id_tv_header.setText(NameActivity);


        LinearLayout id_goSimpan = dialogView.findViewById(R.id.id_goSimpan);
        id_goSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uImage();
                alertDialog.dismiss();
            }
        });

        ImageView id_img_close = dialogView.findViewById(R.id.id_img_close);
        id_img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        CardView id_kamera = dialogView.findViewById(R.id.id_kamera);
        id_kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CAMERA);
            }
        });

        CardView id_gallery = dialogView.findViewById(R.id.id_gallery);
        id_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("onActivityResult", "requestCode " + requestCode + ", resultCode " + resultCode);

        if (resultCode == getActivity().RESULT_OK) {
            if (requestCode == SELECT_FILE) {
                onSelectFromGalleryResult(data);
            } else if (requestCode == REQUEST_CAMERA) {
                onCaptureImageResult(data);
            }
        }
    }


    private void onSelectFromGalleryResult(Intent data) {

        try {
            if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED
                    && ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSION_STORAGE);
            } else {
                Uri filePath = data.getData();
                Log.d("Tampilkan",""+getPath(filePath));
                Log.d("Tampilkan",""+filePath);
                ImageName = getFileName(filePath);
                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), filePath);
                ImageView id_priview = dialogView.findViewById(R.id.id_priview);
//                Uri tempUri = getImageUri(getContext(), bitmap);
//                UploadImage(getRealPathFromURI(tempUri));

                id_priview.setVisibility(View.VISIBLE);
                id_priview.setImageBitmap(bitmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    private void onCaptureImageResult(Intent data) {

        try {
            if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED
                    && ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSION_STORAGE);
            } else {
                Uri filePath = data.getData();
                Log.d("Tampilkan",""+getPath(filePath));
                ImageName = getFileName(filePath);
                bitmap = (Bitmap) data.getExtras().get("data");
                ImageView id_priview = dialogView.findViewById(R.id.id_priview);

                id_priview.setVisibility(View.VISIBLE);
                id_priview.setImageBitmap(bitmap);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getPath(Uri uri)
    {
        String result = null;

        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContext().getContentResolver().query(uri, projection, null, null, null);
        int col = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
        if (col >= 0 && cursor.moveToFirst())
            result = cursor.getString(col);
        cursor.close();

        return result;


    }

    private void uImage() {


        mUmrotaService.uImage(imgToString(bitmap), ImageName, calendars.getYearh() + "-" + calendars.getMonth() + "-" + calendars.getDay(), model_userItem.getNomorCostumer()).enqueue(new Callback<RUploadImage>() {
            @Override
            public void onResponse(Call<RUploadImage> call, Response<RUploadImage> response) {

                if (response.isSuccessful()) {
                    Log.d("Tampilkan",""+response.message());
                    DummyData();
                } else {
                    Log.d("Tampilkan",""+response.message());
                    Toast.makeText(getContext(), "Respons Jelek", Toast.LENGTH_SHORT).show();
                    DummyData();
                }
                
            }

            @Override
            public void onFailure(Call<RUploadImage> call, Throwable t) {
                Toast.makeText(getContext(), "Koneksi Data Kurang Bagus", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

    private String imgToString(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imgbytes = byteArrayOutputStream.toByteArray();
        String encodeimg = Base64.encodeToString(imgbytes, Base64.DEFAULT);
        return encodeimg;
    }

    private void DummyData() {

        mUmrotaService.gGambar(model_userItem.getNomorCostumer()).enqueue(new Callback<ModelUploadDoc>() {
            @Override
            public void onResponse(Call<ModelUploadDoc> call, Response<ModelUploadDoc> response) {
                if (response.isSuccessful()){

                    final List<MessageItem> messageItems = response.body().getMessage();
                    adapter_myDoc = new Adapter_MyDoc(messageItems, getContext());
                    adapter_myDoc.notifyDataSetChanged();
                    id_gd_doc.setAdapter(adapter_myDoc);



                } else {
                    Toast.makeText(getContext(), "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelUploadDoc> call, Throwable t) {
                Toast.makeText(getContext(), "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
