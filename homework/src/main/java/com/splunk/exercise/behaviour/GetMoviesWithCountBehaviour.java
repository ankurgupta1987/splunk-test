package com.splunk.exercise.behaviour;

import com.splunk.exercise.Ibehaviour.IGetMoviesWithCountBehaviour;
import com.splunk.exercise.model.ResponseUtil;
import com.splunk.exercise.util.Utility;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static com.splunk.exercise.util.Constants.*;

public class GetMoviesWithCountBehaviour implements IGetMoviesWithCountBehaviour {

    private String url;
    private ResponseEntity<String> response;
    private Utility utility;
    private ResponseUtil responseUtil;

    public GetMoviesWithCountBehaviour(Utility utility){
        this.utility = utility;
    }

    @Override
    public ResponseUtil sendNegativeCount(){
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY,NEGATIVE_COUNT);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        responseUtil = new ResponseUtil(responseCode, responseBody, headers);
        return responseUtil;
    }

    @Override
    public ResponseUtil sendHighCountValue(){
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY,HIGH_COUNT);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        responseUtil = new ResponseUtil(responseCode, responseBody, headers);
        return responseUtil;
    }

    @Override
    public ResponseUtil sendFloatingPointCount(){
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY,FLOATING_PT_COUNT);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        responseUtil = new ResponseUtil(responseCode, responseBody, headers);
        return responseUtil;
    }

    @Override
    public ResponseUtil sendCountAsWord(){
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY,COUNT_AS_WORD);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        responseUtil = new ResponseUtil(responseCode, responseBody, headers);
        return responseUtil;
    }

    @Override
    public ResponseUtil sqlInjectionWithCount(){
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY,SQL_INJECTION_STRING);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        responseUtil = new ResponseUtil(responseCode, responseBody, headers);
        return responseUtil;
    }

    @Override
    public ResponseUtil emptyCount(){
        url = utility.prepareUrl(MOVIE_SEARCH_QUERY,EMPTY_STRING);
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        String responseBody = utility.getResponseBody(response);
        HttpHeaders headers =  utility.getResponseHeader(response);
        responseUtil = new ResponseUtil(responseCode, responseBody, headers);
        return responseUtil;
    }


}
