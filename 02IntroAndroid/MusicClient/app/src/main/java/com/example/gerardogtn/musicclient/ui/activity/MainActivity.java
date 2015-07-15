package com.example.gerardogtn.musicclient.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Pair;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.gerardogtn.musicclient.BuildConfig;
import com.example.gerardogtn.musicclient.R;
import com.example.gerardogtn.musicclient.data.model.Artist;
import com.example.gerardogtn.musicclient.data.model.Track;
import com.example.gerardogtn.musicclient.ui.fragment.TopArtistsFragment;
import com.example.gerardogtn.musicclient.ui.fragment.TopTracksFragment;
import com.example.gerardogtn.musicclient.util.LastFmApiClient;
import com.example.gerardogtn.musicclient.util.VolleySingleton;
import com.example.gerardogtn.musicclient.util.model.TopArtistsResponse;
import com.example.gerardogtn.musicclient.util.model.TopTracksResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;


public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.tab_layout)
    public TabLayout tabLayout;

    @Bind(R.id.pager)
    public ViewPager viewPager;

    @Bind(R.id.toolbar)
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        adapter.addFragment(TopArtistsFragment.newInstance(), "Top Artists");
        adapter.addFragment(TopTracksFragment.newInstance(), "Top Tracks");
        viewPager.setAdapter(adapter);

    }


    @Override
    protected void onResume() {
        super.onResume();
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
