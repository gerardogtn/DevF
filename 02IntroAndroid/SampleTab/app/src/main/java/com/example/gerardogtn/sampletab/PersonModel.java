package com.example.gerardogtn.sampletab;

/**
 * Created by gerardogtn on 7/10/15.
 */
public class PersonModel {
    private String name;
    private boolean isSensei;
    private int imageId;


    public PersonModel(String name, int resource) {
        this(name, resource, false);
    }

    public PersonModel(String name, int resource, boolean isSensei) {
        this.name = name;
        this.isSensei = isSensei;
        this.imageId = resource;
    }

    public String getName() {
        return name;
    }

    public boolean isSensei() {
        return isSensei;
    }

    public int getImageId() {
        return imageId;
    }
}
