package com.splunk.test.homework.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Utility {

    public static final String MOVIE_API_URL = "https://splunk.mocklab.io/movies";
    public static final String QUESTION_MARK = "?";
    public static final String AMPERSAND = "&";
    public static final String Q_PARAM = "q=";
    public static final String COUNT_PARAM = "count=";
    public static final String ACCEPT = "Accept";
    public static final String APPLICATION_JSON = "application/json";

    private RestTemplate restTemplate;
    private ResponseEntity<String> response;

    public static String prepareUrl(String q, String count) {
        StringBuilder builder = new StringBuilder();
        builder.append(MOVIE_API_URL).append(QUESTION_MARK);
        if (q != null) {
            builder.append(Q_PARAM).append(q);
        }
        if (count != null) {
            if (q != null) {
                builder.append(AMPERSAND);
            }
            builder.append(COUNT_PARAM).append(count);
        }
        return builder.toString();
    }

    public static ResponseEntity<String> invokeRestAPI(String url, boolean isGet){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(ACCEPT, APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response;
    }

    public static int getResponseStatusCode(ResponseEntity<?> response){
        if(response != null){
            return response.getStatusCodeValue();
        }
        return -1;
    }

    public static Object getResponseBody(ResponseEntity<?> response){
        if(response != null){
            return response.getBody();
        }
        return null;
    }

    public static HttpHeaders getResponseHeader(ResponseEntity<?> response){
        if(response != null){
            return response.getHeaders();
        }
        return null;
    }

}
