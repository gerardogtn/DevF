package com.example.gerardogtn.musicclient.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerardogtn.musicclient.BuildConfig;
import com.example.gerardogtn.musicclient.R;
import com.example.gerardogtn.musicclient.data.model.Artist;
import com.example.gerardogtn.musicclient.ui.adapter.TopArtistAdapter;
import com.example.gerardogtn.musicclient.util.LastFmApiClient;
import com.example.gerardogtn.musicclient.util.model.TopArtistsResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * Created by gerardogtn on 7/14/15.
 */
public class TopArtistsFragment extends Fragment implements Callback<TopArtistsResponse> {

    public static final String LOG_TAG = TopArtistsFragment.class.getSimpleName();
    private static List<Artist> artists;

    @Bind(R.id.list_top_artists)
    RecyclerView recyclerView;

    public TopArtistsFragment(){
        artists = new ArrayList<>();
        LastFmApiClient.getInstance().getTopArtists(BuildConfig.LAST_FM_API_KEY, this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_top_artists, container, false);
        ButterKnife.bind(this, root);
        createRecycleView();
        return root;
    }

    private void createRecycleView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public static void setArtists(List<Artist> artists) {
        TopArtistsFragment.artists = artists;
    }

    public static TopArtistsFragment newInstance(){
        TopArtistsFragment output =  new TopArtistsFragment();
        return output;
    }

    @Override
    public void success(TopArtistsResponse topArtistsResponse, Response response) {
        artists = topArtistsResponse.getArtists();
        setUpRecycleView();
    }

    @Override
    public void failure(RetrofitError error) {
        Log.e(LOG_TAG, "Error on top artists");
        error.printStackTrace();
    }

    private void setUpRecycleView() {
        TopArtistAdapter topArtistAdapter = new TopArtistAdapter(getActivity(), artists);
        recyclerView.setAdapter(topArtistAdapter);

    }
}
