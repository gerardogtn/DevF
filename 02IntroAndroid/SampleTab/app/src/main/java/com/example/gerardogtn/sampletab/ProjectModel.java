package com.example.gerardogtn.sampletab;

/**
 * Created by gerardogtn on 7/10/15.
 */
public class ProjectModel {
    private String title;
    private String description;

    public ProjectModel(String title) {
        this(title, "Sin descripcion");
    }

    public ProjectModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
