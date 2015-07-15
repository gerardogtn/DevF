package com.example.gerardogtn.musicclient.data.model;

import com.example.gerardogtn.musicclient.data.model.Track;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by gerardogtn on 7/14/15.
 */
public class TopTracksResponse {

    @SerializedName("tracks")
    TracksData tracksData;

    public TracksData getTracks() {
        return tracksData;
    }

    public class TracksData {

        @SerializedName("track")
        ArrayList<Track> tracks;

        public ArrayList<Track> getTracks() {
            return tracks;
        }

    }
}
