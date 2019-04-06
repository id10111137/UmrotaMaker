package com.example.tatangit.umrota_maker.View.SignUp.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.Config.Interface.Umrota_Service;
import com.example.tatangit.umrota_maker.Hellper.Hellper_Umrota;
import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.MainActivity;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_User;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_UserItem;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.io.ByteArrayOutputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import mehdi.sakout.dynamicbox.DynamicBox;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class Fragment_MyProfil extends Fragment {

    Intent intent;
    Bitmap bitmap;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;

    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    View root;

    @BindView(R.id.id_myphoto)
    CircleImageView id_myphoto;

    Model_UserItem model_userItem;

    @BindView(R.id.id_nama)
    EditText id_nama;
    @BindView(R.id.id_alamat)
    EditText id_alamat;
    @BindView(R.id.id_notlp)
    EditText id_notlp;
    @BindView(R.id.id_nonpwp)
    EditText id_nonpwp;
    @BindView(R.id.id_nopassport)
    EditText id_nopassport;
    @BindView(R.id.id_nomor_ktp)
    EditText id_nomor_ktp;
    @BindView(R.id.id_email)
    EditText id_email;
    @BindView(R.id.id_usia)
    EditText id_usia;
    @BindView(R.id.id_jk)
    EditText id_jk;
    @BindView(R.id.id_nokartukesehatan)
    EditText id_nokartukesehatan;
    @BindView(R.id.id_username)
    EditText id_username;
    @BindView(R.id.id_password)
    EditText id_password;

    Umrota_Service mUmrotaService;

    public Fragment_MyProfil() {
    }

    KProgressHUD hud;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_myprofil, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);
        model_userItem = UserModelManager.getInstance(getContext()).getUser();
        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);
        mUmrotaService = Api_Utils.getSOService();
        setProfil();

        hud = KProgressHUD.create(getContext())
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setDetailsLabel("Downloading data")
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);

        return root;
    }


    @OnClick(R.id.id_myphoto)
    public void ChangePhoto() {
        selectImage();
    }


    private void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Library", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Add Photo!");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                } else if (items[item].equals("Choose from Library")) {
                    intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
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
            String selectedFilePath = getPathImage(bitmap);
            id_myphoto.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    private void onCaptureImageResult(Intent data) {

        Uri filePath = data.getData();

        try {
            bitmap = (Bitmap) data.getExtras().get("data");
            String selectedFilePath = getPathImage(bitmap);
            id_myphoto.setImageBitmap(bitmap);
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


    private void setProfil() {
        id_nama.setText(model_userItem.getNamaCostumer());
        id_alamat.setText(model_userItem.getAlamatCostumer());
        id_notlp.setText(model_userItem.getNomorTlp());
        id_nonpwp.setText(model_userItem.getNomorNpwp());
        id_nopassport.setText(model_userItem.getNomorPassport());
        id_nomor_ktp.setText(model_userItem.getNomorKtp());
        id_email.setText(model_userItem.getEmail());
        id_usia.setText(model_userItem.getUsia());
        id_jk.setText(model_userItem.getJenisKelamin());
        id_nokartukesehatan.setText(model_userItem.getNomorKartuKesehatan());
        id_username.setText(model_userItem.getUsername());
        id_password.setText(model_userItem.getPassword());
    }

    @OnClick(R.id.id_goSimpan)
    public void goSimpan() {
        hud.show();
        mUmrotaService.cProfil(model_userItem.getNomorCostumer(), id_nama.getText().toString(), id_alamat.getText().toString(),
                id_notlp.getText().toString(), id_alamat.getText().toString(), id_nopassport.getText().toString(), id_nomor_ktp.getText().toString(),
                id_email.getText().toString(), id_usia.getText().toString(), id_jk.getText().toString(), "", id_nokartukesehatan.getText().toString()
                , id_username.getText().toString(), id_password.getText().toString()).enqueue(new Callback<Model_User>() {
            @Override
            public void onResponse(Call<Model_User> call, Response<Model_User> response) {
                if (response.isSuccessful()) {
                    final List<Model_UserItem> lLogin = response.body().getMessage();
                    for (int i = 0; i < lLogin.size(); i++) {
                        model_userItem = new Model_UserItem(
                                lLogin.get(i).getUsia(), lLogin.get(i).getNomorCostumer(),
                                lLogin.get(i).getNomorTlp(), lLogin.get(i).getUrlPhoto(),
                                lLogin.get(i).getNomorPassport(), lLogin.get(i).getNomorNpwp(),
                                lLogin.get(i).getPassword(), lLogin.get(i).getAlamatCostumer(), lLogin.get(i).getNomorKtp(),
                                lLogin.get(i).getCreateDate(), lLogin.get(i).getJenisKelamin(), lLogin.get(i).getNamaCostumer(),
                                lLogin.get(i).getEmail(), lLogin.get(i).getNomorKartuKesehatan(), lLogin.get(i).getUsername(),
                                lLogin.get(i).getStatus());
                    }
                    UserModelManager.getInstance(getContext()).UserLogin(model_userItem);
                    setProfil();
                    hud.dismiss();

                } else {
                    Toast.makeText(getContext(), "Gagal Mengambil Data" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    hud.dismiss();
                }
            }

            @Override
            public void onFailure(Call<Model_User> call, Throwable t) {
                Log.d("Tampilkan", "" + call.toString());
                hud.dismiss();
            }
        });


    }

}
