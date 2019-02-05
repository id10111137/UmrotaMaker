package com.example.tatangit.umrota_maker.Hellper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.tatangit.umrota_maker.MainActivity;

public class ModelManager {

    @SuppressLint("StaticFieldLeak")
    private static ModelManager mInstance;
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    private ModelManager(Context context) {
        mContext = context;
    }

    public static synchronized ModelManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ModelManager(context);
        }
        return mInstance;
    }


    public void UserLogin(ModelUsers modelUsers) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Config.nomor_users, modelUsers.getNomor_users());
        editor.putString(Config.nama_users, modelUsers.getNama_users());
        editor.putString(Config.email_users, modelUsers.getEmail_users());
        editor.putString(Config.username, modelUsers.getUsername());
        editor.putString(Config.password, modelUsers.getPassword());
        editor.putString(Config.status_active, modelUsers.getStatus_active());
        editor.putString(Config.alamat_users, modelUsers.getAlamat_users());
        editor.putString(Config.photo_users, modelUsers.getPhoto_users());
        editor.putString(Config.nomor_ktp, modelUsers.getNomor_ktp());
        editor.putString(Config.nomor_passport, modelUsers.getNomor_passport());
        editor.putString(Config.jenis_kelamin, modelUsers.getJenis_kelamin());
        editor.putString(Config.nomor_kk, modelUsers.getNomor_kk());
        editor.apply();
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(Config.nomor_users, null) != null;
    }

    public ModelUsers getUser() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new ModelUsers(
                sharedPreferences.getString(Config.nomor_users, null),
                sharedPreferences.getString(Config.nama_users, null),
                sharedPreferences.getString(Config.email_users, null),
                sharedPreferences.getString(Config.username, null),
                sharedPreferences.getString(Config.password, null),
                sharedPreferences.getString(Config.status_active, null),
                sharedPreferences.getString(Config.alamat_users, null),
                sharedPreferences.getString(Config.photo_users, null),
                sharedPreferences.getString(Config.nomor_ktp, null),
                sharedPreferences.getString(Config.nomor_passport, null),
                sharedPreferences.getString(Config.jenis_kelamin, null),
                sharedPreferences.getString(Config.nomor_kk, null));
    }

    public void LogOut() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        editor.commit();
        Intent intent = new Intent(mContext, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }

}
