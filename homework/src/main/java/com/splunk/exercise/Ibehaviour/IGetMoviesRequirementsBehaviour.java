package com.splunk.exercise.Ibehaviour;

import java.io.IOException;

public interface IGetMoviesRequirementsBehaviour {
    void setupDataForRequirements() throws IOException;

    boolean checkDuplicateMovieImage() throws IOException;

    boolean checkIfPosterPathLinksAreValid();

    boolean checkForOrderOfMovies();

    boolean checkIfGenreIdSumGreaterThan400();

    boolean ifMovieTitlesContainsPalindrome();

    boolean checkIfTitleContainsAnotherTitle() throws IOException;
}
