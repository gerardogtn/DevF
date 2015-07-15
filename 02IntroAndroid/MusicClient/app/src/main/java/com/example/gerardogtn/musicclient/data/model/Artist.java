package com.example.gerardogtn.musicclient.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gerardogtn on 7/14/15.
 */
public class Artist {

    @SerializedName("name")
    private String name;

    @SerializedName("mbid")
    private String mbid;

    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", mbid='" + mbid + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
