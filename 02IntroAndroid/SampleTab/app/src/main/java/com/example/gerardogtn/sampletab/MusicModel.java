package com.example.gerardogtn.sampletab;

/**
 * Created by gerardogtn on 7/10/15.
 */
public class MusicModel {
    private int imageId;
    private String artist;
    private String sampleSong;

    public MusicModel(int imageId, String artist, String sampleSong) {
        this.imageId = imageId;
        this.artist = artist;
        this.sampleSong = sampleSong;
    }

    public int getImageId() {
        return imageId;
    }

    public String getArtist() {
        return artist;
    }

    public String getSampleSong() {
        return sampleSong;
    }
}
