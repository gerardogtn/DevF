package com.example.gerardogtn.musicclient.data;

import com.example.gerardogtn.musicclient.data.remote.LastFmApiService;
import com.example.gerardogtn.musicclient.util.ApiConstants;

import retrofit.RestAdapter;

/**
 * Created by gerardogtn on 7/14/15.
 */
public class LastFmApiClient {

    private static LastFmApiService apiService;

    public static LastFmApiService getInstance(){
        if (apiService == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstants.URL_BASE)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();

            apiService = adapter.create(LastFmApiService.class);
        }

        return apiService;
    }
}
