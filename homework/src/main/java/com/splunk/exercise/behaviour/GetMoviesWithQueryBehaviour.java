package com.splunk.exercise.behaviour;

import com.splunk.exercise.Ibehaviour.IGetMoviesWithQueryBehaviour;
import com.splunk.exercise.util.Utility;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static com.splunk.exercise.util.Constants.*;


public class GetMoviesWithQueryBehaviour implements IGetMoviesWithQueryBehaviour {

    private String url;
    private ResponseEntity<String> response;
    private Utility utility;

    public GetMoviesWithQueryBehaviour(Utility utility){
        this.utility = utility;
    }

    @Override
    public void sendOnlyCount(){
        url = utility.prepareUrl(null,COUNT_TWO);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
    }

    @Override
    public void sendQMalformed(){
        url = utility.prepareUrl(MALFORMED_QUERY, COUNT_TWO);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
    }

    @Override
    public void querySQLInjection(){
        url = utility.prepareUrl(SQL_INJECTION_STRING, COUNT_TWO);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
    }

    @Override
    public void sendQWildcard(){
        url = utility.prepareUrl(WILDCARD_STRING, COUNT_TWO);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
    }

    @Override
    public void useDiffVerb(){
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY, COUNT_TWO);
        response = utility.invokeRestAPI(url, false);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
    }

    @Override
    public void queryForLimitingCount() throws IOException {
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY, COUNT_TWO);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        int count = utility.checkMovieCount(responseBody);
    }

    @Override
    public void queryEmptyString() throws IOException {
        url = utility.prepareUrl(EMPTY_STRING, COUNT_TWO);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        utility.checkMovieCount(responseBody);
    }

}
