package com.example.gerardogtn.musicclient.data.model;

import com.example.gerardogtn.musicclient.data.model.Artist;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by gerardogtn on 7/14/15.
 */
public class TopArtistsResponse {

    @SerializedName("artists")
    ArtistsData artistsData;

    public ArrayList<Artist> getArtists(){
        return artistsData.artists;
    }

    private class ArtistsData {

        @SerializedName("artist")
        ArrayList<Artist> artists;

    }
}
