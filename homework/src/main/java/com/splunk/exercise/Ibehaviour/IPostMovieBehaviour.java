package com.splunk.exercise.Ibehaviour;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.splunk.exercise.exceptions.BaseException;
import com.splunk.exercise.model.ResponseUtil;

public interface IPostMovieBehaviour {
    ResponseUtil postRequiredFieldsEmpty() throws JsonProcessingException, BaseException;

    ResponseUtil postDescFieldEmpty() throws JsonProcessingException, BaseException;

    ResponseUtil postNameFieldEmpty() throws JsonProcessingException, BaseException;

    ResponseUtil postMalformedJson() throws JsonProcessingException, BaseException;

    ResponseUtil inCorrectHeader() throws JsonProcessingException, BaseException;

    ResponseUtil checkForXSS() throws JsonProcessingException, BaseException;

    ResponseUtil addMovie() throws JsonProcessingException, BaseException;

    ResponseUtil addSameMovieAgain() throws JsonProcessingException, BaseException;
}
