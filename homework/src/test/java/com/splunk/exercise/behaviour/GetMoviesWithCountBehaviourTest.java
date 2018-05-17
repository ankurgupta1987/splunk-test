package com.splunk.exercise.behaviour;

import com.splunk.exercise.model.ResponseUtil;
import com.splunk.exercise.util.Utility;
import org.junit.*;
import org.springframework.http.HttpStatus;

import static com.splunk.exercise.util.Constants.EMPTY_STRING;
import static org.junit.Assert.*;

public class GetMoviesWithCountBehaviourTest {

    private GetMoviesWithCountBehaviour getMoviesWithCountBehaviour;
    private Utility utility;
    private ResponseUtil responseUtil;

    @Before
    public void setUp() throws Exception {
        getMoviesWithCountBehaviour = new GetMoviesWithCountBehaviour(new Utility());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sendNegativeCount() {
        responseUtil = getMoviesWithCountBehaviour.sendNegativeCount();
        assertNotNull(responseUtil);
        assertEquals("Count value negative should result in 400 response code", responseUtil.getResponseCode(), HttpStatus.BAD_REQUEST.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void sendHighCountValue() {
        responseUtil = getMoviesWithCountBehaviour.sendHighCountValue();
        assertNotNull(responseUtil);
        assertEquals("Count value beyond should result in 400 response code", responseUtil.getResponseCode(), HttpStatus.BAD_REQUEST.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void sendFloatingPointCount() {
        responseUtil = getMoviesWithCountBehaviour.sendFloatingPointCount();
        assertNotNull(responseUtil);
        assertEquals("Count as floating point should result in 400 response code", responseUtil.getResponseCode(), HttpStatus.BAD_REQUEST.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void sendCountAsWord() {
        responseUtil = getMoviesWithCountBehaviour.sendCountAsWord();
        assertNotNull(responseUtil);
        assertEquals("Count as a word should result in 400 response code", responseUtil.getResponseCode(), HttpStatus.BAD_REQUEST.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void sqlInjectionWithCount() {
        responseUtil = getMoviesWithCountBehaviour.sqlInjectionWithCount();
        assertNotNull(responseUtil);
        assertEquals("Sending sql injection query in count should result in 400 response code", responseUtil.getResponseCode(), HttpStatus.BAD_REQUEST.value());
        assertNotEquals("Response body should mention the reason for the response code", responseUtil.getResponseBody(), EMPTY_STRING);
    }

    @Test
    public void emptyCount() {
        responseUtil = getMoviesWithCountBehaviour.emptyCount();
        assertNotNull(responseUtil);
        assertEquals("Sending empty count should result in 200 response code", responseUtil.getResponseCode(), HttpStatus.OK.value());
        assertNotEquals("Response body should contain a valid json", responseUtil.getResponseBody(), EMPTY_STRING);
    }
}