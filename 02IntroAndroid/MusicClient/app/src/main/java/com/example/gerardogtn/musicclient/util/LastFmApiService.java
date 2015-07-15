package com.example.gerardogtn.musicclient.util;

import com.example.gerardogtn.musicclient.util.model.TopArtistsResponse;
import com.example.gerardogtn.musicclient.util.model.TopTracksResponse;


import java.util.concurrent.Callable;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by gerardogtn on 7/13/15.
 */
public interface LastFmApiService {

    @GET(ApiConstants.URL_TOP_TRACKS)
    void getTopTracks(@Query(ApiConstants.PARAM_KEY) String apiKey,
                      Callback<TopTracksResponse> callback);


    @GET(ApiConstants.URL_TOP_ARTISTS)
    void getTopArtists(@Query(ApiConstants.PARAM_KEY) String apiKey,
                       Callback<TopArtistsResponse> callback);


}
