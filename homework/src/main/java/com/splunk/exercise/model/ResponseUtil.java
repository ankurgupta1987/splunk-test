package com.splunk.exercise.model;

import org.springframework.http.HttpHeaders;

public class ResponseUtil {

    private int responseCode;
    private String responseBody;
    private HttpHeaders headers;

    public ResponseUtil(int responseCode, String responseBody){
        this.responseCode = responseCode;
        this.responseBody = responseBody;
    }

    public ResponseUtil(int responseCode, String responseBody, HttpHeaders headers){
        this.responseCode = responseCode;
        this.responseBody = responseBody;
        this.headers = headers;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }
}
