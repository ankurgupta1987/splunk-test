package com.splunk.test.homework.behaviour;

import com.splunk.test.homework.model.Movie;

import java.util.Comparator;

public class MovieTitleLengthComparator implements Comparator<Movie.Results> {
    @Override
    public int compare(Movie.Results o1, Movie.Results o2) {
        String movieTitle1 = o1.getTitle();
        String movieTitle2 = o2.getTitle();

        if(movieTitle1.length() < movieTitle2.length()){
            return -1;
        }
        else if(movieTitle1.length() > movieTitle2.length()){
            return 1;
        }
        return 0;
    }
}
