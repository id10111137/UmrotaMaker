package com.example.tatangit.umrota_maker.View.Home.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.tatangit.umrota_maker.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment_Home extends Fragment {


    @BindView(R.id.btn_navigation_mInfo)
        BottomNavigationView bottomNavigationView;

    View root;
    Fragment fragment;
    FragmentManager fragmentManager;


    public Fragment_Home() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, root);
        setupNavigationView();
        return root;
    }


    private void setupNavigationView() {

        if (bottomNavigationView != null) {

            // Select first menu item by default and show Fragment accordingly.
            Menu menu = bottomNavigationView.getMenu();
            selectmInfo(menu.getItem(0));

            // Set action to perform when any menu-item is selected.
            bottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            selectmInfo(item);
                            return false;
                        }
                    });
        }
    }


    protected void selectmInfo(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.mUmrohHome:
                pushFragment(new Fragment_Home_Index());
                break;
            case R.id.mUmroh:
                pushFragment(new Fragment_Home_Umroh());
                break;
            case R.id.mUmrohPromo:
                pushFragment(new Fragment_Home_Promo());
                break;
        }
    }


    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;

         fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.frame_homes, fragment);
                ft.commit();
            }
        }
    }


}
