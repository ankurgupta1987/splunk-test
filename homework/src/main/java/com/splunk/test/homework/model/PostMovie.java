package com.splunk.test.homework.model;

/**
 * @author Ankur
 * Class used as a model for posting the movies to the rest API
 */
public class PostMovie {
    public PostMovie(){}

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
