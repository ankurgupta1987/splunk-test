package com.splunk.exercise.behaviour;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.splunk.exercise.exceptions.BaseException;
import com.splunk.exercise.model.ResponseUtil;
import com.splunk.exercise.util.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static com.splunk.exercise.util.Constants.EMPTY_STRING;
import static org.junit.Assert.*;

public class PostMovieBehaviourTest {

    private PostMovieBehaviour postMovieBehaviour;
    private Utility utility;
    private ResponseUtil responseUtil;

    @Before
    public void setUp() throws Exception {
        postMovieBehaviour = new PostMovieBehaviour(new Utility());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void postRequiredFieldsEmpty() throws BaseException {
        responseUtil = postMovieBehaviour.postRequiredFieldsEmpty();
        assertNotNull(responseUtil);
        assertEquals("Empty mandatory fields should result in 400 response code", responseUtil.getResponseCode(), HttpStatus.BAD_REQUEST.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void postDescFieldEmpty() throws BaseException {
        responseUtil = postMovieBehaviour.postDescFieldEmpty();
        assertNotNull(responseUtil);
        assertEquals("Empty mandatory field should result in 400 response code", responseUtil.getResponseCode(), HttpStatus.BAD_REQUEST.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void postNameFieldEmpty() throws BaseException {
        responseUtil = postMovieBehaviour.postNameFieldEmpty();
        assertNotNull(responseUtil);
        assertEquals("Empty mandatory field should result in 400 response code", responseUtil.getResponseCode(), HttpStatus.BAD_REQUEST.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void postMalformedJson()throws BaseException  {
        responseUtil = postMovieBehaviour.postMalformedJson();
        assertNotNull(responseUtil);
        assertEquals("Malformed JSON should result in 400 response code", responseUtil.getResponseCode(), HttpStatus.BAD_REQUEST.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void inCorrectHeader() throws BaseException {
        responseUtil = postMovieBehaviour.inCorrectHeader();
        assertNotNull(responseUtil);
        assertEquals("In correct header should result in 400 response code", responseUtil.getResponseCode(), HttpStatus.BAD_REQUEST.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void checkForXSS() throws BaseException {
        responseUtil = postMovieBehaviour.checkForXSS();
        assertNotNull(responseUtil);
        assertEquals("Sending javascript in attribute should result in 200 response code", responseUtil.getResponseCode(), HttpStatus.OK.value());
//        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void addMovie() throws BaseException {
        responseUtil = postMovieBehaviour.addMovie();
        assertNotNull(responseUtil);
        assertTrue("Adding a movie with correct details can result in 200 or 409 response code", responseUtil.getResponseCode() == HttpStatus.CONFLICT.value()
        || responseUtil.getResponseCode() == HttpStatus.OK.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void addSameMovieAgain() throws BaseException {
        responseUtil = postMovieBehaviour.addSameMovieAgain();
        assertNotNull(responseUtil);
        assertEquals("Adding same movie should result in 409 response code", responseUtil.getResponseCode(), HttpStatus.CONFLICT.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }
}