package com.splunk.exercise.behaviour;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.splunk.exercise.Ibehaviour.IPostMovieBehaviour;
import com.splunk.exercise.exceptions.BaseException;
import com.splunk.exercise.model.ResponseUtil;
import com.splunk.exercise.util.Utility;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static com.splunk.exercise.util.Constants.EMPTY_STRING;
import static com.splunk.exercise.util.Constants.MOVIE_DESC;
import static com.splunk.exercise.util.Constants.MOVIE_NAME;
import static com.splunk.exercise.util.Constants.TEST_STRING;
import static com.splunk.exercise.util.Constants.TEST_JAVASCRIPT_STRING;

public class PostMovieBehaviour implements IPostMovieBehaviour {

    private HttpHeaders httpHeaders;
    private Utility utility;
    private ResponseEntity<String> response;
    private ResponseUtil responseUtil;

    public PostMovieBehaviour(Utility utility){
        this.utility = utility;
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
    }

    @Override
    public ResponseUtil postRequiredFieldsEmpty() throws BaseException {
        String json = utility.convertMovieObjectToJSONString(EMPTY_STRING, EMPTY_STRING);
        response = utility.postMovie(json, httpHeaders);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        responseUtil = new ResponseUtil(responseCode, responseBody);
        return responseUtil;
    }


    @Override
    public ResponseUtil postDescFieldEmpty() throws BaseException {
        String json = utility.convertMovieObjectToJSONString(MOVIE_NAME, EMPTY_STRING);
        response = utility.postMovie(json, httpHeaders);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        responseUtil = new ResponseUtil(responseCode, responseBody);
        return responseUtil;
    }


    @Override
    public ResponseUtil postNameFieldEmpty() throws BaseException {
        String json = utility.convertMovieObjectToJSONString(EMPTY_STRING, MOVIE_DESC);
        response = utility.postMovie(json, httpHeaders);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        responseUtil = new ResponseUtil(responseCode, responseBody);
        return responseUtil;
    }


    @Override
    public ResponseUtil postMalformedJson() throws BaseException {
        String json = utility.convertMovieObjectToJSONString(EMPTY_STRING, EMPTY_STRING);
        json += TEST_STRING ;
        response = utility.postMovie(json, httpHeaders);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        responseUtil = new ResponseUtil(responseCode, responseBody);
        return responseUtil;
    }


    @Override
    public ResponseUtil inCorrectHeader() throws  BaseException {
        String json = utility.convertMovieObjectToJSONString(EMPTY_STRING, EMPTY_STRING);
        httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_ATOM_XML);
        response = utility.postMovie(json, httpHeaders);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        responseUtil = new ResponseUtil(responseCode, responseBody);
        return responseUtil;
    }


    @Override
    public ResponseUtil checkForXSS() throws BaseException {
        String json = utility.convertMovieObjectToJSONString(TEST_JAVASCRIPT_STRING, EMPTY_STRING);
        response = utility.postMovie(json, httpHeaders);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        responseUtil = new ResponseUtil(responseCode, responseBody);
        return responseUtil;
    }


    @Override
    public ResponseUtil addMovie() throws BaseException {
        String json = utility.convertMovieObjectToJSONString(MOVIE_NAME, MOVIE_DESC);
        response = utility.postMovie(json, httpHeaders);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        responseUtil = new ResponseUtil(responseCode, responseBody);
        return responseUtil;
    }

    @Override
    public ResponseUtil addSameMovieAgain() throws BaseException {
        String json = utility.convertMovieObjectToJSONString(MOVIE_NAME, MOVIE_DESC);
        response = utility.postMovie(json, httpHeaders);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        responseUtil = new ResponseUtil(responseCode, responseBody);
        return responseUtil;
    }

}
