package com.splunk.exercise.Ibehaviour;

import com.splunk.exercise.exceptions.BaseException;

import java.io.IOException;

public interface IGetMoviesRequirementsBehaviour {
    void setupDataForRequirements() throws IOException, BaseException;

    boolean checkDuplicateMovieImage() throws IOException, BaseException;

    boolean checkIfPosterPathLinksAreValid() throws BaseException;

    boolean checkForOrderOfMovies() throws BaseException;

    boolean checkIfGenreIdSumGreaterThan400() throws BaseException;

    boolean ifMovieTitlesContainsPalindrome() throws BaseException;

    boolean checkIfTitleContainsAnotherTitle() throws IOException, BaseException;
}
