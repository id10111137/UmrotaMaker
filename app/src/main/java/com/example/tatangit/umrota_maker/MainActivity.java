package com.example.tatangit.umrota_maker;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Hellper.Hellper_Umrota;
import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.View.Home.Fragment.Fragment_Home;
import com.example.tatangit.umrota_maker.View.Information.Fragment.Fragment_Dokumentasi;
import com.example.tatangit.umrota_maker.View.Information.Fragment.Fragment_Fasilitas;
import com.example.tatangit.umrota_maker.View.Information.Fragment.Fragment_Information;
import com.example.tatangit.umrota_maker.View.Information.Fragment.Fragment_Perusahaan;
import com.example.tatangit.umrota_maker.View.Information.Fragment.Fragment_Promo;
import com.example.tatangit.umrota_maker.View.SignUp.Fragment.Fragment_Profil;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_UserItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Fragment fragment;

    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    FragmentManager fragmentManager;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    FragmentTransaction fragmentTransaction;
    Model_UserItem model_userItem;

    TextView txt_namesheader;
    ImageView imgProfile;

    Hellper_Umrota hellper_umrota;
    Intent mIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        model_userItem = UserModelManager.getInstance(MainActivity.this).getUser();
        hellper_umrota = new Hellper_Umrota();


        if (!hellper_umrota.checkConnection(getApplicationContext())) {
            Toast.makeText(this, "Upps,Sepertinya Jaringan Internet anda bermasalah", Toast.LENGTH_SHORT).show();
        } else if (!hellper_umrota.isLocationEnabled(getApplicationContext())) {
            Toast.makeText(this, "Mohon Maaf Lokasi Belum Terjangkau", Toast.LENGTH_SHORT).show();
            mIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(mIntent);
        }

        try {
            if (savedInstanceState == null) {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.container, new Fragment_Home());
                fragmentTransaction.commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        View navHeader = navigationView.getHeaderView(0);
        txt_namesheader = (TextView) navHeader.findViewById(R.id.id_nameheader);
        txt_namesheader.setText(model_userItem.getNamaCostumer());
        imgProfile = (ImageView) navHeader.findViewById(R.id.imageView);


        Menu menuNav = navigationView.getMenu();



        try {

            if (!UserModelManager.getInstance(getApplicationContext()).isLoggedIn()) {
                MenuItem mProfil = menuNav.findItem(R.id.mProfil);
                mProfil.setVisible(false);
                MenuItem mLogout = menuNav.findItem(R.id.mLogout);
                mLogout.setVisible(false);
                txt_namesheader.setText(null);
                imgProfile.setVisibility(View.GONE);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        fragment = null;

        if (id == R.id.mUmrotaHome) {
            fragment = new Fragment_Home();
        }  else if (id == R.id.mProfil) {
            fragment = new Fragment_Profil();
        } else if (id == R.id.mPromo) {
            fragment = new Fragment_Promo();
        }else if (id == R.id.mFasilitas) {
            fragment = new Fragment_Fasilitas();
        } else if (id == R.id.mPerusahaan) {
            fragment = new Fragment_Perusahaan();
        } else if (id == R.id.mDokument) {
            fragment = new Fragment_Dokumentasi();
        } else if (id == R.id.mLogout) {
            UserModelManager.getInstance(getApplicationContext()).LogOut();
        }

        goDestination(fragment);
        drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void goDestination(Fragment fragment) {
        if (fragment != null) {
            fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
    }
}
