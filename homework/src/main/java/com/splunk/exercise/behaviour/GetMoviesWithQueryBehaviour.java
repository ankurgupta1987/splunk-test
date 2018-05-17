package com.splunk.exercise.behaviour;

import com.splunk.exercise.Ibehaviour.IGetMoviesWithQueryBehaviour;
import com.splunk.exercise.exceptions.BaseException;
import com.splunk.exercise.model.ResponseUtil;
import com.splunk.exercise.util.Utility;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static com.splunk.exercise.util.Constants.*;


public class GetMoviesWithQueryBehaviour implements IGetMoviesWithQueryBehaviour {

    private String url;
    private ResponseEntity<String> response;
    private Utility utility;
    private ResponseUtil responseUtil;

    public GetMoviesWithQueryBehaviour(Utility utility){
        this.utility = utility;
    }

    @Override
    public ResponseUtil sendOnlyCount() throws BaseException {
        url = utility.prepareUrl(null,COUNT_TWO);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        responseUtil = new ResponseUtil(responseCode, responseBody, headers);
        return responseUtil;
    }

    @Override
    public ResponseUtil sendQMalformed() throws BaseException{
        url = utility.prepareUrl(MALFORMED_QUERY, COUNT_TWO);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        responseUtil = new ResponseUtil(responseCode, responseBody, headers);
        return responseUtil;
    }

    @Override
    public ResponseUtil querySQLInjection() throws BaseException{
        url = utility.prepareUrl(SQL_INJECTION_STRING, COUNT_TWO);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        responseUtil = new ResponseUtil(responseCode, responseBody, headers);
        return responseUtil;
    }

    @Override
    public ResponseUtil sendQWildcard() throws BaseException{
        url = utility.prepareUrl(WILDCARD_STRING, COUNT_TWO);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        responseUtil = new ResponseUtil(responseCode, responseBody, headers);
        return responseUtil;
    }

    @Override
    public ResponseUtil useDiffVerb() throws BaseException{
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY, COUNT_TWO);
        response = utility.invokeRestAPI(url, false);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        responseUtil = new ResponseUtil(responseCode, responseBody, headers);
        return responseUtil;
    }

    @Override
    public ResponseUtil queryForLimitingCount()  throws BaseException {
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY, COUNT_TWO);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        int count = utility.checkMovieCount(responseBody);
        responseUtil = new ResponseUtil(responseCode, responseBody, headers);
        return responseUtil;
    }

    @Override
    public ResponseUtil queryEmptyString()  throws BaseException {
        url = utility.prepareUrl(EMPTY_STRING, COUNT_TWO);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        utility.checkMovieCount(responseBody);
        responseUtil = new ResponseUtil(responseCode, responseBody, headers);
        return responseUtil;
    }

}
