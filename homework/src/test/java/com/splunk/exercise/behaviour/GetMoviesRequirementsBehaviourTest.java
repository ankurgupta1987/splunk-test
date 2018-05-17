package com.splunk.exercise.behaviour;

import com.splunk.exercise.exceptions.BaseException;
import com.splunk.exercise.model.ResponseUtil;
import com.splunk.exercise.util.Utility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetMoviesRequirementsBehaviourTest {

    private GetMoviesRequirementsBehaviour getMoviesRequirementsBehaviour;
    private Utility utility;
    private ResponseUtil responseUtil;

    @Before
    public void setUp() throws Exception {
        getMoviesRequirementsBehaviour = new GetMoviesRequirementsBehaviour(new Utility());
        getMoviesRequirementsBehaviour.setupDataForRequirements();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setupDataForRequirements() {
    }

    @Test
    public void checkDuplicateMovieImage() throws BaseException {
        boolean containsDuplicate = getMoviesRequirementsBehaviour.checkDuplicateMovieImage();
    }

    @Test
    public void checkIfPosterPathLinksAreValid() {
    }

    @Test
    public void checkForOrderOfMovies() {
    }

    @Test
    public void checkIfGenreIdSumGreaterThan400() {
    }

    @Test
    public void ifMovieTitlesContainsPalindrome() {
    }

    @Test
    public void checkIfTitleContainsAnotherTitle() {
    }
}