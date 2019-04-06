package com.example.tatangit.umrota_maker.Hellper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tatangit.umrota_maker.View.Quran.Model_Quran;

import java.util.ArrayList;
import java.util.List;

public class Quran_Dao extends HellperQuran {

    private Context ctx;

    public Quran_Dao(Context context) {
        super(context);
        ctx = context;
    }

    public List<Model_Quran> getListDataWhereCriteria(String table, Integer value) {
        List<Model_Quran> recordsList = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME + " where " + table + " = '" + value + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                Integer suratId = cursor.getInt(cursor.getColumnIndex("SuratID"));
                Integer verseId = cursor.getInt(cursor.getColumnIndex("VerseID"));
                String ayatText = cursor.getString(cursor.getColumnIndex("AyatText"));

                Model_Quran dataObj = new Model_Quran();
                dataObj.setSuratId(suratId);
                dataObj.setVerseId(verseId);
                dataObj.setAyatText(ayatText);
                recordsList.add(dataObj);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return recordsList;
    }

}
