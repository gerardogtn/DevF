package com.example.gerardogtn.sampletab;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HomeActivity extends AppCompatActivity {

    @Bind(R.id.tab_layout)
    public TabLayout tabLayout;

    @Bind(R.id.pager)
    public ViewPager viewPager;

    @Bind(R.id.toolbar)
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    // REQUIRES: None.
    // MODIFIES: this.
    // EFFECTS: Adds the tabs to the viewPager.
    private void setUpViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(PeopleFragment.newInstance(), "Personas" );
        adapter.addFragment(ProjectFragment.newInstance(), "Proyectos" );
        adapter.addFragment(MusicFragment.newInstance(), "Musica" );
        viewPager.setAdapter(adapter);

    }


    public class SectionPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragments;
        private List<String> mFragmentNames;

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
            mFragments = new ArrayList<>();
            mFragmentNames = new ArrayList<>();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentNames.get(position);
        }

        // REQUIRES: None.
        // MODIFIES: this.
        // EFFECTS: Adds a fragment and its respective name to mFragments and mFragmentNames.
        public void addFragment(Fragment fragment, String name){
            mFragments.add(fragment);
            mFragmentNames.add(name.toUpperCase());
        }
    }
}
