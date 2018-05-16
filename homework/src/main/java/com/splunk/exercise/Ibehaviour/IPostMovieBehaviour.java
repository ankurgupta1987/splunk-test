package com.splunk.exercise.Ibehaviour;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IPostMovieBehaviour {
    void postRequiredFieldsEmpty() throws JsonProcessingException;

    void postDescFieldEmpty() throws JsonProcessingException;

    void postNameFieldEmpty() throws JsonProcessingException;

    void postMalformedJson() throws JsonProcessingException;

    void inCorrectHeader() throws JsonProcessingException;

    void checkForXSS() throws JsonProcessingException;

    void addMovie() throws JsonProcessingException;

    //Post request should create one more record
    //else change it to put (idempotent)
    void addSameMovieAgain() throws JsonProcessingException;
}
