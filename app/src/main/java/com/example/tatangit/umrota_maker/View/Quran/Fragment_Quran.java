package com.example.tatangit.umrota_maker.View.Quran;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.Hellper.HellperQuran;
import com.example.tatangit.umrota_maker.Hellper.Quran_Dao;
import com.example.tatangit.umrota_maker.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Quran extends Fragment {

    Intent intent;
    Toolbar toolbar;
    TextView mTitle;
    View root;
    CircleImageView toolbar_iconView;


    @BindView(R.id.listview)
    ListView listView;

    @BindView(R.id.autocomplete)
    AutoCompleteTextView autoCompleteTextView;
    SQLiteDatabase db;

    private String[] surahName = {"Al-Fatihah", "Al-Baqarah", "AliImran", "An-Nisaa", "Al-Maidah", "Al-An'am", "Al-A'raf", "Al-Anfaal", "At-Taubah", "Yunus", "Huud", "Yusuf", "Ar-Ra'd", "Ibrahim", "Al-Hijr", "An-Nahl", "Al-Israa'", "Al-Kahfi", "Maryam", "Thaahaa", "Al-Anbiyaa", "Al-Hajj", "Al-Mu'minuun", "An-Nuur", "Al-Furqaan", "Asy-Syu'araa", "An-Naml", "Al-Qashash", "Al-'Ankabuut", "Ar-Ruum", "Luqman", "As-Sajdah", "Al-Ahzab", "Saba'", "Faathir", "YaaSiin", "Ash-Shaaffat", "Shaad", "Az-Zumar", "Al-Mu'min", "Fushshilat", "Asy-Syuura", "Az-Zukhruf", "Ad-Dukhaan", "Al-Jaatsiyah", "Al-Ahqaaf", "Muhammad", "Al-Fat-h", "Al-Hujuraat", "Qaaf", "Adz-Dzaariyat", "Ath-Thuur", "An-Najm", "Al-Qamar", "Ar-Rahmaan", "Al-Waaqi'ah", "Al-Hadiid", "Al-Mujaadilah", "Al-Hasyr", "Al-Mumtahanah", "Ash-Shaff", "Al-Jumuah", "Al-Munaafiqun", "At-Taghaabun", "Ath-Thalaaq", "At-Tahriim", "Al-Mulk", "Al-Qalam", "Al-Haaqqah", "Al-Ma'aarij", "Nuh", "Al-Jin", "Al-Muzzammil", "Al-Muddatstsir", "Al-Qiyaamah", "Al-Insaan", "Al-Mursalaat", "An-Naba'", "An-Naazi'aat", "'Abasa,42", "At-Takwiir", "Al-Infithaar", "Al-Muthaffif", "Al-Insyiqaaq", "Al-Buruuj", "Ath-Thaariq", "Al-A'laa", "Al-Ghaasyiyah", "Al-Fajr", "Al-Balad", "Asy-Syams", "Al-Lail", "Adh-Dhuhaa", "Al-Insyirah", "At-Tiin", "Al-'Alaq", "Al-Qadr", "Al-Bayyinah", "Az-Zalzalah", "Al-'Aadiyaat", "1Al-Qaari'ah", "At-Takaatsur", "Al-'Ashr", "Al-Humazah", "Al-Fiil", "Quraisy", "Al-Maa'uun", "Al-Kautsar", "Al-Kaafiruun", "An-Nashr", "Al-Lahab", "Al-Ikhlash", "Al-Falaq", "An-Naas"};


    public Fragment_Quran() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_quran, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Quran");

        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(null);


        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = (String) adapterView.getItemAtPosition(i);
                int pos = -1;

                for (int j = 0; j < surahName.length; j++) {
                    if (surahName[j].equals(selection)) {
                        pos = j;
                        break;
                    }
                }

                List<Model_Quran> listData = new Quran_Dao(getContext()).getListDataWhereCriteria("SuratID", pos + 1);
                String[] ayat = new String[listData.size()];
                for (int j = 0; j < listData.size(); j++) {
                    ayat[j] = listData.get(j).getAyatText();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                        android.R.layout.simple_list_item_1, android.R.id.text1, ayat);
                listView.setAdapter(adapter);
            }
        });

//        insertFromFile(getContext(), R.raw.quran, db);
//        setToListView();

        return root;
    }


    public void insertFromFile(Context context, int resourceId, SQLiteDatabase db) {

        try {
            InputStream insertsStream = context.getResources().openRawResource(resourceId);
            BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertsStream));

            db.beginTransaction();

            while (insertReader.ready()) {
                String insertStmt = insertReader.readLine();
                db.execSQL(insertStmt);
            }

            db.setTransactionSuccessful();
            db.endTransaction();

            insertReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setToListView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_dropdown_item_1line, surahName);
        autoCompleteTextView.setAdapter(adapter);
    }


}
