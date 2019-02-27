package com.example.tatangit.umrota_maker.Hellper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.tatangit.umrota_maker.Config.Api.GlobalVariable;
import com.example.tatangit.umrota_maker.View.SignUp.Activity.Activity_Login;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_UserItem;


/**
 * Created by tatang.it on 11/24/2017.
 */

public class UserModelManager {

    @SuppressLint("StaticFieldLeak")
    private static UserModelManager mInstance;
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    private UserModelManager(Context context) {
        mContext = context;
    }

    public static synchronized UserModelManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new UserModelManager(context);
        }
        return mInstance;
    }

    public void UserLogin(Model_UserItem modelUserItem) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(GlobalVariable.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(GlobalVariable.usia, modelUserItem.getUsia());
        editor.putString(GlobalVariable.nomorCostumer, modelUserItem.getNomorCostumer());
        editor.putString(GlobalVariable.nomorTlp, modelUserItem.getNomorTlp());
        editor.putString(GlobalVariable.urlPhoto, modelUserItem.getUrlPhoto());
        editor.putString(GlobalVariable.nomorPassport, modelUserItem.getNomorPassport());
        editor.putString(GlobalVariable.nomorNpwp, modelUserItem.getNomorNpwp());
        editor.putString(GlobalVariable.password, modelUserItem.getPassword());
        editor.putString(GlobalVariable.alamatCostumer, modelUserItem.getAlamatCostumer());
        editor.putString(GlobalVariable.nomorKtp, modelUserItem.getNomorKtp());
        editor.putString(GlobalVariable.createDate, modelUserItem.getCreateDate());
        editor.putString(GlobalVariable.jenisKelamin, modelUserItem.getJenisKelamin());
        editor.putString(GlobalVariable.namaCostumer, modelUserItem.getNamaCostumer());
        editor.putString(GlobalVariable.email, modelUserItem.getEmail());
        editor.putString(GlobalVariable.nomorKartuKesehatan, modelUserItem.getNomorKartuKesehatan());
        editor.putString(GlobalVariable.username, modelUserItem.getUsername());
        editor.putString(GlobalVariable.status, modelUserItem.getStatus());

        editor.apply();
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(GlobalVariable.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(GlobalVariable.nomorCostumer, null) != null;
    }

    public Model_UserItem getUser() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(GlobalVariable.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Model_UserItem(
                sharedPreferences.getString(GlobalVariable.usia, null),
                sharedPreferences.getString(GlobalVariable.nomorCostumer, null),
                sharedPreferences.getString(GlobalVariable.nomorTlp, null),
                sharedPreferences.getString(GlobalVariable.urlPhoto, null),
                sharedPreferences.getString(GlobalVariable.nomorPassport, null),
                sharedPreferences.getString(GlobalVariable.nomorNpwp, null),
                sharedPreferences.getString(GlobalVariable.password, null),
                sharedPreferences.getString(GlobalVariable.alamatCostumer, null),
                sharedPreferences.getString(GlobalVariable.nomorKtp, null),
                sharedPreferences.getString(GlobalVariable.createDate, null),
                sharedPreferences.getString(GlobalVariable.jenisKelamin, null),
                sharedPreferences.getString(GlobalVariable.namaCostumer, null),
                sharedPreferences.getString(GlobalVariable.email, null),
                sharedPreferences.getString(GlobalVariable.nomorKartuKesehatan, null),
                sharedPreferences.getString(GlobalVariable.username, null),
                sharedPreferences.getString(GlobalVariable.status, null));
    }

    public void LogOut() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(GlobalVariable.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        editor.commit();
        Intent intent = new Intent(mContext, Activity_Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }


}
