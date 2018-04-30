package com.splunk.test.homework.util;

import com.splunk.test.homework.model.Movie;

import java.util.ArrayList;

public class UtilityTest {

    @Test
    public void testPrepareUrl(){
        String expected = "some expected url from below method";
       String outcome = Utility.prepareUrl("", "");
       assert outcome.equals(expected);
    }

    @Test
    public void testGetMovieCountWithMoreThanOrEqualToGivenSum(){
        int expected = 1;
        int outcome = Utility.getMovieCountWithMoreThanOrEqualToGivenSum(new ArrayList<Movie>(), 1000);
        assert expected == outcome;
    }

}
