package com.example.tatangit.umrota_maker;

import android.content.Intent;
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
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.Hellper.UserModelManager;
import com.example.tatangit.umrota_maker.View.Home.Fragment.Fragment_Home;
import com.example.tatangit.umrota_maker.View.Information.Fragment.Fragment_Information;
import com.example.tatangit.umrota_maker.View.SignUp.Activity.Activity_Login;
import com.example.tatangit.umrota_maker.View.SignUp.Fragment.Fragment_MyProfil;
import com.example.tatangit.umrota_maker.View.SignUp.Fragment.Fragment_Profil;
import com.example.tatangit.umrota_maker.View.SignUp.Model.Model_UserItem;
import com.squareup.picasso.Picasso;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        model_userItem = UserModelManager.getInstance(MainActivity.this).getUser();


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

        if (model_userItem.getUrlPhoto() != null) {
            Picasso.get().load(model_userItem.getUrlPhoto()).centerCrop().fit().into(imgProfile);
        }

        try {

            if (!UserModelManager.getInstance(getApplicationContext()).isLoggedIn()) {
                startActivity(new Intent(this, Activity_Login.class));
                finish();
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
        } else if (id == R.id.mInfo) {
            fragment = new Fragment_Information();
        }else if (id == R.id.mProfil) {
            fragment = new Fragment_Profil();
        }else if (id == R.id.mLogout) {
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
