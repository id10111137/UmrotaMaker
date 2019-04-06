package com.example.tatangit.umrota_maker.View.SignUp.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Hellper.Hellper_Umrota;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.SignUp.Adapter.Adapter_MyDoc;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_MyDoc;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_UserItem;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Response;

import net.steamcrafted.materialiconlib.MaterialIconView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mehdi.sakout.dynamicbox.DynamicBox;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Call;
import retrofit2.Callback;

public class Fragment_MyDoc extends Fragment {


    Intent intent;
    Bitmap bitmap;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    View root;
    private static final int PERMISSION_STORAGE = 2;
    ArrayList<Model_MyDoc> model_myDocs;

    @BindView(R.id.id_gd_doc)
    GridView id_gd_doc;

    AlertDialog alertDialog = null;
    View dialogView;
    Hellper_Umrota hellper_umrota;
    DynamicBox box;

    Umrota_Service mUmrotaService;

    public Fragment_MyDoc() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_mydoc, container, false);
        ButterKnife.bind(this, root);
        DummyData();
        id_gd_doc.setAdapter(new Adapter_MyDoc(model_myDocs, getContext()));
        mUmrotaService = Api_Utils.getSOService();
        box = new DynamicBox(getContext(), id_gd_doc);
        box.showLoadingLayout();

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

        //before inflating the custom alert dialog layout, we will get the current activity viewgroup

        dialogView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_mydoc_upload, null);

        //Now we need an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.create().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        //setting the view of the builder to our custom view that we already inflated

        builder.setCancelable(false);
        builder.setView(dialogView);

        //finally creating the alert dialog and displaying it
        alertDialog = builder.create();
        alertDialog.show();

        TextView id_tv_header = dialogView.findViewById(R.id.id_tv_header);
        id_tv_header.setText(NameActivity);


        LinearLayout id_goSimpan = dialogView.findViewById(R.id.id_goSimpan);
        id_goSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        Uri filePath = data.getData();
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), filePath);
            ImageView id_priview = dialogView.findViewById(R.id.id_priview);


            if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED
                    && ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSION_STORAGE);

            }else {
                Uri tempUri = getImageUri(getContext(), bitmap);

                UploadImage(getRealPathFromURI(tempUri));
            }


            id_priview.setVisibility(View.VISIBLE);
            id_priview.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    private void onCaptureImageResult(Intent data) {

        try {
            bitmap = (Bitmap) data.getExtras().get("data");
            ImageView id_priview = dialogView.findViewById(R.id.id_priview);

            if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED
                    && ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISSION_STORAGE);

            }else {
                Uri tempUri = getImageUri(getContext(), bitmap);

                UploadImage(getRealPathFromURI(tempUri));
            }



            id_priview.setVisibility(View.VISIBLE);
            id_priview.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getPathImage(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, baos);
        byte[] imageBytes = baos.toByteArray();
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    public Uri getImageUri(Context mContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(mContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContext().getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }



    private void UploadImage(String files) {
        Log.d("Tampil",""+files);

//        File file = new File(selectImagePath);
//        RequestBody reqFile = RequestBody.create(MediaType.parse("image"), file);
//        MultipartBody.Part imageBody = MultipartBody.Part.createFormData("image", file.getName(), reqFile);
//        RequestBody ImageName = RequestBody.create(MediaType.parse("text/plain"), file.getName());


        File file = new File(files);
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("image"), file);

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("image", file.getName(), requestFile);

        RequestBody fullName =
                RequestBody.create(MediaType.parse("text/plain"), file.getName());

     mUmrotaService.uDocument(body,fullName).enqueue(new Callback<Response>() {
         @Override
         public void onResponse(retrofit2.Call<Response> call, retrofit2.Response<Response> response) {
             if (response.isSuccessful()) {
                 Log.d("Tampilkan",""+response.body().getMessage());

             }else{
                 Toast.makeText(getContext(), "Gagal Mengambil Data" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
             }
         }

         @Override
         public void onFailure(retrofit2.Call<Response> call, Throwable t) {
             Log.d("Tampilkan", "" + call.toString());
         }
     });
    }


    private void DummyData() {
        model_myDocs = new ArrayList<>();
        model_myDocs.add(new Model_MyDoc("Photo KTP", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_myDocs.add(new Model_MyDoc("Photo Passport", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_myDocs.add(new Model_MyDoc("Photo Surat Nikah", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_myDocs.add(new Model_MyDoc("Photo Kartu Keluarga", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_myDocs.add(new Model_MyDoc("Photo Akta Lahir", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_myDocs.add(new Model_MyDoc("Photo Domisli", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));
        model_myDocs.add(new Model_MyDoc("Photo Kartu Sehat", "http://images2.fanpop.com/images/photos/7200000/Beatiful-Foxes-foxes-7244944-1600-1200.jpg", "Foxes", "987654321"));

    }






}
