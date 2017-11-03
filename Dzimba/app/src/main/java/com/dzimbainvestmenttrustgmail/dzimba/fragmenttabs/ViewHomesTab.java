package com.dzimbainvestmenttrustgmail.dzimba.fragmenttabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dzimbainvestmenttrustgmail.dzimba.paymentcode.BookingPayments;
import com.dzimbainvestmenttrustgmail.dzimba.R;

import java.util.ArrayList;
import java.util.List;


public class ViewHomesTab extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_homes_tab);

        mToolbar = (Toolbar) findViewById(R.id.tabToolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager) findViewById(R.id.houseViewPager);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) findViewById(R.id.houseTabs);
        mTabLayout.setupWithViewPager(mViewPager);

        //Initiate the flotting action button to open the BookingPayments page
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(getApplicationContext(), BookingPayments.class);
                startActivity(intent);
            }
        });
    }

    private void setupViewPager (ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new SengaFragment(), "SENGA");
        viewPagerAdapter.addFragment(new LangaraFragment(), "LANGARA");
        viewPagerAdapter.addFragment(new PatelHouseFragment(), "PATEL HOUSE");
        viewPagerAdapter.addFragment(new BeehiveFragment(), "BEEHIVE");
        viewPagerAdapter.addFragment(new PatelCottageFragment(), "PATEL COTTAGE");
        viewPager.setAdapter(viewPagerAdapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment>mFragmentList = new ArrayList<>();
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

        public void addFragment (Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }
}
