package com.splunk.exercise.behaviour;

import com.splunk.exercise.Ibehaviour.IGetMoviesRequirementsBehaviour;
import com.splunk.exercise.util.Utility;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

/**
 * Class to verify the requirements
 */
public class GetMoviesRequirementsBehaviour implements IGetMoviesRequirementsBehaviour {

    private String url;
    private ResponseEntity<String> response;
    private Utility utility;
    private String responseBody;

    public GetMoviesRequirementsBehaviour(Utility utility){
        this.utility = utility;
    }

    @Override
    public void setupDataForRequirements() throws IOException{
        url = utility.prepareUrl("batman","0");
        response = utility.invokeRestAPI(url, true);
        int responseCode = utility.getResponseStatusCode(response);
        responseBody = utility.getResponseBody(response);
    }

    /**
     * Requirement SPL-001: No two movies should have the same image
     */
    @Override
    public boolean checkDuplicateMovieImage() throws IOException{
        boolean areDuplicateImagesPresent = utility.checkForTheDuplicateMovieImage(responseBody);
        return areDuplicateImagesPresent;
    }

    /**
     * Requirement SPL-002: Check if the poster path links are valid
     */
    @Override
    public boolean checkIfPosterPathLinksAreValid() {
        boolean arePosterPathLinksValid = utility.checkIfPosterPathLinksAreValid(responseBody);
        return arePosterPathLinksValid;
    }

    /**
     * Requirement SPL-003: Sorting Requirement
     */
    @Override
    public boolean checkForOrderOfMovies() {
        boolean isMovieOrderAsRequired = utility.checkForOrderOfMovies(responseBody);
        return isMovieOrderAsRequired;
    }

    /**
     * Requirement SPL-004: The number of movies whose sum of "genre_ids" > 400
     * should be no more than 7
     */
    @Override
    public boolean checkIfGenreIdSumGreaterThan400() {
        boolean isSumGreater = utility.checkIfGenreIdSumGreaterThan400(responseBody);
        return isSumGreater;
    }

    /**
     * Requirement SPL-005: At least one movie whose title has a palindrome in it.
     */
    @Override
    public boolean ifMovieTitlesContainsPalindrome() {
        boolean isPalindromePresent = utility.ifMovieTitlesContainsPalindrome(responseBody);
        return isPalindromePresent;
    }


    /**
     * Requirement SPL-006: At least two movies whose title contain the title of another movie.
     */
    @Override
    public boolean checkIfTitleContainsAnotherTitle() throws IOException {
        boolean isTitlePresentInAnotherTitle = utility.checkIfTitleContainsAnotherTitle(responseBody);
        return isTitlePresentInAnotherTitle;
    }
}
