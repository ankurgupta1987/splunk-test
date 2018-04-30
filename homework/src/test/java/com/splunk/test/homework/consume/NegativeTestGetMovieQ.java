package com.splunk.test.homework.consume;

import com.splunk.test.homework.util.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class NegativeTestGetMovieQ {

    private RestTemplate restTemplate;
    private ResponseEntity<String> response;
    private String url;
    private HttpEntity entity;
    private HttpHeaders headers;

    @Before
    public void setUp() throws Exception {
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        entity = new HttpEntity(headers);
    }

    @After
    public void tearDown() throws Exception {
        restTemplate = null;
        response = null;
        url = null;
        entity = null;
        headers = null;
    }

    @Test
    public void onlyCount() {
        url = Utility.prepareUrl(null,"2");
        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertEquals("Missing required param should result in 404 response code", response.getStatusCodeValue(), 404);
    }

    @Test
    public void qMalformed() {
        url = Utility.prepareUrl("P/{><","2");
        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertEquals("Malformed should result in 400 response code", response.getStatusCodeValue(), 400);
    }

    @Test
    public void qSQLInjection() {
        url = Utility.prepareUrl("'%20or%20'1'='1","2");
        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertEquals("SQL injection should result in 400 response code with empty body", response.getStatusCodeValue(), 400);
        assertTrue("Response body should be empty", response.getBody().isEmpty());
    }

    @Test
    public void qWildcard() {
        url = Utility.prepareUrl("bat*","2");
        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertEquals("Wildcard should result in 200 response code with empty body", response.getStatusCodeValue(), 200);
        assertTrue("Response body should be empty", response.getBody().isEmpty());
    }

    @Test
    public void qWithDiffVerb() {
        url = Utility.prepareUrl("batman","2");
        response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        assertEquals("POST request should result in 405 response code", response.getStatusCodeValue(), 405);
    }
}