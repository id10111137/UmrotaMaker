package com.example.tatangit.umrota_maker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tatangit.umrota_maker.Hellper.Config;
import com.example.tatangit.umrota_maker.View.Home.Fragment.Fragment_Home;
import com.example.tatangit.umrota_maker.View.Information.Fragment.Fragment_Information;
import com.example.tatangit.umrota_maker.View.Intro.DefaultIntro;
import com.example.tatangit.umrota_maker.View.SignUp.Fragment_SignUp;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Fragment fragment;
    NavigationView navigationView;
    DrawerLayout drawer;
    FragmentManager fragmentManager;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        /*
            Start Slider Into
         */

        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(Config.FLAG, Context.MODE_PRIVATE);
                if(sharedPreferences.getBoolean(Config.FLAG,true)){
                    startActivity(new Intent(MainActivity.this,DefaultIntro.class));
                    SharedPreferences.Editor e=sharedPreferences.edit();
                    e.putBoolean(Config.FLAG,false);
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

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        fragment = null;

        if (id == R.id.mUmrotaHome) {
            fragment = new Fragment_Home();
        } else if (id == R.id.mRegister) {
            fragment = new Fragment_SignUp();
        } else if (id == R.id.mInfo) {
            fragment = new Fragment_Information();
        }

        goDestination(fragment);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
