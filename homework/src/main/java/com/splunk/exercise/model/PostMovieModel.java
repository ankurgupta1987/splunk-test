package com.splunk.exercise.model;

/**
 * Class used as a model for posting the movies to the rest API
 */
public class PostMovieModel {

    public PostMovieModel(){}

    private String name;

    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
