package com.example.tatangit.umrota_maker.Config.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tatangit.umrota_maker.Config.Api.GlobalVariable;
import com.example.tatangit.umrota_maker.View.Home.Model.Model_Promo;

import java.util.ArrayList;
import java.util.List;

public class Db_SqlLite extends SQLiteOpenHelper {


    SQLiteDatabase db;
    ContentValues values;
    Cursor cursor;


    private final String CREATE_PROMO_TABLE =
            "CREATE TABLE " + GlobalVariable.TABLE_PROMO + "(" +
            GlobalVariable.NomorPromo + " TEXT PRIMARY KEY, "
                    + GlobalVariable.Promo + " TEXT, "
                    + GlobalVariable.Nama_Perusahaan + " TEXT, "
                    + GlobalVariable.TanggalPromo + " TEXT, "
                    + GlobalVariable.HargaPromo + " TEXT, "
                    + GlobalVariable.AlamatPerusahaan + " TEXT, "
                    + GlobalVariable.UrlImage + " TEXT, "
                    + GlobalVariable.JmlBintang + " INTEGER " + ")";

    public Db_SqlLite(Context context) {
        super(context, GlobalVariable.DATABASE_NAME, null,GlobalVariable.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_PROMO_TABLE);
//        sqLiteDatabase.execSQL(CREATE_COMPANY_TABLE);
//        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GlobalVariable.TABLE_PROMO);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPANY);
        onCreate(sqLiteDatabase);
    }




    /**
     * Method ini digunakan untuk melakukan insert data profile ke database sqlite
     * @param model_promo
     */
    public void addPromo(Model_Promo model_promo){
        db = this.getWritableDatabase();
        values = new ContentValues();

        values.put(GlobalVariable.NomorPromo, model_promo.getNomorPromo());
        values.put(GlobalVariable.Promo, model_promo.getPromo());
        values.put(GlobalVariable.Nama_Perusahaan, model_promo.getNama_Perusahaan());
        values.put(GlobalVariable.TanggalPromo, model_promo.getTanggalPromo());
        values.put(GlobalVariable.HargaPromo, model_promo.getHargaPromo());
        values.put(GlobalVariable.AlamatPerusahaan, model_promo.getAlamatPerusahaan());
        values.put(GlobalVariable.JmlBintang, model_promo.getJmlBintang());

        db.insert(GlobalVariable.TABLE_PROMO, null, values);
        db.close();
    }


    /**
     * Method ini digunakan untuk menampilkan semua data yang ada di database sqlite ke listview
     * @return
     */
    public List<Model_Promo> getAllDataProfile(){
        List<Model_Promo> modelPromos  = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + GlobalVariable.TABLE_PROMO;

         db = this.getWritableDatabase();
         cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do {
                Model_Promo model_promo = new Model_Promo();

                model_promo.setNomorPromo(cursor.getString(0));
                model_promo.setPromo(cursor.getString(1));
                model_promo.setNama_Perusahaan(cursor.getString(2));
                model_promo.setTanggalPromo(cursor.getString(3));
                model_promo.setHargaPromo(cursor.getString(4));
                model_promo.setAlamatPerusahaan(cursor.getString(5));
                model_promo.setJmlBintang(Integer.parseInt(cursor.getString(6)));

                modelPromos.add(model_promo);
            }while (cursor.moveToNext());
        }
        return modelPromos;
    }


    /**
     * method ini digunakan untuk menghapus data di database berdasarkan ID
     * @param value
     */
    public void deleteRow(String value) {
        db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + GlobalVariable.TABLE_PROMO + " WHERE "+ GlobalVariable.NomorPromo +"='"+value+"'");
        db.close();
    }




    public void updatedetails(String NomorPromo, String UrlImage, String promo, String nama_Perusahaan, String tanggalPromo, String hargaPromo, String alamatPerusahaan, int JmlBintang) {
         db = this.getWritableDatabase();
         values = new ContentValues();

        values.put(GlobalVariable.NomorPromo, NomorPromo);
        values.put(GlobalVariable.Promo, promo);
        values.put(GlobalVariable.Nama_Perusahaan, nama_Perusahaan);
        values.put(GlobalVariable.TanggalPromo, tanggalPromo);
        values.put(GlobalVariable.HargaPromo, hargaPromo);
        values.put(GlobalVariable.AlamatPerusahaan, alamatPerusahaan);
        values.put(GlobalVariable.JmlBintang, JmlBintang);

        db.update(GlobalVariable.TABLE_PROMO, values, GlobalVariable.NomorPromo + "=" + NomorPromo, null);
        db.close();
    }





}
