package com.splunk.test.homework.consume;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.splunk.test.homework.util.Utility;

import static org.junit.Assert.assertEquals;

public class NegativeTestGetMovieCount {

    private RestTemplate restTemplate;
    private ResponseEntity<String> response;
    private String url;
    private HttpEntity entity;
    private HttpHeaders headers;

    @Before
    public void setUp() throws Exception {
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.set("Accept", "application/json");
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
    public void negativeCount() {
        url = Utility.prepareUrl("batman","-2");
        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertEquals("Count value negative should result in 400 response code", response.getStatusCodeValue(), 400);
    }

    @Test
    public void highCount() {
        url = Utility.prepareUrl("batman","9999999999999999999999999999999999999999999999999999999999999999999999");
        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertEquals("Count value high should result in 400 response code", response.getStatusCodeValue(), 400);
    }

    @Test
    public void floatingNumCount() {
        url = Utility.prepareUrl("batman","9.2");
        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertEquals("Count as floating point should result in 400 response code", response.getStatusCodeValue(), 400);
    }

    @Test
    public void countAsString() {
        url = Utility.prepareUrl("batman","Two");
        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertEquals("Count as string should result in 400 response code", response.getStatusCodeValue(), 400);
    }

    @Test
    public void countEmptyString() {
        url = Utility.prepareUrl("batman","");
        response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        assertEquals("Count empty should result in 400 response code", response.getStatusCodeValue(), 400);
    }

}