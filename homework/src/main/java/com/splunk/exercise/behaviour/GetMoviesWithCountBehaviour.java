package com.splunk.exercise.behaviour;

import com.splunk.exercise.Ibehaviour.IGetMoviesWithCountBehaviour;
import com.splunk.exercise.util.Utility;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static com.splunk.exercise.util.Constants.HIGH_COUNT;
import static com.splunk.exercise.util.Constants.MOVIE_SEARCH_QUERY;
import static com.splunk.exercise.util.Constants.NEGATIVE_COUNT;
import static com.splunk.exercise.util.Constants.FLOATING_PT_COUNT;
import static com.splunk.exercise.util.Constants.COUNT_AS_WORD;
import static com.splunk.exercise.util.Constants.SQL_INJECTION_STRING;

public class GetMoviesWithCountBehaviour implements IGetMoviesWithCountBehaviour {

    private String url;
    private ResponseEntity<String> response;
    private Utility utility;


    public GetMoviesWithCountBehaviour(Utility utility){
        this.utility = utility;
    }

    @Override
    public void sendNegativeCount(){
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY,NEGATIVE_COUNT);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
    }

    @Override
    public void sendHighCountValue(){
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY,HIGH_COUNT);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
    }

    @Override
    public void sendFloatingPointCount(){
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY,FLOATING_PT_COUNT);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
    }

    @Override
    public void sendCountAsWord(){
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY,COUNT_AS_WORD);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
    }

    @Override
    public void sqlInjectionWithCount(){
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY,SQL_INJECTION_STRING);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
    }

}
