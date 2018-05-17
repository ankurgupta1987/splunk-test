package com.splunk.exercise.behaviour;

import com.splunk.exercise.exceptions.BaseException;
import com.splunk.exercise.model.ResponseUtil;
import com.splunk.exercise.util.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import java.io.IOException;

import static com.splunk.exercise.util.Constants.EMPTY_STRING;
import static org.junit.Assert.*;

public class GetMoviesWithQueryBehaviourTest {

    private GetMoviesWithQueryBehaviour getMoviesWithQueryBehaviour;
    private Utility utility;
    private ResponseUtil responseUtil;

    @Before
    public void setUp() throws Exception {
        getMoviesWithQueryBehaviour = new GetMoviesWithQueryBehaviour(new Utility());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sendOnlyCount() throws BaseException {
        responseUtil = getMoviesWithQueryBehaviour.sendOnlyCount();
        assertNotNull(responseUtil);
        assertTrue("Missing mandatory attribute can result in 400 or 422 response code", responseUtil.getResponseCode() == HttpStatus.BAD_REQUEST.value()
                || responseUtil.getResponseCode() == HttpStatus.UNPROCESSABLE_ENTITY.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void sendQMalformed() throws BaseException {
        responseUtil = getMoviesWithQueryBehaviour.sendQMalformed();
        assertNotNull(responseUtil);
        assertEquals("Malformed attribute should result in 422 response code", responseUtil.getResponseCode(), HttpStatus.UNPROCESSABLE_ENTITY.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void querySQLInjection() throws BaseException {
        responseUtil = getMoviesWithQueryBehaviour.querySQLInjection();
        assertNotNull(responseUtil);
        assertEquals("Malformed attribute should result in 422 response code", responseUtil.getResponseCode(), HttpStatus.UNPROCESSABLE_ENTITY.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
        assertFalse("Response body should not contain movies data", utility.checkForResultsInReponse(responseUtil.getResponseBody()));
    }


    @Test
    public void sendQWildcard() throws BaseException {
        responseUtil = getMoviesWithQueryBehaviour.sendQWildcard();
        assertNotNull(responseUtil);
        assertEquals("Sending wildcard character should result in 200 response code", responseUtil.getResponseCode(), HttpStatus.OK.value());
        assertFalse("Response body should not contain movies data", utility.checkForResultsInReponse(responseUtil.getResponseBody()));
    }

    @Test
    public void useDiffVerb() throws BaseException {
        responseUtil = getMoviesWithQueryBehaviour.useDiffVerb();
        assertNotNull(responseUtil);
        assertEquals("sending get request as post should result in 405 response code", responseUtil.getResponseCode(), HttpStatus.METHOD_NOT_ALLOWED.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void queryForLimitingCount() throws BaseException {
        responseUtil = getMoviesWithQueryBehaviour.queryForLimitingCount();
        assertNotNull(responseUtil);
        assertEquals("Sending count as 2 should result in 200 response code", responseUtil.getResponseCode(), HttpStatus.OK.value());
        assertEquals("Response body should contain only 2 movies", utility.checkMovieCount(responseUtil.getResponseBody()), 2);
    }

    @Test
    public void queryEmptyString() throws  BaseException {
        responseUtil = getMoviesWithQueryBehaviour.queryEmptyString();
        assertNotNull(responseUtil);
        assertEquals("Missing mandatory attribute value should result in 422 response code", responseUtil.getResponseCode(), HttpStatus.UNPROCESSABLE_ENTITY.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }
}