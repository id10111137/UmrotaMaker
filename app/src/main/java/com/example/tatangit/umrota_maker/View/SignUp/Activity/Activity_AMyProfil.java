package com.example.tatangit.umrota_maker.View.SignUp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.AddChart.Activity.Activity_Chart;
import com.example.tatangit.umrota_maker.View.SignUp.Fragment.Fragment_DocInfo;
import com.example.tatangit.umrota_maker.View.SignUp.Fragment.Fragment_Healty;
import com.example.tatangit.umrota_maker.View.SignUp.Fragment.Fragment_MyInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Activity_AMyProfil extends AppCompatActivity {

    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView;
    Intent intent;

    @BindView(R.id.vp_info_member_booking)
    ViewPager vp_info_member_booking;

    @BindView(R.id.id_tb_member_booking)
    TabLayout id_tb_member_booking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_info);
        ButterKnife.bind(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("Personal Information");
        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(getApplication().getResources().getDrawable(R.drawable.ic_info));

        toolbar_iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                intent = new Intent(getApplicationContext(), Activity_Chart.class);
//                startActivity(intent);
            }
        });

//        try {
//
//            if (!ModelManager.getInstance(getApplicationContext()).isLoggedIn()) {
//                startActivity(new Intent(this, Activity_Login.class));
//                finish();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        createViewPager(vp_info_member_booking);
        id_tb_member_booking.setupWithViewPager(vp_info_member_booking);

        createTabIcons();
    }


    private void createTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.tab_costume, null);
        tabOne.setText("My Info");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_agent, 0, 0);
        id_tb_member_booking.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.tab_costume, null);
        tabTwo.setText("Document Info");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_agent, 0, 0);
        id_tb_member_booking.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.tab_costume, null);
        tabThree.setText("Healty Info");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_agent, 0, 0);
        id_tb_member_booking.getTabAt(2).setCustomView(tabThree);
    }


    private void createViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Fragment_MyInfo(), "My Info");
        adapter.addFrag(new Fragment_DocInfo(), "Document Info");
        adapter.addFrag(new Fragment_Healty(), "Healty Info");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}
