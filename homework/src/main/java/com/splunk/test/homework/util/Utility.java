package com.splunk.test.homework.util;

import com.splunk.test.homework.model.Movie;

import java.util.List;

public class Utility {

    private static final String MOVIE_API_URL = "https://splunk.mocklab.io/movies";
    private static final String QUESTION_MARK = "?";
    private static final String AMPERSAND = "&";
    private static final String Q_PARAM = "q=";
    private static final String COUNT_PARAM = "count=";

    public static String prepareUrl(String q, String count) {
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

    public static int getMovieCountWithMoreThanOrEqualToGivenSum(List<Movie> movies, int totalSum) {
        // run some logic
        return 10;
    }
}
