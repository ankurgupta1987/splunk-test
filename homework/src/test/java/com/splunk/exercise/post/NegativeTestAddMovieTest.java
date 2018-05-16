package com.splunk.exercise.post;

import com.splunk.exercise.model.PostMovieModel;
import com.splunk.exercise.util.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.splunk.exercise.model.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static com.splunk.exercise.util.Constants.MOVIE_API_URL;

public class NegativeTestAddMovieTest {

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
    }

    @Test
    public void paramsEmpty(){
        ResponseEntity<String> response = postEntity("","");
        assertEquals("Posting empty params should return 409 response code", response.getStatusCodeValue(), 409);
    }

    @Test
    public void oneParam(){
        ResponseEntity<String> response = postEntity("bat1man","");
        assertEquals("Posting one param empty should return 409 response code", response.getStatusCodeValue(), 409);
    }

    @Test
    public void secondParam(){
        ResponseEntity<String> response = postEntity("","best Movie");
        assertEquals("Posting one param empty should return 409 response code", response.getStatusCodeValue(), 409);
    }

    @Test
    public void xssInjection(){
        ResponseEntity<String> response = postEntity("<script><button onclick='clickHere()'>batman wins</button></script>","best Movie");
        assertEquals("Posting script in param should return 200 response code and should sanitize input", response.getStatusCodeValue(), 200);
    }

    @Test
    public void incorrectJson(){

    }

    @Test
    public void multipleMovies(){
        PostMovieModel[] arr = {prepareEntity("batman1","good movie"), prepareEntity("batman2","good movie2")};
        ResponseEntity<String> postResponse = restTemplate.postForEntity(MOVIE_API_URL, arr, String.class);
    }

    @Test
    public void addMovieTwice(){

    }

    public ResponseEntity<String> postEntity(String name, String description){
        ResponseEntity<String> postResponse = restTemplate.postForEntity(MOVIE_API_URL, prepareEntity(name, description), String.class);
        return postResponse;
    }

    public PostMovieModel prepareEntity(String name, String description){
        PostMovieModel movie = new PostMovieModel();
        movie.setName(name);
        movie.setDescription(description);
        return movie;
    }

}