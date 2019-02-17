package com.example.tatangit.umrota_maker.Hellper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.tatangit.umrota_maker.Config.Api.GlobalVariable;
import com.example.tatangit.umrota_maker.View.SignUp.Model.M_Costumer;


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

    public void UserLogin(M_Costumer m_costumer) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(GlobalVariable.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(GlobalVariable.usia, m_costumer.getUsia());
        editor.putString(GlobalVariable.nomorCostumer, m_costumer.getNomorCostumer());
        editor.putString(GlobalVariable.nomorTlp, m_costumer.getNomorTlp());
        editor.putString(GlobalVariable.urlPhoto, m_costumer.getUrlPhoto());
        editor.putString(GlobalVariable.nomorPassport, m_costumer.getNomorPassport());
        editor.putString(GlobalVariable.nomorNpwp, m_costumer.getNomorNpwp());
        editor.putString(GlobalVariable.password, m_costumer.getPassword());
        editor.putString(GlobalVariable.alamatCostumer, m_costumer.getAlamatCostumer());
        editor.putString(GlobalVariable.nomorKtp, m_costumer.getNomorKtp());
        editor.putString(GlobalVariable.createDate, m_costumer.getCreateDate());
        editor.putString(GlobalVariable.jenisKelamin, m_costumer.getJenisKelamin());
        editor.putString(GlobalVariable.namaCostumer, m_costumer.getNamaCostumer());
        editor.putString(GlobalVariable.email, m_costumer.getEmail());
        editor.putString(GlobalVariable.nomorKartuKesehatan, m_costumer.getNomorKartuKesehatan());
        editor.putString(GlobalVariable.username, m_costumer.getUsername());
        editor.putString(GlobalVariable.status, m_costumer.getStatus());

        editor.apply();
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(GlobalVariable.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(GlobalVariable.nomorCostumer, null) != null;
    }

    public M_Costumer getUser() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(GlobalVariable.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new M_Costumer(
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

//    public void LogOut() {
//        SharedPreferences sharedPreferences = mContext.getSharedPreferences(DataCollection.SHARED_PREF_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.clear();
//        editor.apply();
//        editor.commit();
//        Intent intent = new Intent(mContext, Account_Login.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        mContext.startActivity(intent);
//    }

//    public void Refresh() {
//        mContext.startActivity(new Intent(mContext, MainActivity.class));
//        return;
//    }

}
