package com.example.tatangit.umrota_maker.View.SignUp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tatangit.umrota_maker.Config.Api.Api_Utils;
import com.example.tatangit.umrota_maker.R;
import com.example.tatangit.umrota_maker.View.AddChart.Activity.Activity_Chart;
import com.example.tatangit.umrota_maker.View.SignUp.Activity.Activity_AMyProfil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_MyProfil extends Fragment {

    Toolbar toolbar;
    TextView mTitle;
    Intent intent;
    CircleImageView toolbar_iconView;

    View root;
    Fragment fragment;
    FragmentManager fragmentManager;

    @BindView(R.id.vp_info_member_booking)
    ViewPager vp_info_member_booking;

    @BindView(R.id.id_tb_member_booking)
    TabLayout id_tb_member_booking;

    public Fragment_MyProfil() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.activity_profil_info, container, false);
        ButterKnife.bind(this, root);
        toolbar = getActivity().findViewById(R.id.toolbar);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        mTitle.setText("My Profil");

        toolbar_iconView = getActivity().findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.ic_shoping));
        toolbar_iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), Activity_Chart.class);
                startActivity(intent);
            }
        });

        createViewPager(vp_info_member_booking);
        id_tb_member_booking.setupWithViewPager(vp_info_member_booking);
        createTabIcons();
        return root;
    }


    private void createTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.tab_costume, null);
        tabOne.setText("My Info");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_agent, 0, 0);
        id_tb_member_booking.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.tab_costume, null);
        tabTwo.setText("Document Info");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_agent, 0, 0);
        id_tb_member_booking.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.tab_costume, null);
        tabThree.setText("Healty Info");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_agent, 0, 0);
        id_tb_member_booking.getTabAt(2).setCustomView(tabThree);
    }


    private void createViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
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

}
