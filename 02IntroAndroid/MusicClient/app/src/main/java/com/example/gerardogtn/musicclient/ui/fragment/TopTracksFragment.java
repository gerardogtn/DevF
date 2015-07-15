package com.example.gerardogtn.musicclient.ui.fragment;

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
import com.example.gerardogtn.musicclient.data.model.Track;
import com.example.gerardogtn.musicclient.ui.adapter.TopTrackAdapter;
import com.example.gerardogtn.musicclient.data.LastFmApiClient;
import com.example.gerardogtn.musicclient.data.model.TopTracksResponse;

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
public class TopTracksFragment extends Fragment implements Callback<TopTracksResponse> {

    public static final String LOG_TAG = TopTracksFragment.class.getSimpleName();
    private static List<Track> tracks;

    public static void setTracks(List<Track> tracks) {
        TopTracksFragment.tracks = tracks;
    }

    @Bind(R.id.list_top_tracks)
    RecyclerView recyclerView;

    public TopTracksFragment() {
        tracks = new ArrayList<>();
        LastFmApiClient.getInstance().getTopTracks(BuildConfig.LAST_FM_API_KEY, this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_top_tracks, container, false);
        ButterKnife.bind(this, root);
        createRecycleView();
        return root;
    }

    private void createRecycleView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public static TopTracksFragment newInstance(){
        TopTracksFragment output =  new TopTracksFragment();
        return output;
    }

    @Override
    public void success(TopTracksResponse topTracksResponse, Response response) {
        setTracks(topTracksResponse.getTracks().getTracks());
        setUpRecycleView();
    }

    @Override
    public void failure(RetrofitError error) {
        Log.e(LOG_TAG, "Retrofit failure");
        error.printStackTrace();
    }

    private void setUpRecycleView() {
        TopTrackAdapter topTrackAdapter = new TopTrackAdapter(getActivity(), tracks);
        recyclerView.setAdapter(topTrackAdapter);

    }
}
