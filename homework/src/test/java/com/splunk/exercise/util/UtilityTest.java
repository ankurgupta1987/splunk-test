package com.splunk.exercise.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.splunk.exercise.util.Constants.*;
import static com.splunk.exercise.util.Constants.AMPERSAND;
import static com.splunk.exercise.util.Constants.COUNT_PARAM;
import static org.junit.Assert.*;

public class UtilityTest {

    private Utility utility;

    @Before
    public void setUp() throws Exception {
        utility = new Utility();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void prepareUrl() {
        String url = utility.prepareUrl(MOVIE_SEARCH_QUERY, "0");
        assertTrue(url != null);
        assertTrue(url.equals(MOVIE_API_URL+"?q=batman&count=0"));
    }


    @Test
    public void invokeRestAPI() {

    }

    @Test
    public void getResponseStatusCode() {
    }

    @Test
    public void getResponseBody() {
    }

    @Test
    public void getResponseHeader() {
    }

    @Test
    public void checkMovieCount() {
    }

    @Test
    public void checkForTheDuplicateMovieImage() {
    }

    @Test
    public void checkIfPosterPathIsValid() {
    }

    @Test
    public void isMovieOrderCorrect() {
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

    @Test
    public void titleContainsAnotherTitleUtil() {
    }

    @Test
    public void titleHasPalindrome() {
    }

    @Test
    public void isPalindrome() {
    }

    @Test
    public void validateIfMovieOrderIsSame() {
    }

    @Test
    public void checkDuplicateImageUtil() {
    }

    @Test
    public void extractMovieImageName() {
    }

    @Test
    public void arePosterPathsValid() {
    }

    @Test
    public void validatePosterPath() {
    }

    @Test
    public void invokeRestAPI1() {
    }

    @Test
    public void getResponseStatusCode1() {
    }

    @Test
    public void getResponseBody1() {
    }

    @Test
    public void getResponseHeader1() {
    }

    @Test
    public void checkMovieCount1() {
    }

    @Test
    public void checkForTheDuplicateMovieImage1() {
    }

    @Test
    public void checkIfPosterPathLinksAreValid() {
    }

    @Test
    public void checkForOrderOfMovies() {
    }

    @Test
    public void checkIfGenreIdSumGreaterThan4001() {
    }

    @Test
    public void ifMovieTitlesContainsPalindrome1() {
    }

    @Test
    public void checkIfTitleContainsAnotherTitle1() {
    }

    @Test
    public void titleContainsAnotherTitleUtil1() {
    }

    @Test
    public void titleHasPalindrome1() {
    }

    @Test
    public void isPalindrome1() {
    }

    @Test
    public void validateIfMovieOrderIsSame1() {
    }

    @Test
    public void checkDuplicateImageUtil1() {
    }

    @Test
    public void extractMovieImageName1() {
    }

    @Test
    public void arePosterPathsValid1() {
    }

    @Test
    public void validatePosterPath1() {
    }

    @Test
    public void convertMovieObjectToJSONString() {
    }

    @Test
    public void postMovie() {
    }

    @Test
    public void prepareUrl1() {
    }

    @Test
    public void invokeRestAPI2() {
    }

    @Test
    public void getResponseStatusCode2() {
    }

    @Test
    public void getResponseBody2() {
    }

    @Test
    public void getResponseHeader2() {
    }

    @Test
    public void checkMovieCount2() {
    }

    @Test
    public void checkForTheDuplicateMovieImage2() {
    }

    @Test
    public void checkIfPosterPathLinksAreValid1() {
    }

    @Test
    public void checkForOrderOfMovies1() {
    }

    @Test
    public void checkIfGenreIdSumGreaterThan4002() {
    }

    @Test
    public void ifMovieTitlesContainsPalindrome2() {
    }

    @Test
    public void checkIfTitleContainsAnotherTitle2() {
    }

    @Test
    public void titleContainsAnotherTitleUtil2() {
    }

    @Test
    public void titleHasPalindrome2() {
    }

    @Test
    public void isPalindrome2() {
    }

    @Test
    public void validateIfMovieOrderIsSame2() {
    }

    @Test
    public void checkDuplicateImageUtil2() {
    }

    @Test
    public void extractMovieImageName2() {
    }

    @Test
    public void arePosterPathsValid2() {
    }

    @Test
    public void validatePosterPath2() {
    }

    @Test
    public void convertMovieObjectToJSONString1() {
    }

    @Test
    public void postMovie1() {
    }

    @Test
    public void checkForResultsInReponse() {
    }

    @Test
    public void parseAddMovieResponse() {
    }


    public String prepareUrlInTestClass(String q, String count) {
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
}