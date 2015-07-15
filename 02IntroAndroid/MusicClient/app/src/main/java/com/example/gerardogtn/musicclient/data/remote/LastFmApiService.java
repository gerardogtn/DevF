package com.example.gerardogtn.musicclient.data.remote;

import com.example.gerardogtn.musicclient.util.ApiConstants;
import com.example.gerardogtn.musicclient.data.model.TopArtistsResponse;
import com.example.gerardogtn.musicclient.data.model.TopTracksResponse;


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
