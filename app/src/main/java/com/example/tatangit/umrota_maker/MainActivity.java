package com.example.tatangit.umrota_maker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tatangit.umrota_maker.Hellper.Config;
import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.View.Home.Fragment.Fragment_Home;
import com.example.tatangit.umrota_maker.View.Information.Fragment.Fragment_Information;
import com.example.tatangit.umrota_maker.View.Intro.DefaultIntro;
import com.example.tatangit.umrota_maker.View.Lisence.Fragment_Lisence;
import com.example.tatangit.umrota_maker.View.SignUp.Activity.Activity_Login;
import com.example.tatangit.umrota_maker.View.SignUp.Fragment.Fragment_MyProfil;
import com.example.tatangit.umrota_maker.View.SignUp.Fragment.Fragment_SignUp;
import com.example.tatangit.umrota_maker.View.SignUp.Model.M_Costumer;

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
    M_Costumer m_costumer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        m_costumer = UserModelManager.getInstance(getApplicationContext()).getUser();


        /*
            Start Slider Into
         */

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(Config.FLAG, Context.MODE_PRIVATE);
                if (sharedPreferences.getBoolean(Config.FLAG, true)) {
                    startActivity(new Intent(MainActivity.this, DefaultIntro.class));
                    SharedPreferences.Editor e = sharedPreferences.edit();
                    e.putBoolean(Config.FLAG, false);
                    e.apply();
                }
            }
        });
        t.start();

         /*
          End Start Slider Into
         */

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
        try {

            if (!UserModelManager.getInstance(getApplicationContext()).isLoggedIn()) {
                Item(false);
            }else{
                Item(true);
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
        } else if (id == R.id.mRegister) {
            fragment = new Fragment_SignUp();
        } else if (id == R.id.mInfo) {
            fragment = new Fragment_Information();
        }else if (id == R.id.mProfil) {
            fragment = new Fragment_MyProfil();
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

    private void Item(Boolean HideOrNo) {
        Menu nav_Menu = navigationView.getMenu();
        if(HideOrNo){
            nav_Menu.findItem(R.id.mRegister).setVisible(false);
            nav_Menu.findItem(R.id.mProfil).setVisible(true);
        }else{
            nav_Menu.findItem(R.id.mRegister).setVisible(true);
            nav_Menu.findItem(R.id.mProfil).setVisible(false);
        }
    }
}
