package com.example.gerardogtn.musicclient.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by gerardogtn on 7/13/15.
 */
public class Track {

    @SerializedName("name")
    private String name;

    @SerializedName("duration")
    private String duration;

    @SerializedName("artist")
    private Artist artist;

    @SerializedName("playcount")
    private int playCount;

    @SerializedName("listeners")
    private int listeners;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        String output;
        if (duration.isEmpty() || duration == null){
            output =  "No duration available";
        } else{
            int duration = Integer.parseInt(this.duration);
            int minutes = duration / 60;
            int seconds = duration % 60;

            if (seconds < 10){
                output = minutes + ":0" + seconds;
            } else {
                output = minutes + ":" + seconds;
            }
        }
        return output;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getListeners() {
        return listeners;
    }

    public void setListeners(int listeners) {
        this.listeners = listeners;
    }

    public String getArtistName(){
        return artist.getName();
    }


    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", artist=" + artist.toString() +
                ", playCount=" + playCount +
                ", listeners=" + listeners +
                '}';
    }
}
